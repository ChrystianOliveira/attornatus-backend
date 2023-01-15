package br.com.attornatusbackend.controller;

import br.com.attornatusbackend.controller.dto.AddressDTO;
import br.com.attornatusbackend.controller.mapper.AddressMapper;
import br.com.attornatusbackend.model.Address;
import br.com.attornatusbackend.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/person/{personId}")
    public AddressDTO createAddress(@PathVariable UUID personId, @RequestBody AddressDTO addressDTO){
        Address savedAddress = addressService.createAddress(personId, AddressMapper.INST.toModel(addressDTO));
        return AddressMapper.INST.toDto(savedAddress);
    }

    @GetMapping("/person/{personId}")
    public List<AddressDTO> findByPersonId(@PathVariable UUID personId){
        return addressService.findByPersonId(personId)
                .stream()
                .map(AddressMapper.INST::toDto)
                .toList();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{addressId}/set-as-main/person/{personId}")
    public void setMainAddress(@PathVariable UUID addressId, @PathVariable UUID personId){
        addressService.setMainAddress(addressId, personId);
    }
}
