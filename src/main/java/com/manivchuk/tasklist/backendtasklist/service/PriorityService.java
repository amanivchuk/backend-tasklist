package com.manivchuk.tasklist.backendtasklist.service;

import com.manivchuk.tasklist.backendtasklist.entity.Priority;
import com.manivchuk.tasklist.backendtasklist.repo.PriorityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PriorityService {

    private PriorityRepository priorityRepository;

    public PriorityService(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    public List<Priority> findAll() {
        return priorityRepository.findAllByOrderById();
    }

    public Priority add(Priority priority) {
        return priorityRepository.save(priority);
    }

    public Priority update(Priority priority) {
        return priorityRepository.save(priority);
    }

    public void deleteById(Long id) {
        priorityRepository.deleteById(id);
    }

    public Priority findById(Long id) {
        return priorityRepository.findById(id).get();
    }

    public List<Priority> findByTitle(String text) {
        return priorityRepository.findByTitle(text);
    }


}
