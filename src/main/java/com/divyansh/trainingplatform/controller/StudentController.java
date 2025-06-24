package com.divyansh.trainingplatform.controller;

import com.divyansh.trainingplatform.dto.StudentRequestDto;
import com.divyansh.trainingplatform.dto.TrainerRequestDto;
import com.divyansh.trainingplatform.model.Student;
import com.divyansh.trainingplatform.service.StudentService;
import com.divyansh.trainingplatform.service.TrainerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/register-student")
    public ResponseEntity<String> addStudent(@RequestBody @Valid StudentRequestDto studentRequestDto) {
        String studentResponse  =  studentService.addStudent(studentRequestDto);
        return ResponseEntity.status(201).body(studentResponse);
    }
}
