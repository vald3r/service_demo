package ru.vald3r.service.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vald3r.service.model.Person;
import ru.vald3r.service.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Optional<Person> getPersonById(Long id){
        return personRepository.findById(id);
    }

    public List<Person> getAll(){
        return personRepository.findAll();
    }

    public Person savePerson(Person person){
        return personRepository.save(person);
    }



    public void deletePerson(Long id){
        personRepository.deleteById(id);
    }
}
