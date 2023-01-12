package com.example.gerenciadorDePessoas.service;

import com.example.gerenciadorDePessoas.domain.AddressGenerator;
import com.example.gerenciadorDePessoas.domain.Person;
import com.example.gerenciadorDePessoas.domain.PersonGenerator;
import com.example.gerenciadorDePessoas.exception.LoginNotExistsException;
import com.example.gerenciadorDePessoas.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    @Mock
    private PersonRepository repository;

    @InjectMocks
    private PersonService service;

    @Test
    public void shouldSucessCreate() {
        Person person = PersonGenerator.buildCreatePerson();

        Mockito.when(repository.save(any())).thenReturn(person);

        Person personCreated = service.savePerson(person);

        Assertions.assertEquals("Guilherme Bini", personCreated.getName());
        Assertions.assertEquals(LocalDate.parse("2002-10-19"), personCreated.getBirthDate());

        Mockito.verify(repository, times(1)).save(any());
    }

    @Test
    public void shouldSucessUpdate() {
        Person person = PersonGenerator.buildUpdatePerson();

        Mockito.when(repository.save(any())).thenReturn(person);

        Person personCreated = service.savePerson(person);

        Assertions.assertEquals("Bini Guilherme", personCreated.getName());
        Assertions.assertEquals(LocalDate.parse("2001-11-20"), personCreated.getBirthDate());
        Assertions.assertEquals(AddressGenerator.buildCreateAddress(), personCreated.getAddress());

        Mockito.verify(repository, times(1)).save(any());
    }

    @Test
    public void shouldFailLoginNotFound() {
        Person person = PersonGenerator.buildCreatePerson();

        Mockito.when(repository.existsById(person.getId())).thenReturn(false);

        LoginNotExistsException exception = assertThrows(LoginNotExistsException.class, () -> service.existsByIdPerson(person.getId()));

        Assertions.assertEquals("Login não encontrado!", exception.getMessage());

        Mockito.verify(repository, times(1)).existsById(any());
    }


}