package com.divyansh.trainingplatform.service;

import com.divyansh.trainingplatform.dto.BatchRequestDto;
import com.divyansh.trainingplatform.dto.BatchResponseDto;
import com.divyansh.trainingplatform.model.Batch;
import com.divyansh.trainingplatform.model.Student;
import com.divyansh.trainingplatform.model.Trainer;
import com.divyansh.trainingplatform.repository.BatchRepository;
import com.divyansh.trainingplatform.repository.StudentRepository;
import com.divyansh.trainingplatform.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BatchService {

    @Autowired
    private BatchRepository batchRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private StudentRepository studentRepository;

    public String createBatch(BatchRequestDto dto) {
        Trainer trainer = trainerRepository.findById(dto.getAssignedTrainerId())
                .orElseThrow(() -> new RuntimeException("Trainer not found with id: " + dto.getAssignedTrainerId()));

        List<Student> students = studentRepository.findAllById(dto.getEnrolledStudentIds());

        Batch batch = new Batch();
        batch.setTitle(dto.getTitle());
        batch.setSubject(dto.getSubject());
        batch.setMaxCapacity(dto.getMaxCapacity());
        batch.setStartDate(dto.getStartDate());
        batch.setEndDate(dto.getEndDate());
        batch.setAssignedTrainer(trainer);
        batch.setEnrolledStudents(students);

        batchRepository.save(batch);

        return "Batch created successfully with title: " + batch.getTitle();
    }
    public List<BatchResponseDto> getBatchesBySubject(String subject) {
        List<Batch> batches = batchRepository.findBySubjectIgnoreCase(subject);
        return batches.stream().map(BatchResponseDto::new).collect(Collectors.toList());
    }

}
