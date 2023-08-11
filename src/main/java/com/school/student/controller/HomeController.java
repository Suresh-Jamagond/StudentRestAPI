package com.school.student.controller;

import com.school.student.model.Student;
import com.school.student.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HomeController {

    @Autowired
    StudentRepo repo;

    //CREATE  student
    @PostMapping("student")
    public Student addStudent(@RequestBody Student student) {
        repo.save(student);
        return student;
    }

    //READ by Id
    @GetMapping("student/{id}")
    public Optional<Student> getStudent(@PathVariable("id") int id)  {
        Optional<Student> student = repo.findById(id);
        student.get();
        return student;
    }

    //READ All Students
    @GetMapping(path = "students", produces = "application/xml")
    public List<Student> getAllStudents() {
        List<Student> students = repo.findAll();
        return students;
    }

    //UPDATE student
    @PutMapping(path = "student", consumes = "application/json")
    public Student updateStudent(@RequestBody Student student) {
        repo.save(student);
        return student;
    }

    //DELETE student
    @DeleteMapping("student/{id}")
    public void deleteStudent(@PathVariable("id") int id) {
        repo.deleteById(id);
    }
}
