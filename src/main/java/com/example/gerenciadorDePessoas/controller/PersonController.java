package com.example.gerenciadorDePessoas.controller;

import com.example.gerenciadorDePessoas.domain.Person;
import com.example.gerenciadorDePessoas.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/person")
public class PersonController {
    @Autowired
    private PersonService service;

    @PostMapping
    public Person createPerson(@RequestBody Person Person) {
        return service.savePerson(Person);
    }

    @GetMapping
    public List<Person> findAllPeople() {
        return service.findPeople();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person person) {
        return ResponseEntity.ok(service.updatePerson(id, person));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findByPersonId(id));
    }

}