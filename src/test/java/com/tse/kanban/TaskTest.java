package com.tse.kanban;

import java.time.LocalDate;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tse.kanban.dao.ChangeLogRepository;
import com.tse.kanban.dao.TaskRepository;
import com.tse.kanban.dao.TaskStatusRepository;
import com.tse.kanban.dao.TaskTypeRepository;
import com.tse.kanban.domain.ChangeLog;
import com.tse.kanban.domain.Developer;
import com.tse.kanban.domain.Task;
import com.tse.kanban.domain.TaskStatus;
import com.tse.kanban.domain.TaskType;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskTest {
	
	@Autowired
	private TaskTypeRepository taskTypeRepository;
	
	@Autowired
	private TaskStatusRepository taskStatusRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private ChangeLogRepository changeLogRepository;

	@Test
	public void testSaveTask() {
		Task task = new Task();
		task.setTitle("TEST");
		task.setNbHoursForecast(1);
		task.setNbHoursReal(3);
		task.setCreated(LocalDate.now());
		task.setType(taskTypeRepository.findById(1L).orElse(null));
		task.setStatus(taskStatusRepository.findById(1L).orElse(null));
		taskRepository.save(task);
		
		Collection<Task> tasks = this.taskRepository.findAll();
		Assert.assertEquals(2, tasks.size());
		
		this.taskRepository.delete(task);

	}
	@Test
	public void testAddDeveloper() {
		Developer dev1 = new Developer();
		Task task1 = new Task();
		task1.addDeveloper(dev1);
		Assert.assertEquals(1, task1.getDevelopers().size());
		
	}
	
	@Test 
	public void addChangeLogTest() {
				//TaskStatus
				TaskStatus todo = new TaskStatus(1L, "TODO");
				TaskStatus done = new TaskStatus(2L, "DONE");
				
				//TaskType
				TaskType type = new TaskType();
				type.setLabel("TestLabel");
				this.taskTypeRepository.save(type);
				
				//Task
				Task task = new Task();
				task.setTitle("TEST");
				task.setNbHoursForecast(1);
				task.setNbHoursReal(3);
				task.setCreated(LocalDate.now());
				task.setType(type);
				task.setStatus(todo);
				this.taskRepository.save(task);
				
				//ChangeLog
				ChangeLog changeLog = new ChangeLog();
				changeLog.setOccuredDate(LocalDate.now());
				changeLog.setTask(task);
				changeLog.setSourceStatus(todo);
				changeLog.setTargetStatus(done);
				this.changeLogRepository.save(changeLog);
				
				task.addChangeLog(changeLog);
				
				Assert.assertEquals(changeLog.getTask(),task);
				
				//Delete
				this.taskRepository.delete(task);
				this.changeLogRepository.delete(changeLog);
				this.taskTypeRepository.delete(type);
	}
	
	@Test
	public void clearChangeLogsTest() {
		//TaskStatus
		TaskStatus todo = new TaskStatus(1L, "TODO");
		TaskStatus done = new TaskStatus(2L, "DONE");
		
		//TaskType
		TaskType type = new TaskType();
		type.setLabel("TestLabel");
		this.taskTypeRepository.save(type);
		
		//Task
		Task task = new Task();
		task.setTitle("TEST");
		task.setNbHoursForecast(1);
		task.setNbHoursReal(3);
		task.setCreated(LocalDate.now());
		task.setType(type);
		task.setStatus(todo);
		this.taskRepository.save(task);
		
		//ChangeLog 1 
		ChangeLog changeLog = new ChangeLog();
		changeLog.setOccuredDate(LocalDate.now());
		changeLog.setTask(task);
		changeLog.setSourceStatus(todo);
		changeLog.setTargetStatus(done);
		this.changeLogRepository.save(changeLog);
		
		task.addChangeLog(changeLog);

		
		
		Collection<ChangeLog> changeLogs = this.taskRepository.findById(task.getId()).orElse(null).getChangeLogs();
		Assert.assertEquals(1,changeLogs.size());
		Assert.assertEquals(changeLog.getTask(), task);
		
		task.clearChangeLogs();
		this.taskRepository.save(task);
		Assert.assertEquals(null, changeLog.getTask());

		//Delete
		this.taskRepository.delete(task);
		this.changeLogRepository.delete(changeLog);
		this.taskTypeRepository.delete(type);
	}
	


}
