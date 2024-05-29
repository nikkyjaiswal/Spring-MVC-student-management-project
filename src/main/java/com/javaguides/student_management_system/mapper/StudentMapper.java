package com.javaguides.student_management_system.mapper;

import com.javaguides.student_management_system.dto.StudentDto;
import com.javaguides.student_management_system.entity.Student;

public class StudentMapper {
    public static StudentDto maptoStudentDto(Student student) {
        StudentDto studentDto = new StudentDto(student.getId(),
                student.getFirstName(),
                student.getFirstName(),
                student.getEmail());
        return studentDto;
    }

    public static Student maptoStudent(StudentDto studentDto) {
        Student student = new Student(studentDto.getId(),
                studentDto.getFirstName(),
                studentDto.getFirstName(),
                studentDto.getEmail());
        return student;
    }


}
