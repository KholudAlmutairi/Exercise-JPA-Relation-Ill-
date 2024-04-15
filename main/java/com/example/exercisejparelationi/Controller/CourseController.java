package com.example.exercisejparelationi.Controller;

import com.example.exercisejparelationi.Api.ApiResponse;
import com.example.exercisejparelationi.Model.Course;
import com.example.exercisejparelationi.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {


    private final CourseService courseService;


    @GetMapping("/get")
    public ResponseEntity getAllCourses(){

        return ResponseEntity.status(200).body(courseService.getAllCourses());
    }

    //#1
    @PostMapping("/add")
    public ResponseEntity addCourse(@RequestBody @Valid Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("Course added"));

    }


//    //#2
//    @PostMapping("/add/{teacher_id}")
//    public ResponseEntity addCourse(@PathVariable Integer teacher_id,@RequestBody @Valid Course course){
//       courseService.addCourse(teacher_id,course);
//       return ResponseEntity.status(200).body(new ApiResponse("Course and teacher added"));
//
//  }


    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id, @RequestBody @Valid Course course){
        courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body(new ApiResponse( "Course updated"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("Course deleted!"));
    }

    //#1

    @PutMapping("/assign/{teacher_id}/{course_id}")
    public ResponseEntity assignTeacherToCourse(@PathVariable Integer teacher_id,@PathVariable Integer course_id){
        courseService.assignTeacherToCourse(teacher_id,course_id);
        return ResponseEntity.status(200).body(new ApiResponse("Assign Done!"));
    }



    @GetMapping("/teacherNameByCourseId/{id}")
    public ResponseEntity<String> getTeacherNameByCourseId(@PathVariable Integer id) {
        return ResponseEntity.ok(courseService.getTeacherNameByCourseId(id));
    }


}
