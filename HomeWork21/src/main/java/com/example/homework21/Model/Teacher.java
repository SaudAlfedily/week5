package com.example.homework21.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Teacher name should not be empty")
    @Column(columnDefinition = "varchar(25) not null")
    private String name;

    @NotNull(message ="Teacher age should not be empty" )
    @Positive(message = "please inter Positive number")
    @Column(columnDefinition = "int not null unique")
    private Integer age;

    @NotEmpty(message = "Teacher email should not be empty")
    @Email(message = "please enter valid email")
    @Column(columnDefinition = "varchar(25) not null")
    private String email;

    @NotNull(message ="Teacher salary should not be empty" )
    @Positive(message = "please enter positive number")
    @Column(columnDefinition = "int not null")
    private double salary;


    @OneToOne(cascade = CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;


}
