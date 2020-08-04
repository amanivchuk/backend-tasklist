package com.manivchuk.tasklist.backendtasklist.repo;

import com.manivchuk.tasklist.backendtasklist.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
