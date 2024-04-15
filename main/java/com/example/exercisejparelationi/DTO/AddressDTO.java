package com.example.exercisejparelationi.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {


    private Integer teacher_id;

    @NotEmpty(message = " area can not be null")
    private String area;

    @NotEmpty(message = "street can not be null")
    private String street;

    @Positive
    @NotNull(message = "building Number can not be null")
//    @Pattern(regexp = "^[0-9A-Za-z]+$", message = "Building number should contain only numbers and letters")
    private Integer buildingNumber;




}
