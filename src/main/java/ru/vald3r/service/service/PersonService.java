package ru.vald3r.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vald3r.service.model.Person;
import ru.vald3r.service.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Optional<Person> getPersonById(Long id){
        return personRepository.findById(id);
    }

    public List<Person> getAll(){
        return personRepository.findAll();
    }
}
