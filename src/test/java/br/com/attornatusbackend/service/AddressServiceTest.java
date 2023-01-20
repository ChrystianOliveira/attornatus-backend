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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class AddressServiceTest {

    @InjectMocks
    private AddressService addressService;

    @Mock
    private AddressRepository addressRepository;

    private UUID existingPersonId;
    private UUID existingAddressId;
    private UUID nonExistingAddresId;
    private Address address;
    private Person person;

    @BeforeEach
    void setUp() {
        existingPersonId = UUID.randomUUID();
        existingAddressId = UUID.randomUUID();
        nonExistingAddresId = UUID.randomUUID();
        person = new Person(existingPersonId, "chrystian", LocalDate.of(1997, 11, 12), null, null);
        address = new Address(existingAddressId, "rua c", "57084028", "54", "Maceio", person);

        Mockito.when(addressRepository.findById(existingAddressId)).thenReturn(Optional.of(address));
        Mockito.doThrow(ObjectNotFoundException.class).when(addressRepository).findById(nonExistingAddresId);

    }

    @Test
    public void findShouldFindByIdWhenIdExists() {

        Assertions.assertDoesNotThrow(() -> {
            addressService.findById(existingAddressId);
        });

    }

    @Test
    public void findShouldFindByIdWhenIdNotExists() {

        Assertions.assertThrows(ObjectNotFoundException.class, () -> {
            addressService.findById(nonExistingAddresId);
        });

    }

}