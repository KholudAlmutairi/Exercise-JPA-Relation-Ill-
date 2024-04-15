package com.example.exercisejparelationi.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Teacher {

    //id , name , age , email , salary
    // ( Add all required validation )

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name can not be null")
    @Column(columnDefinition = "varchar(30) not null")
    private String name;

    @Positive
    @NotNull(message = "age can not be null")
    @Column(columnDefinition = "int")
    private Integer age;

    @NotEmpty (message = "email can not be null")
    @Email
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;

    @Positive(message = "Salary should contain only numbers")
    @NotNull(message = "salary not null")
    @Column(columnDefinition = "double")
    private Double salary;

    //CascadeType.ALL
    @OneToOne(cascade =CascadeType.REMOVE,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher")
    private Set<Course> courses;



}
