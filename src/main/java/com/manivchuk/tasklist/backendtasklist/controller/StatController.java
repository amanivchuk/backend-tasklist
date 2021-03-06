package com.manivchuk.tasklist.backendtasklist.controller;

import com.manivchuk.tasklist.backendtasklist.entity.Stat;
import com.manivchuk.tasklist.backendtasklist.service.StatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StatController {

    private final Long defaultId = 1l;
    private StatService statService;

    public StatController(StatService statRepository) {
        this.statService = statRepository;
    }

    @GetMapping("/stat")
    public ResponseEntity<Stat> findById() {
        return ResponseEntity.ok(statService.findById(defaultId));
    }

}
