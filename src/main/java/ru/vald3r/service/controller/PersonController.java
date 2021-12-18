package ru.vald3r.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vald3r.service.service.PersonService;
import ru.vald3r.service.model.Person;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public ResponseEntity<List<Person>> getAll(){
        return new ResponseEntity<>(personService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Person>> getById(@PathVariable Long id){
        return new ResponseEntity<>(personService.getPersonById(id), HttpStatus.OK);
    }

}
