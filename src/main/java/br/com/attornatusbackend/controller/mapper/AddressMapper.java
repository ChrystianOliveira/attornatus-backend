package br.com.attornatusbackend.controller.mapper;

import br.com.attornatusbackend.controller.dto.AddressDTO;
import br.com.attornatusbackend.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressMapper INST = Mappers.getMapper(AddressMapper.class);

    AddressDTO toDto(Address address);

    Address toModel(AddressDTO addressDTO);
}
