package com.example.demo.service;

import com.example.demo.entity.Person;

import java.util.Collection;

public interface PersonService {
    Collection<Person> findAllObjects();

    Person findObjectById(Integer id);

    Person saveObject(Person person);

    boolean existsObjectById(Integer id);

    void deleteObjectById(Integer id);
}
