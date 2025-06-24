package com.divyansh.trainingplatform.controller;

import com.divyansh.trainingplatform.dto.BatchRequestDto;
import com.divyansh.trainingplatform.dto.BatchResponseDto;
import com.divyansh.trainingplatform.model.Batch;
import com.divyansh.trainingplatform.service.BatchService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/batch")
public class BatchController {
    @Autowired
    private BatchService batchService;

    @PostMapping("/create")
    public ResponseEntity<?> createBatch(@RequestBody @Valid BatchRequestDto batchRequestDto) {
        String batchResponse = batchService.createBatch(batchRequestDto);
        return ResponseEntity.status(201).body(batchResponse);
    }
    @GetMapping("/subject/{subject}")
    public ResponseEntity<List<BatchResponseDto>> getBatchesBySubject(@PathVariable String subject) {
        List<BatchResponseDto> response = batchService.getBatchesBySubject(subject);
        return ResponseEntity.ok(response);
    }

}
