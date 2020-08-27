package com.manivchuk.tasklist.backendtasklist.controller;

import com.manivchuk.tasklist.backendtasklist.entity.Priority;
import com.manivchuk.tasklist.backendtasklist.search.PrioritySearchValues;
import com.manivchuk.tasklist.backendtasklist.service.PriorityService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/priority")
@CrossOrigin(origins = "http://localhost:4200")
public class PriorityController {

    private final PriorityService priorityService;

    public PriorityController(PriorityService priorityRepository) {
        this.priorityService = priorityRepository;
    }

    @GetMapping("/all")
    public List<Priority> findAll() {
        List<Priority> list = priorityService.findAll();
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

        if (priority.getColor() == null || priority.getColor().trim().length() == 0)
            return new ResponseEntity("missed param: color", HttpStatus.NOT_ACCEPTABLE);


        return ResponseEntity.ok(priorityService.add(priority));
    }

    @PutMapping("/update")
    public ResponseEntity<Priority> update(@RequestBody Priority priority) {
        if (priority.getId() == null || priority.getId() == 0)
            return new ResponseEntity("missed param: id", HttpStatus.NOT_ACCEPTABLE);

        if (priority.getTitle() == null || priority.getTitle().trim().length() == 0)
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);

        if (priority.getColor() == null || priority.getColor().trim().length() == 0)
            return new ResponseEntity("missed param: color", HttpStatus.NOT_ACCEPTABLE);


        return ResponseEntity.ok(priorityService.update(priority));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Priority> findById(@PathVariable Long id) {
        Priority priority = null;

        try {
            priority = priorityService.findById(id);
        } catch (NoSuchElementException e) {
            return new ResponseEntity("id = " + id + " not found.", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(priority);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Priority> delete(@PathVariable Long id) {
        try {
            priorityService.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity("id=" + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Priority>> search(@RequestBody PrioritySearchValues priority) {
        return ResponseEntity.ok(priorityService.findByTitle(priority.getTitle()));
    }
}
