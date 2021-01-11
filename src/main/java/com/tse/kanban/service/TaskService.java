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
	public Task moveRightTask(Task task);
	public Task moveLeftTask(Task task);
	public Task changeTaskStatus(Task task, TaskStatus targetStatus);
	public boolean displayMoveRightForTask(Task task);
	public boolean displayMoveLeftForTask(Task task);
	public Task createTask(Task task);
	public void deleteTask(Task task);
	public TaskType findTaskType(Long id);
	public TaskStatus findTaskStatus(Long id);
	public Collection<ChangeLog> findChangeLogsForTask(Task task);
}
