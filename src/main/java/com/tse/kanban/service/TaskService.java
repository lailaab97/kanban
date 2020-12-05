package com.tse.kanban.service;

import java.util.Collection;

import com.tse.kanban.domain.ChangeLog;
import com.tse.kanban.domain.Developer;
import com.tse.kanban.domain.Task;
import com.tse.kanban.domain.TaskStatus;
import com.tse.kanban.domain.TaskType;

public interface TaskService {
	
	public Collection<Task> findAllTasks();
	public Collection<TaskType> findAllTaskTypes();
	public Collection<TaskStatus> findAllTaskStatuses();
	public Task findTask(Long id);
	public void moveRightTask(Task task);
	public void moveLeftTask(Task task);
	
	
	//ADDITIONAL
	TaskType findTaskType(Long id);
	TaskStatus findTaskStatus(Long id);
	Collection<ChangeLog> findChangeLogsForTask(Task task);
}
