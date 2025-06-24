package com.divyansh.trainingplatform.dto;

import com.divyansh.trainingplatform.model.AvailabilityPeriod;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainerRequestDto {

    @NotBlank(message = "Name is required")
    private String name;

    @NotEmpty(message = "Subject expertise is required")
    private List<@NotBlank(message = "Subject name cannot be blank") String> subjectExpertise;

    @DecimalMin(value = "0.0", inclusive = false, message = "Rating must be greater than 0")
    @DecimalMax(value = "5.0", message = "Rating must not exceed 5.0")
    private double rating;

    @DecimalMin(value = "0.0", inclusive = false, message = "Experience must be greater than 0")
    private double yearsOfExperience;

    @NotEmpty(message = "Availability periods are required")
    private List<@Valid AvailabilityPeriod> availabilityPeriods;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSubjectExpertise() {
        return subjectExpertise;
    }

    public void setSubjectExpertise(List<String> subjectExpertise) {
        this.subjectExpertise = subjectExpertise;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(double yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public List<AvailabilityPeriod> getAvailabilityPeriods() {
        return availabilityPeriods;
    }

    public void setAvailabilityPeriods(List<AvailabilityPeriod> availabilityPeriods) {
        this.availabilityPeriods = availabilityPeriods;
    }
}
