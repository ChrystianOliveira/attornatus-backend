package br.com.attornatusbackend.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO implements Serializable {

    private UUID id;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String streetName;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 8, max = 8, message = "O tamanho deve ser de 8 caracteres")
    private String zipCode;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String number;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String city;

}
