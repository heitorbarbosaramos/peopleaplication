package com.heitor.personapi.config;


import com.heitor.personapi.entity.Person;
import com.heitor.personapi.exception.PersonNotFoundException;
import com.heitor.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ImplementsUser implements UserDetailsService {

    @Autowired
    private PersonRepository repo;

    @Override
    public UserDetails loadUserByUsername(String firstName) throws UsernameNotFoundException {

        Person person = repo.findByFirstName(firstName);

        if(person == null){throw new PersonNotFoundException(firstName);}
        return new User(person.getFirstName(), person.getPassword(), true, true, true, true, person.getAuthorities());
    }
}
