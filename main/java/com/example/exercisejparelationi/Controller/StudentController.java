package com.example.exercisejparelationi.Controller;

import com.example.exercisejparelationi.Api.ApiResponse;
import com.example.exercisejparelationi.Model.Student;
import com.example.exercisejparelationi.Model.Teacher;
import com.example.exercisejparelationi.Service.StudentService;
import com.example.exercisejparelationi.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {


    private final StudentService studentService;


    @GetMapping("/get")
    public ResponseEntity getAllStudents(){

        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }


    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("Student Added"));

    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id, @RequestBody @Valid Student student){
        studentService.updateStudent(id, student);
        return ResponseEntity.status(200).body(new ApiResponse( "Student updated"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body(new ApiResponse("Student deleted!"));
    }


    @PutMapping("/assign/{student_id}/{course_id}")
    public ResponseEntity assignStudentToCourses(@PathVariable Integer student_id,@PathVariable Integer course_id){
        studentService.assignStudentToCourses(student_id,course_id);
        return ResponseEntity.status(200).body(new ApiResponse("Assign Done!"));

    }

    @PutMapping("/changeStudentMajor/{student_id}/{major}")
    public ResponseEntity changeStudentMajor(@PathVariable Integer student_id, @PathVariable String major){
        studentService.changeStudentMajor(student_id, major);
        return ResponseEntity.status(200).body(new ApiResponse("Change student major done"));
    }

    @GetMapping("/getStudentsByClassId/{course_id}")

    public ResponseEntity getStudentsByClassId(@PathVariable Integer course_id){

        return ResponseEntity.status(200).body(studentService.getStudentsByClassId(course_id));
    }











}
