package com.heitor.personapi.controller;

import com.heitor.personapi.dto.MessageResponseDTO;
import com.heitor.personapi.dto.request.PersonDTO;
import com.heitor.personapi.entity.Person;
import com.heitor.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/people")
public class PersonController {


    private PersonService servicePerson;

    @Autowired
    public PersonController(PersonService servicePerson) {
        this.servicePerson = servicePerson;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createdPerson(@RequestBody @Valid PersonDTO personDTO){
        MessageResponseDTO message = servicePerson.save(personDTO);
        return MessageResponseDTO.builder().message(message.getMessage()).build();
    }

    @GetMapping
    public List<PersonDTO> findAll(){
        return  servicePerson.findAll();
    }


}
