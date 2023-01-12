package com.example.gerenciadorDePessoas.domain;

import java.time.LocalDate;

public class PersonGenerator {
    public static Person buildCreatePerson() {
        return Person.builder()
                .id(1L)
                .name("Guilherme Bini")
                .birthDate(LocalDate.parse("2002-10-19"))
                .address(Address.builder().build())
                .build();
    }

    public static Person buildUpdatePerson() {
        return Person.builder()
                .name("Bini Guilherme")
                .birthDate(LocalDate.parse("2001-11-20"))
                .address(AddressGenerator.buildCreateAddress())
                .build();
    }
}