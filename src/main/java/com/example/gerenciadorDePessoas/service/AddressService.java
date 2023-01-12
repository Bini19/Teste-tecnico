package com.example.gerenciadorDePessoas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gerenciadorDePessoas.domain.Address;
import com.example.gerenciadorDePessoas.domain.Person;
import com.example.gerenciadorDePessoas.repository.AddressRepository;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    PersonService personService;

    public Address saveAddress(Long personId, Address address) {
        personService.existsByIdPerson(personId);
        setMainAddress(personId, address);
        address.getPerson().setId(personId);
        Person person = personService.findByPersonId(personId);
        person.setAddress(address);
        return addressRepository.save(address);
    }

    public List<Address> findAddress() {
        return addressRepository.findAll();
    }

    public List<Address> findAddressPersonId(Long personId) {
        personService.existsByIdPerson(personId);
        return addressRepository.findByPersonId(personId);
    }

    public void setMainAddress(Long personId, Address address) {
        List<Address> exist = addressRepository.findByPersonId(personId);
        if (address.getMainAddress()) {
            exist.forEach(it -> {
                        it.setMainAddress(false);
                        addressRepository.save(it);
                    }
            );
        }
    }
}