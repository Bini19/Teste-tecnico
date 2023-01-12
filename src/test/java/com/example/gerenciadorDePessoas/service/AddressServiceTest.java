package com.example.gerenciadorDePessoas.service;

import com.example.gerenciadorDePessoas.domain.Address;
import com.example.gerenciadorDePessoas.domain.AddressGenerator;
import com.example.gerenciadorDePessoas.domain.Person;
import com.example.gerenciadorDePessoas.domain.PersonGenerator;
import com.example.gerenciadorDePessoas.repository.AddressRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {
    @Mock
    private AddressRepository repository;
    @Mock
    private PersonService personService;
    @InjectMocks
    private AddressService service;


    @Test
    public void shouldSucessCreate() {
        Address address = AddressGenerator.buildCreateAddress();
        Person person = PersonGenerator.buildCreatePerson();

        Mockito.when(repository.save(any())).thenReturn(address);
        Mockito.when(personService.findByPersonId(any())).thenReturn(person);

        Address addressCreated = service.saveAddress(person.getId(), address);
        Assertions.assertEquals("Rua Pica Pau", addressCreated.getStreet());
        Assertions.assertEquals("89226040", addressCreated.getZipCode());
        Assertions.assertEquals(275, addressCreated.getNumber());
        Assertions.assertEquals("Joinville", addressCreated.getCity());
        Assertions.assertTrue(addressCreated.getMainAddress());

        Mockito.verify(repository, times(1)).save(any());
        Mockito.verify(personService, times(1)).findByPersonId(any());
    }
}