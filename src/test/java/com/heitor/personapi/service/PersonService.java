package com.heitor.personapi.service;

import com.heitor.personapi.repository.PersonRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PersonService {

    @Mock
    private PersonRepository repo;

    @InjectMocks
    private PersonService service;
}
