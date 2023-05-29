package com.example.homework21.DTO;

import com.example.homework21.Model.Teacher;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    private Integer teacher_id;

    @NotEmpty(message = " area should not be empty")
    private String area;

    @NotEmpty(message = "street should not be empty")
    private String street;



    @NotNull(message = "building Number should not be empty")
    @Positive(message = "please enter positive number")
    private Integer buildingNumber;


    private Teacher teacher;

}
