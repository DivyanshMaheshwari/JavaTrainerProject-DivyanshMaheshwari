package com.divyansh.trainingplatform.dto;

import com.divyansh.trainingplatform.model.Batch;
import com.divyansh.trainingplatform.model.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class BatchResponseDto {
    private Long id;
    private String title;
    private String subject;
    private int maxCapacity;
    private LocalDate startDate;
    private LocalDate endDate;
    private String trainerName;
    private List<String> studentNames;

    // Constructor
    public BatchResponseDto(Batch batch) {
        this.id = batch.getId();
        this.title = batch.getTitle();
        this.subject = batch.getSubject();
        this.maxCapacity = batch.getMaxCapacity();
        this.startDate = batch.getStartDate();
        this.endDate = batch.getEndDate();
        this.trainerName = batch.getAssignedTrainer() != null ? batch.getAssignedTrainer().getName() : null;
        this.studentNames = batch.getEnrolledStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public List<String> getStudentNames() {
        return studentNames;
    }

    public void setStudentNames(List<String> studentNames) {
        this.studentNames = studentNames;
    }
}
