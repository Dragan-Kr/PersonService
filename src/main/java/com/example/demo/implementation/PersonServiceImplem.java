package com.example.demo.implementation;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PersonServiceImplem implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public Collection<Person> findAllObjects() {
        return personRepository.findAll();
    }

    @Override
    public Person findObjectById(Integer id) {
        return personRepository.getById(id);
    }

    @Override
    public Person saveObject(Person person) {
        personRepository.save(person);
        return person;
    }

    @Override
    public boolean existsObjectById(Integer id) {
        return personRepository.existsById(id);
    }

    @Override
    public void deleteObjectById(Integer id) {
        personRepository.deleteById(id);
    }


}
