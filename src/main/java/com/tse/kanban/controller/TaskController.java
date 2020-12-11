package com.tse.kanban.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tse.kanban.domain.Task;
import com.tse.kanban.domain.TaskStatus;
import com.tse.kanban.domain.TaskType;
import com.tse.kanban.service.TaskService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.PATCH})
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@GetMapping("/tasks")
	Collection<Task> findAllTasks(){
		return this.taskService.findAllTasks();
	}
	
	@GetMapping("/task_types")
	Collection<TaskType> findAllTaskTypes(){
		return this.taskService.findAllTaskTypes();
	}
	
	@GetMapping("/task_statuses")
	Collection<TaskStatus> findAllTaskStatuses(){
		return this.taskService.findAllTaskStatuses();
	}
	
	@GetMapping("/tasks/{id}")
	Task findTask(Long id){
		return this.taskService.findTask(id);
	}
	
//	@PostMapping("/tasks")
//	Task createTask(@Validated @RequestBody Task task) {
//		return this.taskService.createTask(task);
//	}
	
	
	}

