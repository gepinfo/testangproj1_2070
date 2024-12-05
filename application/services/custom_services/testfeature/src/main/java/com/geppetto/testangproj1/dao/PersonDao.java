package com.geppetto.testangproj1.dao;

import com.geppetto.testangproj1.model.Person;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface PersonDao {

    Person createPerson(Person person);

    Page<Person> getAllPerson(Pageable pageable);

}

