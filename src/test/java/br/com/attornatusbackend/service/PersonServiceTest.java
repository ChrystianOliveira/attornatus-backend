package br.com.attornatusbackend.service;

import br.com.attornatusbackend.model.Address;
import br.com.attornatusbackend.model.Person;
import br.com.attornatusbackend.repository.AddressRepository;
import br.com.attornatusbackend.repository.PersonRepository;
import br.com.attornatusbackend.service.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class PersonServiceTest {

    @InjectMocks
    private PersonService personService;

    @Mock
    private PersonRepository personRepository;

    private UUID existingPersonId;
    private UUID existingAddressId;
    private UUID nonExistingPersonId;
    private Address address;
    private Person person;

    @BeforeEach
    void setUp() {
        existingPersonId = UUID.randomUUID();
        existingAddressId = UUID.randomUUID();
        nonExistingPersonId = UUID.randomUUID();
        person = new Person(existingPersonId, "chrystian", LocalDate.of(1997, 11, 12), null, null);
        address = new Address(existingAddressId, "rua c", "57084028", "54", "Maceio", person);

        Mockito.when(personRepository.findById(existingPersonId)).thenReturn(Optional.of(person));
        Mockito.doThrow(ObjectNotFoundException.class).when(personRepository).findById(nonExistingPersonId);

    }

    @Test
    public void findShouldFindByIdWhenIdExists() {

        Assertions.assertDoesNotThrow(() -> {
            personService.findById(existingAddressId);
        });

    }

    @Test
    public void findShouldFindByIdWhenIdNotExists() {

        Assertions.assertThrows(ObjectNotFoundException.class, () -> {
            personService.findById(nonExistingPersonId);
        });

    }

}