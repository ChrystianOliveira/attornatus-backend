package br.com.attornatusbackend.controller.mapper;

import br.com.attornatusbackend.controller.dto.PersonDTO;
import br.com.attornatusbackend.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonMapper INST = Mappers.getMapper(PersonMapper.class);

    PersonDTO toDto(Person person);
    Person toModel(PersonDTO personDTO);
}
