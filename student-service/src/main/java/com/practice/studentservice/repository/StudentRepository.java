package com.practice.studentservice.repository;
import com.practice.studentservice.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Repository
public class StudentRepository {
    private List<Student> studentList
            = new ArrayList<>();

    public Student add(Student student) {
        UUID id=UUID.randomUUID();
        Student studentRecord = new Student(id, student.departmentId(), student.name(),student.age(),student.semester());
        studentList.add(studentRecord);
        return studentRecord;
    }

    public Student findById(UUID id) {
        return studentList.stream()
                .filter(a -> a.id().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Student> findAll() {
        return studentList;
    }

    public List<Student> findByDepartment(Long departmentId) {
        return studentList.stream()
                .filter(a -> a.departmentId().equals(departmentId))
                .toList();
    }
}
