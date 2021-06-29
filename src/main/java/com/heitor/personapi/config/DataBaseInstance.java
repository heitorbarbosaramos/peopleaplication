package com.heitor.personapi.config;

import com.heitor.personapi.entity.Person;
import com.heitor.personapi.entity.PersonRole;
import com.heitor.personapi.entity.Phone;
import com.heitor.personapi.enums.PhoneType;
import com.heitor.personapi.service.PersonRoleService;
import com.heitor.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DataBaseInstance {

    @Autowired
    private PersonRoleService serviceRole;

    @Autowired
    private PersonService servicePerson;

    public void intanceRoles(){
        serviceRole.insert("ADMIN", "administrator");
        serviceRole.insert("USER", "user");
    }

    public void instancePerson(){
        Person person1 = new Person();
        person1.setFirstName("Antonio");
        person1.setLastName("Marinho");
        person1.setPassword("123abc");
        person1.setBirthDate(LocalDate.of(1988, 07, 06));
        person1.setCpf("450.363.990-05");

        Phone phone = new Phone();
        phone.setNumber("(11) 98946-0099");
        phone.setType(PhoneType.MOBILE);
        person1.getPhones().add(phone);

        for(PersonRole x : serviceRole.findAll()){
            person1.getRoles().add(x);
        }
        servicePerson.insert(person1);
    }
}
