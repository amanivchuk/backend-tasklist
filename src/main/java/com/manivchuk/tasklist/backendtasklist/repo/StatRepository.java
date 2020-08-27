package com.manivchuk.tasklist.backendtasklist.repo;

import com.manivchuk.tasklist.backendtasklist.entity.Stat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatRepository extends JpaRepository<Stat, Long> {
}
