package com.brandao.dtos;

import com.brandao.entities.Person;

public class PersonDTO {

    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private String description;
    
    public PersonDTO(Long id, String name, String address, String phoneNumber, String description) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.description = description;
    }

    

    public PersonDTO(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.address = person.getAddress();
        this.phoneNumber = person.getPhoneNumber();
        this.description = person.getDescription();
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    

    
}
