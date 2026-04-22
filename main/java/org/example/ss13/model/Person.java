package org.example.ss13.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "persons")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String name;

    @Column(name = "age")
    private Integer age;
}
