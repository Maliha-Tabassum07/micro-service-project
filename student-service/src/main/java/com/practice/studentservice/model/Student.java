package com.practice.studentservice.model;

import java.util.UUID;

public record Student(UUID id, Long departmentId, String name, Integer age, Integer semester) {
}
