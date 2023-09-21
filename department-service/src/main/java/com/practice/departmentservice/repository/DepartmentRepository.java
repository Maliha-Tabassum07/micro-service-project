package com.practice.departmentservice.repository;

import com.practice.departmentservice.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {
    private Long count=1l;
    private List<Department> departments
            = new ArrayList<>();

    public Department addDepartment(Department department) {
        department.setId(count++);
        departments.add(department);
        return department;
    }

    public Department findById(Long id) {
        return departments.stream()
                .filter(department ->
                        department.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Department> findAll() {
        return departments;
    }
}
