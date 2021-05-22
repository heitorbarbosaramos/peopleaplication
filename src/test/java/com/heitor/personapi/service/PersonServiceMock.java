package com.heitor.personapi.service;

import com.heitor.personapi.dto.MessageResponseDTO;
import com.heitor.personapi.dto.request.PersonDTO;
import com.heitor.personapi.entity.Person;
import com.heitor.personapi.mapper.PersonMapper;
import com.heitor.personapi.repository.PersonRepository;
import com.heitor.personapi.utils.PersonUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

@ExtendWith(MockitoExtension.class)
public class PersonServiceMock {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSuccessSavedMessage() {

        PersonDTO personDTO = PersonUtils.createFakeDTO();
        MessageResponseDTO messageResponseDTO = personService.save(PersonUtils.createFakeDTO());
        assertEquals(messageResponseDTO, createExpectedSuccessMessage(personDTO.getId()));

    }

    private MessageResponseDTO createExpectedSuccessMessage(Long savedPersonId) {
        return MessageResponseDTO.builder()
                .message("created person with ID: " + savedPersonId)
                .build();
    }
}
