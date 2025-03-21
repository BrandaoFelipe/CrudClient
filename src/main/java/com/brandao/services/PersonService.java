package com.brandao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.brandao.dtos.PersonDTO;
import com.brandao.entities.Person;
import com.brandao.repositories.PersonRepository;


@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    @Transactional(readOnly = true)
    public List<PersonDTO>findAll(){
        
        List<Person>list = repository.findAll();

        return list.stream().map(x -> new PersonDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public PersonDTO findById(Long id){
        
        Person person = repository.findById(id).orElseThrow(() -> new RuntimeException("Not Found!"));

        return new PersonDTO(person);
    }

    @Transactional()
    public PersonDTO insert(PersonDTO dto){
        
        Person person = new Person(); //instancia a entidade
        
        ToEntity(person, dto); //faz a copia do dto para entidade

        person = repository.save(person); //salva entidade no db

        return new PersonDTO(person); //converte para dto e retorna

    }

    @Transactional()
    public PersonDTO update(PersonDTO dto, Long id){

        Person person =  repository.getReferenceById(id);
        
        ToEntity(person, dto);
        
        person = repository.save(person);

        return new PersonDTO(person);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        
        repository.deleteById(id);
    }

    private void ToEntity(Person person, PersonDTO dto){

        person.setId(dto.getId());
        person.setName(dto.getName());
        person.setAddress(dto.getAddress());
        person.setPhoneNumber(dto.getPhoneNumber());
        person.setDescription(dto.getDescription());
    }

}
