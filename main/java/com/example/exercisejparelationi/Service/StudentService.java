package com.example.exercisejparelationi.Service;

import com.example.exercisejparelationi.Api.ApiException;
import com.example.exercisejparelationi.Model.Course;
import com.example.exercisejparelationi.Model.Student;
import com.example.exercisejparelationi.Model.Teacher;
import com.example.exercisejparelationi.Repository.CourseRepository;
import com.example.exercisejparelationi.Repository.StudentRepository;
import com.example.exercisejparelationi.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    //• Get all Students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();

    }

    //• Add new Student
    public void addStudent(Student student){
            studentRepository.save(student);
      }


      //• Update Student
    public void updateStudent (Integer id, Student student){
        Student s =studentRepository.findStudentById(id);
            if (s == null) {
                throw new ApiException("Wrong id");
            }//ID , name , age , major

            s.setName(student.getName());
            s.setAge(student.getAge());
            s.setMajor(student.getMajor());

            studentRepository.save(s);


     }


        //• Delete Student
    public void deleteStudent(Integer id){
            Student student = studentRepository.findStudentById(id);
            if (student == null) {
                throw new ApiException("Wrong id");
            }
            studentRepository.delete(student);

    }


    public void assignStudentToCourses(Integer student_id, Integer course_id) {
        Student student=studentRepository.findStudentById(student_id);
        Course course= courseRepository.findCourseById(course_id);
        if (student == null || course == null) {
            throw new ApiException("can not assign");
        }
        student.getCourses().add(course);
        course.getStudents().add(student);
        studentRepository.save(student);
        courseRepository.save(course);


    }


    // Create endpoint that takes student id and major and change the student major (
   // changing the major will drop all the cousres that the student attended to )

    public void changeStudentMajor(Integer student_id, String major) {
        Student student = studentRepository.findStudentById(student_id);
        if (student == null) {
            throw new ApiException("Student not found");
        }
        student.getCourses().clear();
        student.setMajor(major);

        studentRepository.save(student);
    }


    //• Create endpoint that takes class id and return the student list
    public Set<Student> getStudentsByClassId(Integer course_id) {
        Course course = courseRepository.findCourseById(course_id);
        if (course == null) {
            throw new ApiException("Course not found");
        }

        return course.getStudents();
    }
    }

