package com.heitor.personapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(Long id) {
        super("Unable to find customer ID: " + id);
    }

    public PersonNotFoundException(String firstName) {
        super("Unable to locate customer by name: " + firstName);
    }
}
