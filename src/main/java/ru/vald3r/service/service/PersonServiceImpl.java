package ru.vald3r.service.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.vald3r.service.model.Person;
import ru.vald3r.service.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Optional<Person> getPersonById(Long id){
        Optional<Person> person = personRepository.findById(id);
        log.info("In getPersonById method. Id = {}", id);
        return person;
    }

    @Override
    public List<Person> getAll(){
        List<Person> personList = personRepository.findAll();
        log.info("In getAll method");
        return personList;
    }

    @Override
    public Person savePerson(Person person){
        Person savedPerson = personRepository.save(person);
        log.info("In savePerson method. Person = {}", savedPerson);
        return savedPerson;
    }

    @Override
    public void deletePerson(Long id){
        log.info("In deletePerson method. Id = {}", id);
        personRepository.deleteById(id);
    }
}
