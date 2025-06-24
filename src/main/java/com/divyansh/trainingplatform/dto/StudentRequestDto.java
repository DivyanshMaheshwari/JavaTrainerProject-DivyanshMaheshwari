package com.divyansh.trainingplatform.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDto {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @NotNull(message = "Phone number is required")
    @Min(value = 1000000000, message = "Phone number must be 10 digits")
    @Max(value = 9999999999L, message = "Phone number must be 10 digits")
    private Long phone;

    @NotNull(message = "Date of birth is required")
    private LocalDate dateOfBirth;

    @NotNull(message = "Previous courses are required")
    @Size(min = 1, message = "At least one course must be provided")
    private List<@NotBlank(message = "Course name cannot be blank") String> previousCourses;

    @NotBlank(message = "Applied subject is required")
    private String appliedSubject;

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
