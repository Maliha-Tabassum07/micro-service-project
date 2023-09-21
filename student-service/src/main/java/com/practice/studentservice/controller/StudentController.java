package com.practice.studentservice.controller;
import com.practice.studentservice.model.Student;
import com.practice.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentRepository repository;

    @PostMapping("/add")
    public Student add(@RequestBody Student student) {
        return repository.add(student);
    }

    @GetMapping("/all")
    public List<Student> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable UUID id) {
        return repository.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Student> findByDepartment(@PathVariable Long departmentId) {
        return repository.findByDepartment(departmentId);
    }
}
