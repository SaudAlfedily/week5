package com.example.homework21.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(25) not null")
    @NotEmpty(message = "student name should not be empty")
   private String name;


    @NotNull(message = "student age should not be empty")
    @Column(columnDefinition = "int not null")
    @Positive
    private Integer age;

    @Column(columnDefinition = "varchar(25) not null")
    @NotEmpty(message = "major should not be empty")
   private String major;

   @ManyToMany(mappedBy = "student")
    private Set<Course> courses;
}
