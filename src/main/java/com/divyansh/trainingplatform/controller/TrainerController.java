package com.divyansh.trainingplatform.controller;

import com.divyansh.trainingplatform.dto.TrainerRequestDto;
import com.divyansh.trainingplatform.model.Trainer;
import com.divyansh.trainingplatform.service.TrainerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainer")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @PostMapping("/register-trainer")
    public ResponseEntity<String> addTrainer(@RequestBody @Valid TrainerRequestDto trainerRequestDto){
        String trainerResponse = trainerService.addTrainer(trainerRequestDto);
        return ResponseEntity.status(201).body(trainerResponse);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getTrainerById(@PathVariable Long id){
        Trainer trainer = trainerService.getTrainerById(id);
        return ResponseEntity.ok(trainer);
    }
    @GetMapping("/getAllTrainer")
    public ResponseEntity<?> getAllTrainer(){
        List<Trainer> trainer = trainerService.getAllTrainer();
        return ResponseEntity.ok(trainer);
    }
}
