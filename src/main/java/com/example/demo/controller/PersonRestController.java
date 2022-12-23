package com.example.demo.controller;

import com.example.demo.dto.PersonDto;
import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class PersonRestController {

    @Autowired
    private PersonService personService;


    @GetMapping("person")
    public Collection<Person> findAll(){
        return personService.findAllObjects();
    }

    @GetMapping("person/{id}")
    public Person getPersonById(@PathVariable("id") Integer id){
      return   personService.findObjectById(id);
    }

    @PostMapping("person")
    public ResponseEntity insertPerson(@RequestBody PersonDto personDto){
        Person person = new Person();
        person.setAddress(personDto.getAddress());
        person.setBirthDate(personDto.getBirthDate());
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setGender(personDto.getGender());
        person.setJmbg(personDto.getJmbg());
        person.setPhone(personDto.getPhone());
        personService.saveObject(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("person/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") Integer id,@RequestBody PersonDto personDto){
        Person person = personService.findObjectById(id);
        person.setAddress(personDto.getAddress());
        person.setBirthDate(personDto.getBirthDate());
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setGender(personDto.getGender());
        person.setJmbg(personDto.getJmbg());
        person.setPhone(personDto.getPhone());

        Person updatedPerson = personService.saveObject(person);
        return ResponseEntity.ok(updatedPerson);

    }

    @DeleteMapping("person/{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable ("id") Integer id ){
        if(!personService.existsObjectById(id))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        personService.deleteObjectById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
