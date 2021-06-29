package com.heitor.personapi.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data                   //para gerar os getteres e seteres
public class PersonRole implements GrantedAuthority {

    @Id
    private String nameRole;
    private String description;

    @Override
    public String getAuthority() {
        return nameRole;
    }
}
