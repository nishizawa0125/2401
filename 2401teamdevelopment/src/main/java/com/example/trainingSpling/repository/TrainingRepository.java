package com.example.trainingSpling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.trainingSpling.entity.TrainingEntity;

/**
 * 科目情報 Repository
 */
@Repository
public interface TrainingRepository extends JpaRepository<TrainingEntity, Integer> {
}
