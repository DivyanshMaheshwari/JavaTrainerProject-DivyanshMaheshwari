package com.divyansh.trainingplatform.repository;

import com.divyansh.trainingplatform.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer,Long> {
}
