package com.javaguides.student_management_system.service.impl;

import com.javaguides.student_management_system.dto.StudentDto;
import com.javaguides.student_management_system.entity.Student;
import com.javaguides.student_management_system.mapper.StudentMapper;
import com.javaguides.student_management_system.repository.StudentRepository;
import com.javaguides.student_management_system.service.StudentService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    @Override
    public StudentDto createStudentDto(Student student) {
        Student savestudent = studentRepository.save(student);
        StudentDto studentdto = StudentMapper.maptoStudentDto(savestudent);
        return studentdto;
    }


    @Override
    public StudentDto getStudentDto(Long id) {
        Student student = studentRepository.findById(id).orElseThrow();
        StudentDto studentDto = StudentMapper.maptoStudentDto(student);
        return studentDto;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = students.stream().map((student -> StudentMapper.maptoStudentDto(student))).collect(Collectors.toList());

        return studentDtos;
    }

    @Override
    public StudentDto updateStudentDto(Student student, Long id) {
        Student savestudent = studentRepository.findById(id).orElseThrow();
        savestudent.setId(student.getId());
        savestudent.setFirstName(student.getFirstName());
        savestudent.setLastName(student.getLastName());
        savestudent.setEmail(student.getEmail());
        Student updatedStudent = studentRepository.save(savestudent);
        StudentDto studentDto = StudentMapper.maptoStudentDto(updatedStudent);
        return studentDto;

    }

    @Override
    public String deleteStudent(Long id) {
        Student student = studentRepository.findById(id).orElseThrow();
        studentRepository.delete(student);
        return ("deleted sucessfully");
    }


}
