package br.com.attornatusbackend.service;

import br.com.attornatusbackend.model.Address;
import br.com.attornatusbackend.model.Person;
import br.com.attornatusbackend.repository.AddressRepository;
import br.com.attornatusbackend.service.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    private final PersonService personService;

    public Address findById(UUID id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(
                        "Endereço não encontrado! ID: " + id + ", Tipo: " + Address.class.getName()));
    }

    public Address createAddress(UUID personId, @NotNull Address address) {
        Person person = personService.findById(personId);
        address.setId(null);
        address.setPerson(person);
        return addressRepository.save(address);
    }

    public List<Address> findByPersonId(UUID personId) {
        personService.findById(personId); // validar se pessoa existe
        return addressRepository.findByPersonId(personId);
    }

    public void setMainAddress(UUID addressId, UUID personId) {
        Address address = findById(addressId);
        Person person = personService.findById(personId);
        personService.setMainAddress(person, address);
    }

}
