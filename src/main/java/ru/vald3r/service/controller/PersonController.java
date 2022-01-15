package ru.vald3r.service.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vald3r.service.service.PersonService;
import ru.vald3r.service.model.Person;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
@Slf4j
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public ResponseEntity<List<Person>> getAll(){
        return new ResponseEntity<>(personService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Person>> getById(@PathVariable Long id){
        log.info("{}",id);
        return new ResponseEntity<>(personService.getPersonById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Person> savePerson(@RequestBody Person person){
        return new ResponseEntity<>(personService.savePerson(person),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

}
