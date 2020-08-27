package com.manivchuk.tasklist.backendtasklist.repo;

import com.manivchuk.tasklist.backendtasklist.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByOrderByTitleAsc();

    @Query("select c from Category  c where " +
            "(:title is null or :title='' or lower(c.title) " +
            "like lower(concat('%',:title,'%'))) " +
            "order by c.title asc")
    List<Category> findByTitle(@Param("title") String title);
}
