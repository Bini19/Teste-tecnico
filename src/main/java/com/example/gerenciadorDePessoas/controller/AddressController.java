package com.example.gerenciadorDePessoas.controller;

import com.example.gerenciadorDePessoas.domain.Address;
import com.example.gerenciadorDePessoas.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/person")
public class AddressController {
    @Autowired
    private AddressService service;

    @PostMapping("/{personId}/address")
    public ResponseEntity<Address> createAddress(@PathVariable Long personId, @RequestBody Address address) {
        return new ResponseEntity<>(service.saveAddress(personId, address), HttpStatus.CREATED);
    }

    @GetMapping("/address")
    public ResponseEntity<List<Address>> findAllAddress() {
        return ResponseEntity.ok(service.findAddress());
    }

    @GetMapping("/{personId}/address")
    public ResponseEntity<List<Address>> findAddressId(@PathVariable Long personId) {
        return ResponseEntity.ok(service.findAddressPersonId(personId));
    }

}