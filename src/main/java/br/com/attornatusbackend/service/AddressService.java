package br.com.attornatusbackend.service;

import br.com.attornatusbackend.model.Address;
import br.com.attornatusbackend.model.Person;
import br.com.attornatusbackend.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    private final PersonService personService;

    private Address findById(UUID id) {
        return addressRepository.findById(id)
                .orElse(null);
    }

    public Address createAddress(UUID personId, Address address) {
        Person person = personService.findById(personId);
        if (Objects.isNull(person)) {
            throw new ObjectNotFoundException(personId, "Pessoa não encontrada!");
        }

        address.setId(null);
        address.setPerson(person);
        return addressRepository.save(address);
    }

    public List<Address> findByPersonId(UUID personId) {
        return addressRepository.findByPersonId(personId);
    }

    public void setMainAddress(UUID addressId, UUID personId) {
        Address address = findById(addressId);
        if (Objects.isNull(address)) {
            throw new ObjectNotFoundException(addressId, "Endereço não encontrado!");
        }

        Person person = personService.findById(personId);
        if (Objects.isNull(person)) {
            throw new ObjectNotFoundException(personId, "Pessoa não encontrada!");
        }

        personService.setMainAddress(person, address);
    }

}
