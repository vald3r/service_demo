package ru.vald3r.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vald3r.service.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}