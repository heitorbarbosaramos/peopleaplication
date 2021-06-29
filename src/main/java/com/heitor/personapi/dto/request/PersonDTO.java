package com.heitor.personapi.dto.request;

import com.heitor.personapi.entity.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;

    @NotEmpty(message = "first name field cannot be empty")
    @Size(min = 2, max = 100, message = "first name field must contain 2 to 100 characters")
    private String firstName;

    @NotEmpty(message = "last name field cannot be empty")
    @Size(min = 2, max = 100, message = "last name field must contain 2 to 100 characters")
    private String lastName;

    @NotEmpty(message = "CPF field cannot be empty")
    @CPF(message = "CPF invalid")
    private String cpf;

    private LocalDate birthDate;

    @Valid
    @NotEmpty
    private List<Phone> phones;
}
