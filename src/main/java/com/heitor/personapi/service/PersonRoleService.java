package com.heitor.personapi.service;

import com.heitor.personapi.entity.PersonRole;
import com.heitor.personapi.repository.PersonRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonRoleService {

    private PersonRoleRepository repo;

    @Autowired
    public PersonRoleService(PersonRoleRepository repo){
        this.repo = repo;
    }

    public PersonRole save(PersonRole personRole){
        personRole = repo.save(personRole);
        return personRole;
    }

    public PersonRole insert(String nameRole, String description){
        PersonRole personRole = new PersonRole();
        personRole.setNameRole(nameRole);
        personRole.setDescription(description);
        personRole = save(personRole);
        return personRole;
    }

    public List<PersonRole> findAll(){
        return repo.findAll();
    }
}
