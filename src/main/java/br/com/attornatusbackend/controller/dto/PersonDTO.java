package br.com.attornatusbackend.controller.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO implements Serializable {

    private UUID id;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String name;

    @NotNull(message = "Preenchimento obrigatório")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    private List<AddressDTO> addresses;

    private AddressDTO mainAddress;

}
