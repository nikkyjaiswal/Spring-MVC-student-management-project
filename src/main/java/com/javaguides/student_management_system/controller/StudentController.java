package com.javaguides.student_management_system.controller;

import com.javaguides.student_management_system.dto.StudentDto;
import com.javaguides.student_management_system.entity.Student;
import com.javaguides.student_management_system.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/students")
public class StudentController {
    private StudentService studentService;
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(Student student)
    {
        StudentDto Studentdto=studentService.createStudentDto(student);
        return new ResponseEntity<>(Studentdto, HttpStatus.CREATED);
    }
    @GetMapping()
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> studentDtos = studentService.getAllStudents();
        return ResponseEntity.ok(studentDtos);
    }
}
