package com.divyansh.trainingplatform.service;

import com.divyansh.trainingplatform.dto.StudentRequestDto;
import com.divyansh.trainingplatform.model.Student;
import com.divyansh.trainingplatform.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(StudentRequestDto studentRequestDto){
        Student student = new Student();
        student.setName(studentRequestDto.getName());
        student.setEmail(studentRequestDto.getEmail());
        student.setPhone(studentRequestDto.getPhone());
        student.setDateOfBirth(studentRequestDto.getDateOfBirth());
        student.setPreviousCourses(studentRequestDto.getPreviousCourses());
        student.setAppliedSubject(studentRequestDto.getAppliedSubject());

        studentRepository.save(student);
        return "Student registered successfully with name: " + student.getName();

    }
}
