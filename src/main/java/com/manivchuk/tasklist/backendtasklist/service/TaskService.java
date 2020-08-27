package com.manivchuk.tasklist.backendtasklist.service;

import com.manivchuk.tasklist.backendtasklist.entity.Task;
import com.manivchuk.tasklist.backendtasklist.repo.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task add(Task task) {
        return taskRepository.save(task);
    }

    public Task update(Task task) {
        return taskRepository.save(task);
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    public Page findByParams(String text, Integer complete, Long priorityId, Long categoryId, PageRequest paging) {
        return taskRepository.findByParams(text, complete, priorityId, categoryId, paging);
    }

    public Task findById(Long id) {
        return taskRepository.findById(id).get();
    }
}
