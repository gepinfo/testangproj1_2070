package com.geppetto.testangproj1.controller;

import com.geppetto.testangproj1.dto.PersonDto;
import com.geppetto.testangproj1.service.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


/**
* REST controller for managing Person
* Provides endpoints to create, update, delete, retrieve, and search for Person,
* as well as to handle file uploads and downloads associated with Person.
*/
@RestController
@RequestMapping("/testfeature")
@RequiredArgsConstructor
@Slf4j
public class PersonController {

   private final PersonService personService; 


@PostMapping
public ResponseEntity<PersonDto> createPerson(@Valid @RequestBody PersonDto personDto) {
    log.info("Enter into createPerson method");
    ResponseEntity<PersonDto> response =  ResponseEntity.status(HttpStatus.OK).body(personService.createPerson(personDto));
    log.info("Exit from createPerson method");
    return response;
}

@GetMapping
public ResponseEntity<Page<PersonDto>> getAllPerson(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "3") int size) {
    log.info("Enter into getAllPerson method");
    Page<PersonDto>personDtoPage = personService.getAllPerson(page, size);
    log.info("Exit from getAllPerson method");
    return new ResponseEntity<>(personDtoPage, HttpStatus.OK);
}

   
}
