package com.divyansh.trainingplatform.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")

    private Long Id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private Long phone;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @ElementCollection
    @CollectionTable(name = "student_previous_courses", joinColumns = @JoinColumn(name = "student_id"))
    @Column(name = "previous_courses")
    private List<String> previousCourses;
    @Column(name = "applied_subject")
    private String appliedSubject;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<String> getPreviousCourses() {
        return previousCourses;
    }

    public void setPreviousCourses(List<String> previousCourses) {
        this.previousCourses = previousCourses;
    }

    public String getAppliedSubject() {
        return appliedSubject;
    }

    public void setAppliedSubject(String appliedSubject) {
        this.appliedSubject = appliedSubject;
    }
}
