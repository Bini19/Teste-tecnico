package com.example.gerenciadorDePessoas.domain;

public class AddressGenerator {
    public static Address buildCreateAddress() {
        return Address.builder()
                .street("Rua Pica Pau")
                .zipCode("89226040")
                .number(275)
                .city("Joinville")
                .mainAddress(true)
                .person(Person.builder().build())
                .build();
    }
}