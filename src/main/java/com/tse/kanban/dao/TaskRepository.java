package com.tse.kanban.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tse.kanban.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long>  {

}
