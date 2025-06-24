package com.divyansh.trainingplatform.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatchRequestDto {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Subject is required")
    private String subject;

    @Min(value = 1, message = "Max capacity must be at least 1")
    private int maxCapacity;

    @NotNull(message = "Start date is required")
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    private LocalDate endDate;

    @NotNull(message = "Assigned trainer ID is required")
    private Long assignedTrainerId;

    private List<Long> enrolledStudentIds;  // Optional at creation time

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

    public Long getAssignedTrainerId() {
        return assignedTrainerId;
    }

    public void setAssignedTrainerId(Long assignedTrainerId) {
        this.assignedTrainerId = assignedTrainerId;
    }

    public List<Long> getEnrolledStudentIds() {
        return enrolledStudentIds;
    }

    public void setEnrolledStudentIds(List<Long> enrolledStudentIds) {
        this.enrolledStudentIds = enrolledStudentIds;
    }
}
