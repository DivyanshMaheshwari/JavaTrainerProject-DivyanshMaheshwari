package com.divyansh.trainingplatform.repository;

import com.divyansh.trainingplatform.model.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long> {
    List<Batch> findBySubjectIgnoreCase(String subject);
}
