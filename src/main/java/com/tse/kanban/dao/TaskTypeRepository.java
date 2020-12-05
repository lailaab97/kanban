package com.tse.kanban.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tse.kanban.domain.TaskType;

public interface TaskTypeRepository extends JpaRepository<TaskType, Long>  {

}
