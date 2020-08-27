package com.manivchuk.tasklist.backendtasklist.repo;

import com.manivchuk.tasklist.backendtasklist.entity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PriorityRepository extends JpaRepository<Priority, Long> {

    List<Priority> findAllByOrderById();

    @Query("select p from Priority p where " +
            "(:priority is null or :priority='' or " +
            "lower(p.title) like lower(concat('%', :title, '%'))) " +
            "order by p.title asc")
    List<Priority> findByTitle(@Param("title") String title);
}
