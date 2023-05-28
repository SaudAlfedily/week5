package com.example.homework21.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
public class Address {

    @Id
    private Integer id;


    @NotEmpty(message = " area should not be empty")
    @Column(columnDefinition = "varchar(25) not null")
    private String area;

    @NotEmpty(message = "street should not be empty")
    @Column(columnDefinition = "varchar(25) not null")
    private String street;



    @NotNull(message = "building Number should not be empty")
    @Column(columnDefinition = "int not null")
    @Positive(message = "please enter positive number")
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
