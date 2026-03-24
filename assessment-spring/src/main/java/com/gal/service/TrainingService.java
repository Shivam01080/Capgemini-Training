package com.gal.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gal.dao.TrainingRepository;
import com.gal.model.Training;

@Service
public class TrainingService {

    @Autowired
    TrainingRepository repo;

    public List<Training> getAll(){
        return repo.findAll();
    }

    public List<Training> searchTopic(String name){
        return repo.findByTopic(name);
    }

    public List<Training> upcomingTraining(String name){
        return repo.findCurrentAndUpcoming( LocalDate.now());
    }
}