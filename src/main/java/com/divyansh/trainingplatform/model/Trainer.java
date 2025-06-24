package com.divyansh.trainingplatform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trainer")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trainer_id")
    private Long Id;

    @Column(name = "name")
    private String name;

    @ElementCollection
    @CollectionTable(name = "trainer_subject_expertise", joinColumns = @JoinColumn(name = "trainer_id"))
    @Column(name = "subject_expertise")
    private List<String> subjectExpertise;
    @Column(name = "rating")
    private double rating;
    @Column(name = "years_of_experience")
    private double yearsOfExperience;
    @ElementCollection
    @CollectionTable(name = "trainer_availability", joinColumns = @JoinColumn(name = "trainer_id"))
    private List<AvailabilityPeriod> availabilityPeriods;

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
