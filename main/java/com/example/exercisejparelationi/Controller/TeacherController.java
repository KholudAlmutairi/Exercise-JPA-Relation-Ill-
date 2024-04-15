package com.example.exercisejparelationi.Controller;

import com.example.exercisejparelationi.Api.ApiResponse;
import com.example.exercisejparelationi.Model.Teacher;
import com.example.exercisejparelationi.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {



    private final TeacherService teacherService;


    @GetMapping("/get")
    public ResponseEntity getAllTeachers(){

        return ResponseEntity.status(200).body(teacherService.getAllTeachers());
    }


    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher Added"));

    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @RequestBody @Valid Teacher teacher){
        teacherService.updateTeacher(id,teacher);
        return ResponseEntity.status(200).body(new ApiResponse( "Teacher updated"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher deleted!"));
    }


    @GetMapping("/getTeacherById/{id}")
    public ResponseEntity getTeacherById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(teacherService.getTeacherById(id));
    }







}
