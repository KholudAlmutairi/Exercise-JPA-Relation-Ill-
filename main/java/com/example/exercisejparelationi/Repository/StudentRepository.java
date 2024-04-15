package com.example.exercisejparelationi.Repository;

import com.example.exercisejparelationi.Model.Student;
import com.example.exercisejparelationi.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findStudentById(Integer id);
}
