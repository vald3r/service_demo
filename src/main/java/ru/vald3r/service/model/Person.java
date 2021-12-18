package ru.vald3r.service.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "person")
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;
}