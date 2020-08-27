package com.manivchuk.tasklist.backendtasklist.service;

import com.manivchuk.tasklist.backendtasklist.entity.Stat;
import com.manivchuk.tasklist.backendtasklist.repo.StatRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StatService {

    private StatRepository statRepository;

    public StatService(StatRepository statRepository) {
        this.statRepository = statRepository;
    }

    public Stat findById(Long id) {
        return statRepository.findById(id).get();
    }

}
