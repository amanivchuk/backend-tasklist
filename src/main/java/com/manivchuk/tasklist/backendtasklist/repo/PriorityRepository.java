package com.manivchuk.tasklist.backendtasklist.repo;

import com.manivchuk.tasklist.backendtasklist.entity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriorityRepository extends JpaRepository<Priority, Long> {

}
