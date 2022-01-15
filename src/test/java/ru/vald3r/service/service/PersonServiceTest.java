package ru.vald3r.service.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import ru.vald3r.service.model.Person;
import ru.vald3r.service.repository.PersonRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonServiceTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PersonRepository repository;
    @Test
//    @Order(1)
//    @Rollback(value = false)
    void getPersonByEmail() {
        final String email = UUID.randomUUID().toString();
        entityManager.persist(new Person("Jora",12, email ));
        Optional<Person> person = repository.findByEmail(email);
        assertThat(person.get().getEmail()).as("Test get person by email").isEqualTo(email);
    }

    @Test
    void getAll() {
        long all = repository.count();
        List<Person> list = repository.findAll();
        assertThat(list.size()).isEqualTo(all);
    }

    @Test
    void savePerson() {
    }

    @Test
    void deletePerson() {
    }
}