package com.geppetto.testangproj1.service.serviceimpl;

import com.geppetto.testangproj1.dao.PersonDao;
import com.geppetto.testangproj1.dto.PersonDto;
import com.geppetto.testangproj1.exception.EntityNotFoundException;
import com.geppetto.testangproj1.model.Person;
import com.geppetto.testangproj1.service.PersonService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;


/**
* Implementation of the {@link PersonService} interface.
* Provides services related to Person, including CRUD operations and file uploads/downloads.
*/

@Service
@Slf4j
public class PersonServiceImpl implements PersonService {


    /**
     * Constructs a {@code PersonServiceImpl} with the specified DAO and MongoTemplate.
     *
     * @param personDao The DAO for accessing the data.
     * @param mongoTemplate The MongoTemplate for interacting with MongoDB.
     */
  private final PersonDao personDao;
  private final MongoTemplate mongoTemplate;

  public PersonServiceImpl(PersonDao  personDao, MongoTemplate mongoTemplate) {
    this. personDao =  personDao;
    this.mongoTemplate = mongoTemplate;
  }
    
    /**
     * Creates new person.
     *
     * @param personDto The {@link PersonDto} to be created.
     * @return The created {@link PersonDto}.
     */
  @Override
  public PersonDto  createPerson(PersonDto personDto) {
    log.info("Enter into createPerson method");
    Person person = new Person();
  BeanUtils.copyProperties(personDto, person);
  Person createdPerson= personDao.createPerson(person);
  BeanUtils.copyProperties(createdPerson, personDto);
  log.info("Exit from createPerson method");
  return personDto;
  }
    
    /**
     * Retrieves all person.
     *
     * @return A list of {@link PersonDto} representing all person.
     */
  @Override
  public Page<PersonDto>  getAllPerson(int page, int size) {
    log.info("Enter into getAllPerson method");
    Pageable pageable = (Pageable) PageRequest.of(page, size);
    Page<Person> personPage =personDao.getAllPerson(pageable);
    Page<PersonDto>personDtoPage = personPage.map(person -> {
    PersonDto personDto = PersonDto.builder().build();
    BeanUtils.copyProperties(person, personDto);
    return personDto;
    });
    log.info("Exit from getAllpersonmethod");
    return personDtoPage;
  }
    

}
