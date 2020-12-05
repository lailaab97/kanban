package com.tse.kanban.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tse.kanban.dao.TaskRepository;
import com.tse.kanban.dao.TaskStatusRepository;
import com.tse.kanban.dao.TaskTypeRepository;
import com.tse.kanban.domain.Task;
import com.tse.kanban.domain.TaskStatus;
import com.tse.kanban.domain.TaskType;
import com.tse.kanban.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private TaskTypeRepository taskTypeRepository;
	@Autowired
	private TaskStatusRepository taskStatusRepository;
	
	
	@Override
	@Transactional(readOnly = true)
	public Collection<Task> findAllTasks() {
		return this.taskRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<TaskType> findAllTasksType() {
		return this.taskTypeRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<TaskStatus> findAllTasksStatus() {
		return this.taskStatusRepository.findAll();
	}


	@Override
	@Transactional(readOnly = true)
	public Task findTask(Long id) {
		return this.taskRepository.findById(id).orElse(null);
	}

	

	@Override
	@Transactional(readOnly = true)
	public void moveLeftTask(Task task) {
		Long statusId = task.getStatus().getId();
		TaskStatus status = this.taskStatusRepository.findById(statusId - 1).orElse(null);
		task.setStatus(status);
		System.out.println(statusId + " " + status.getId());
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<TaskType> findAllTaskTypes() {
		return this.taskTypeRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<TaskStatus> findAllTaskStatus() {
		return this.taskStatusRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public TaskType findTaskType(Long id) {
		return this.taskTypeRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public TaskStatus findTaskStatus(Long id) {
		return this.taskStatusRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public void moveRightTask(Task task) {
		Long statusId = task.getStatus().getId();
		TaskStatus status = this.taskStatusRepository.findById(statusId + 1).orElse(null);
		task.setStatus(status);
		System.out.println(statusId + " " + status.getId());
	}


}
