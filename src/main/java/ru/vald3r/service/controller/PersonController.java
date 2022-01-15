package ru.vald3r.service.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.vald3r.service.service.PersonService;
import ru.vald3r.service.model.Person;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
@Slf4j
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("")
    public ResponseEntity<List<Person>> getAll(){
        List<Person> all = personService.getAll();
        if (all.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Person>> getById(@PathVariable Long id){
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<Person> person = personService.getPersonById(id);
        if (person.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Person> savePerson(@RequestBody @Validated Person person){
        HttpHeaders httpHeaders = new HttpHeaders();
        if (person == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(personService.savePerson(person),httpHeaders,HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Person> updatePerson(@RequestBody @Validated Person person){
        HttpHeaders httpHeaders = new HttpHeaders();
        if (person == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(personService.savePerson(person),httpHeaders,HttpStatus.CREATED);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Person>> deletePerson(@PathVariable Long id){
        Optional<Person> person = personService.getPersonById(id);
        if (person.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        personService.deletePerson(id);
        return new ResponseEntity<>(person,HttpStatus.OK);
    }

}
