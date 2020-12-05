package com.tse.kanban.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tse.kanban.domain.TaskStatus;

public interface TaskStatusRepository extends JpaRepository<TaskStatus, Long> {
	

}
