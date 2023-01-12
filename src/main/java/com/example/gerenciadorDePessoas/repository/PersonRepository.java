package com.example.gerenciadorDePessoas.repository;

import com.example.gerenciadorDePessoas.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}