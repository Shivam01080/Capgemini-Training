package com.gal.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gal.model.Training;
import com.gal.service.TrainingService;

@RestController
@RequestMapping("/trainings")
public class TrainingController {

    @Autowired
    TrainingService service;

    @GetMapping
    public List<Training> getAll(){
        return service.getAll();
    }

    @GetMapping(params="name")
    public List<Training> search(@RequestParam String name){
        return service.searchTopic(name);
    }

    @GetMapping("/upcoming")
    public List<Training> upcoming(@RequestParam String name){
        return service.upcomingTraining(name);
    }
}