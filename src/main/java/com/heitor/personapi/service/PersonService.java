package com.heitor.personapi.service;

import com.heitor.personapi.dto.MessageResponseDTO;
import com.heitor.personapi.dto.request.PersonDTO;
import com.heitor.personapi.entity.Person;
import com.heitor.personapi.exception.PersonNotFoundException;
import com.heitor.personapi.mapper.PersonMapper;
import com.heitor.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository repo;

    private  final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService (PersonRepository personRepository){
        this.repo = personRepository;
    }

    public MessageResponseDTO save(PersonDTO personDto){
        Person object = repo.save(fromDto(personDto));
        return MessageResponseDTO.builder().message("created person with ID: " + object.getId()).build();
    }

    public Person fromDto(PersonDTO personDTO){
        return personMapper.toModel(personDTO);
    }

    public List<PersonDTO> findAll() {
        return repo.findAll().stream().map(personMapper::toDTO).collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) {
        return personMapper.toDTO(repo.findById(id).orElseThrow(() -> new PersonNotFoundException(id)));
    }


}
