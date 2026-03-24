package com.gal.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gal.model.Training;

public interface TrainingRepository extends JpaRepository<Training,Integer>{

    @Query("from Training t where t.topic like %:name%")
    List<Training> findByTopic(String name);
    @Query("from Training t where t.endDate >= :date")
    List<Training> findCurrentAndUpcoming(LocalDate date);

}