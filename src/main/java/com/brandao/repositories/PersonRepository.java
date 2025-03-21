package com.brandao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brandao.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{


}
