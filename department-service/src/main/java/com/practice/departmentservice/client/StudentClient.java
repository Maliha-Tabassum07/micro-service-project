package com.practice.departmentservice.client;

import com.practice.departmentservice.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface StudentClient {
    @GetExchange("student/department/{departmentId}")
    public List<Student> findByDepartment(@PathVariable Long departmentId);
}
