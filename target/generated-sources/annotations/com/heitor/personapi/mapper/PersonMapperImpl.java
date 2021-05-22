package com.heitor.personapi.mapper;

import com.heitor.personapi.dto.request.PersonDTO;
import com.heitor.personapi.entity.Person;
import com.heitor.personapi.entity.Phone;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-22T18:58:26-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (Amazon.com Inc.)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public Person toModel(PersonDTO personDTO) {
        if ( personDTO == null ) {
            return null;
        }

        Person person = new Person();

        person.setBirthDate( personDTO.getBirthDate() );
        person.setId( personDTO.getId() );
        person.setFirstName( personDTO.getFirstName() );
        person.setLastName( personDTO.getLastName() );
        person.setCpf( personDTO.getCpf() );
        List<Phone> list = personDTO.getPhones();
        if ( list != null ) {
            person.setPhones( new ArrayList<Phone>( list ) );
        }

        return person;
    }

    @Override
    public PersonDTO toDTO(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setId( person.getId() );
        personDTO.setFirstName( person.getFirstName() );
        personDTO.setLastName( person.getLastName() );
        personDTO.setCpf( person.getCpf() );
        personDTO.setBirthDate( person.getBirthDate() );
        List<Phone> list = person.getPhones();
        if ( list != null ) {
            personDTO.setPhones( new ArrayList<Phone>( list ) );
        }

        return personDTO;
    }
}
