package com.javaguides.student_management_system.service;

import com.javaguides.student_management_system.dto.StudentDto;
import com.javaguides.student_management_system.entity.Student;

import java.util.List;

public interface StudentService {


    StudentDto createStudentDto(Student student);

    StudentDto getStudentDto(Long id);

    List<StudentDto> getAllStudents();

    StudentDto updateStudentDto(Student student, Long id);

    String deleteStudent(Long id);
}
