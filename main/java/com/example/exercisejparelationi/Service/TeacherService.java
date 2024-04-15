package com.example.exercisejparelationi.Service;

import com.example.exercisejparelationi.Api.ApiException;
import com.example.exercisejparelationi.Model.Teacher;
import com.example.exercisejparelationi.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;




@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    //• Get all teachers
    public List<Teacher> getAllTeachers(){
       return teacherRepository.findAll();
    }

   //• Add new teacher
    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    //• Update teacher
    public void updateTeacher(Integer id,Teacher teacher) {
        Teacher t = teacherRepository.findTeacherById(id);
        if (t == null) {
            throw new ApiException("Wrong id");
        }//id , name , age , email , salary
        t.setName(teacher.getName());
        t.setAge(teacher.getAge());
        t.setEmail(teacher.getEmail());
        t.setSalary(teacher.getSalary());
        teacherRepository.save(t);


    }


   //• Delete teacher
    public void deleteTeacher(Integer id) {
        Teacher t = teacherRepository.findTeacherById(id);
        if (t == null) {
            throw new ApiException("Wrong id");
        }
        teacherRepository.delete(t);
    }

    //• Create endpoint that takes teacher id and return All teacher details
    public Teacher getTeacherById(Integer id) {
        Teacher t = teacherRepository.findTeacherById(id);
        if (t == null) {
            throw new ApiException("Not found teacher!");
        }
        return t;
    }






}
