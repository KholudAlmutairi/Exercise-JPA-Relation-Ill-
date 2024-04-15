package com.example.exercisejparelationi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
public class Student {
    //ID , name , age , major ( all should not be empty )
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

    @NotEmpty(message = "major can not be null")
    @Column(columnDefinition = "varchar(30) not null")
    private String major;

    @ManyToMany
    @JsonIgnore
    private Set<Course> Courses;
}
