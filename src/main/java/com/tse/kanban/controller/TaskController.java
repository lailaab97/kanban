package com.tse.kanban.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tse.kanban.domain.Task;
import com.tse.kanban.domain.TaskStatus;
import com.tse.kanban.domain.TaskType;
import com.tse.kanban.service.TaskService;
import com.tse.kanban.utils.Constants;
import com.tse.kanban.utils.TaskMoveAction;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.PATCH})
public class TaskController {


	@Autowired
	private TaskService taskService;
	
	@GetMapping("/tasks")
	Collection<Task> findAllTasks() {
		return this.taskService.findAllTasks();
	}
	
	@GetMapping("/task_types")
	Collection<TaskType> findAllTaskTypes() {
		return this.taskService.findAllTaskTypes();
	}
	
	@GetMapping("/task_statuses")
	Collection<TaskStatus> findAllTaskStatus() {
		return this.taskService.findAllTaskStatuses();
	}
	
	@PostMapping("/tasks")
	Task createTask(@Valid @RequestBody Task task) {
		
		return this.taskService.createTask(task);
	}
	
	@PatchMapping("/tasks/{id}")
	Task moveTask(@RequestBody TaskMoveAction taskMoveAction, @PathVariable Long id) {
		
		Task task = this.taskService.findTask(id);		
		if (Constants.MOVE_LEFT_ACTION.equals(taskMoveAction.getAction())) { 
			task = this.taskService.moveLeftTask(task);
		}
		else if (Constants.MOVE_RIGHT_ACTION.equals(taskMoveAction.getAction())) {
			task = this.taskService.moveRightTask(task);
		}
		else {
			throw new IllegalStateException();
		}
		return task;
	}
	}

