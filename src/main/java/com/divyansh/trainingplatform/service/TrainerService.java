package com.divyansh.trainingplatform.service;

import com.divyansh.trainingplatform.dto.TrainerRequestDto;
import com.divyansh.trainingplatform.model.Trainer;
import com.divyansh.trainingplatform.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {
    @Autowired
    private TrainerRepository trainerRepository;

    public String addTrainer(TrainerRequestDto trainerRequestDto) {
        Trainer trainer = new Trainer();

        trainer.setName(trainerRequestDto.getName());
        trainer.setRating(trainerRequestDto.getRating());
        trainer.setYearsOfExperience(trainerRequestDto.getYearsOfExperience());
        trainer.setAvailabilityPeriods(trainerRequestDto.getAvailabilityPeriods());
        trainer.setSubjectExpertise(trainerRequestDto.getSubjectExpertise());

        trainerRepository.save(trainer);

        return "Trainer registered successfully with name: " + trainer.getName();
    }
    public Trainer getTrainerById(Long id){
        return trainerRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Trainer not found with id: " + id));
    }

    public List<Trainer> getAllTrainer(){
        return trainerRepository.findAll();
    }
}
