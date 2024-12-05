package com.geppetto.testangproj1.dao.daoimpl;

import com.geppetto.testangproj1.repository.PersonRepository;
import com.geppetto.testangproj1.dao.PersonDao;

import com.geppetto.testangproj1.model.Person;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
* Implementation of the {@link PersonDao} interface.
* Provides methods to interact with the {@link PersonRepository} for CRUD operations on {@link Person } entities.
*/
@Service
public class PersonDaoImpl implements PersonDao {

    private final PersonRepository personRepository;
    /**
     * Constructs a new {@code PersonDaoImpl} with the specified repository.
     *
     * @param personRepository The repository used for accessing {@link Person} entities. Must not be {@code null}.
     */
    public PersonDaoImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * Creates new person.
     *
     * @param person The {@link Person} entity to create. Must not be {@code null}.
     * @return The created {@link Person} entity.
     */
    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }


     /**
     * Retrieves all person from the repository.
     *
     * @return A list of all {@link Person} entities.
     */
    @Override
    public Page<Person> getAllPerson(Pageable pageable) {
        return personRepository.findAll(pageable);
    }


}


