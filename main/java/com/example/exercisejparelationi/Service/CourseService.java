package com.example.exercisejparelationi.Service;

import com.example.exercisejparelationi.Api.ApiException;
import com.example.exercisejparelationi.Model.Course;
import com.example.exercisejparelationi.Model.Teacher;
import com.example.exercisejparelationi.Repository.CourseRepository;
import com.example.exercisejparelationi.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {


    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

   // Get all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();

    }

    //#1
    //• Add new course
    public void addCourse(Course course) {
        courseRepository.save(course);

    }


    //#2
    public void addCourse(Integer teacher_id,Course course){
        Teacher t=teacherRepository.findTeacherById(teacher_id);
        if(t==null){
            throw new ApiException("Course not found");
        }
        course.setTeacher(t);
        courseRepository.save(course);
        teacherRepository.save(t);
    }


    //• Update course
    public void updateCourse(Integer id,Course course)
    {
        Course c=courseRepository.findCourseById(id);

        if (c == null) {
            throw new ApiException("Course not found");
        }
        c.setName(course.getName());
        courseRepository.save(c);


    }

    //• Delete Course
    public void deleteCourse(Integer id) {
        Course c=courseRepository.findCourseById(id);

        if (c == null) {
            throw new ApiException("Course not found");
        }
        courseRepository.delete(c);
    }

    public void assignTeacherToCourse(Integer teacher_id,Integer course_id){
        Teacher t =teacherRepository.findTeacherById(teacher_id);
        Course c =courseRepository.findCourseById(course_id);
        if(t==null || c==null){
            throw new ApiException("Can not assign");
        }
        c.setTeacher(t);
        courseRepository.save(c);

    }


    //• Create endpoint that take course id and return the teacher name for that class

    public String getTeacherNameByCourseId(Integer id) {
        Course course = courseRepository.findCourseById(id);
        if (course == null) {
            throw new ApiException("Course not found!");
        }
        return course.getTeacher().getName();
    }





















}
