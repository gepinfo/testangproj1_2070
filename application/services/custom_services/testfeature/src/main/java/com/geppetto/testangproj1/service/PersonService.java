package com.geppetto.testangproj1.service;

import com.geppetto.testangproj1.dto.PersonDto;
import org.springframework.data.domain.Page;

public interface PersonService {

    PersonDto  createPerson(PersonDto personDto);

    Page<PersonDto>  getAllPerson(int page, int size);

}
