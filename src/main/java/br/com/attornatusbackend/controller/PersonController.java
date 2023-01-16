package br.com.attornatusbackend.controller;

import br.com.attornatusbackend.controller.dto.PersonDTO;
import br.com.attornatusbackend.controller.mapper.PersonMapper;
import br.com.attornatusbackend.model.Person;
import br.com.attornatusbackend.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public List<PersonDTO> findAllPersons() {
        return personService.findAllPersons()
                .stream()
                .map(PersonMapper.INST::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable UUID id) {
        return PersonMapper.INST.toDto(personService.findById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PersonDTO create(@Valid @RequestBody PersonDTO personDTO) {
        Person savedPerson = personService.create(PersonMapper.INST.toModel(personDTO));
        return PersonMapper.INST.toDto(savedPerson);
    }

    @PutMapping("/{id}")
    public PersonDTO update(@Valid @RequestBody PersonDTO personDTO, @PathVariable UUID id) {
        Person updatedPerson = personService.update(PersonMapper.INST.toModel(personDTO), id);
        return PersonMapper.INST.toDto(updatedPerson);
    }

}
