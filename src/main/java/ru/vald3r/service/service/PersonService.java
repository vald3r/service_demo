package ru.vald3r.service.service;

import ru.vald3r.service.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    Optional<Person> getPersonById(Long id);

    List<Person> getAll();

    Person savePerson(Person person);

    void deletePerson(Long id);
}
