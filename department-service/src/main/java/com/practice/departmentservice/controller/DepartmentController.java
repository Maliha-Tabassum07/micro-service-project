package com.practice.departmentservice.controller;

import com.practice.departmentservice.client.StudentClient;
import com.practice.departmentservice.model.Department;
import com.practice.departmentservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private StudentClient studentClient;

//    @Autowired
//    private EmployeeClient employeeClient;

    @PostMapping("/add")
    public Department add(@RequestBody Department department) {
        return repository.addDepartment(department);
    }

    @GetMapping("/all")
    public List<Department> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @GetMapping("/with-students")
    public List<Department> findAllWithStudent() {
        List<Department> departments
                = repository.findAll();
        departments.forEach(department ->
                department.setStudents(
                        studentClient.findByDepartment(department.getId())));
        return  departments;
    }
}
