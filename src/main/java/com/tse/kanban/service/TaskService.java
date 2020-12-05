package com.tse.kanban.service;

import java.util.Collection;

import com.tse.kanban.domain.Developer;
import com.tse.kanban.domain.Task;
import com.tse.kanban.domain.TaskStatus;
import com.tse.kanban.domain.TaskType;

public interface TaskService {
	
	public Collection<Task> findAllTasks();
	public Collection<TaskType> findAllTasksType();
	public Collection<TaskStatus> findAllTasksStatus();
	public Task findTask(Long id);
	public void moveRightTask(Task task);
	public void moveLeftTask(Task task);
	
	
	//ADDITIONAL
	Collection<TaskType> findAllTaskTypes();
	Collection<TaskStatus> findAllTaskStatus();
	TaskType findTaskType(Long id);
	TaskStatus findTaskStatus(Long id);
}
