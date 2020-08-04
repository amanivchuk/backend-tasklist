package com.manivchuk.tasklist.backendtasklist.controller;

import com.manivchuk.tasklist.backendtasklist.entity.Priority;
import com.manivchuk.tasklist.backendtasklist.repo.PriorityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/priority")
public class PriorityController {

    private final PriorityRepository priorityRepository;

    public PriorityController(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @GetMapping("/test")
    public List<Priority> test(){
        List<Priority> list = priorityRepository.findAll();
        System.out.println(list);

        return list;
    }

    @PostMapping("/add")
    public ResponseEntity<Priority> add(@RequestBody Priority priority){

        if(priority.getId() != null && priority.getId() != 0){
            return new ResponseEntity("redundant paramL id MUST be null", HttpStatus.NOT_ACCEPTABLE);
        }

        if(priority.getTitle() == null || priority.getTitle().trim().length() == 0){
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(priorityRepository.save(priority));

    }

}
