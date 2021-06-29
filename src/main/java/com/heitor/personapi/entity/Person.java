package com.heitor.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.*;

@Entity
@Data                   //para gerar os getteres e seteres
@Builder                //Builder vai nos prover uma maneira de criar objetos sem precisarmos de construtores e sem métodos setters em nossas classes
@AllArgsConstructor     //insere os construtores automaticamente
@NoArgsConstructor      //insere os construtores automaticamente
public class Person implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "first name field cannot be empty")
    @Size(min = 2, max = 100, message = "first name field must contain 2 to 100 characters")
    @Column(nullable = false)
    private String firstName;

    @NotEmpty(message = "last name field cannot be empty")
    @Size(min = 2, max = 100, message = "last name field must contain 2 to 100 characters")
    @Column(nullable = false)
    private String lastName;

    @NotEmpty(message = "CPF field cannot be empty")
    @CPF(message = "CPF invalid")
    @Column(nullable = false, unique = true)
    private String cpf;

    private LocalDate birthDate;

    @NotBlank(message = "password field cannot be empty")
    @Size(min = 2, message = "password field must contain 2 to 10 characters")
    private String password;

    @NotEmpty
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "PersonRoles", joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id"),
            inverseJoinColumns =  @JoinColumn(name = "id_role", referencedColumnName = "nameRole"))
    private Set<PersonRole> roles = new LinkedHashSet<>();

    @Valid
    @NotEmpty(message = "the person must contain at least one phone")
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Phone> phones = new ArrayList<>();

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return firstName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
