package br.com.attornatusbackend.service;

import br.com.attornatusbackend.model.Address;
import br.com.attornatusbackend.model.Person;
import br.com.attornatusbackend.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.rmi.server.UID;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    public Person findById(UUID id) {
        return personRepository.findById(id)
                .orElse(null);
    }

    public Person create(Person person) {
        person.setId(null);
        return personRepository.save(person);
    }

    public Person update(Person updatedPerson, UUID id) {
        Person person = findById(id);
        BeanUtils.copyProperties(updatedPerson, person, "id", "addresses");
        return personRepository.save(person);
    }

    public void setMainAddress(Person person, Address address) {
        person.setMainAddress(address);
        personRepository.save(person);
    }

}
