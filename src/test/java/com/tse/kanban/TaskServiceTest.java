package com.tse.kanban;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
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
import com.tse.kanban.domain.Task;
import com.tse.kanban.domain.TaskStatus;
import com.tse.kanban.domain.TaskType;
import com.tse.kanban.service.impl.TaskServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskServiceTest {

	@Autowired
	private TaskServiceImpl taskServiceImpl;
	
	@Autowired
	private TaskTypeRepository taskTypeRepository;
	
	@Autowired
	private TaskStatusRepository taskStatusRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private ChangeLogRepository changeLogRepository;
	
	Task task = new Task();

	@Before
	public void before() {
	this.taskRepository.save(task);
	}
	
	@After
	public void after() {
		
		this.taskRepository.delete(task);
	
	}
	
	@Test
	public void findAllTasksTest() {
		Collection<Task> taskList = this.taskServiceImpl.findAllTasks();
		Assert.assertEquals(1, taskList.size());
	}
	
	@Test 
	public void findTaskTest() {

		Collection<Task> taskList = this.taskServiceImpl.findAllTasks();
		Task task1 = taskList.iterator().next();
		Long idTask = task1.getId();
		Task task = this.taskServiceImpl.findTask(idTask);
		Assert.assertEquals(idTask, task.getId());
	}
	
	@Test 
	public void moveRightTaskTest() {
		Task task = new Task();
		TaskStatus todo = new TaskStatus(1L, "TODO");
		TaskStatus doing = new TaskStatus(2L, "DOING");
		task.setStatus(todo);
		this.taskServiceImpl.moveRightTask(task);
		Assert.assertEquals("DOING",task.getStatus().getLabel());
	}
	
	@Test 
	public void moveLeftTaskTest() {
		Task task = new Task();
		TaskStatus todo = new TaskStatus(1L, "TODO");
		TaskStatus doing = new TaskStatus(2L, "DOING");
		task.setStatus(doing);
		this.taskServiceImpl.moveLeftTask(task);
		Assert.assertEquals("TODO",task.getStatus().getLabel());
	}
	
//	@Test
//	public void findChangeLogsForTaskTest() {
//		//TaskStatus
//				TaskStatus todo = new TaskStatus(1L, "TODO");
//				TaskStatus done = new TaskStatus(2L, "DONE");
//				
//				//TaskType
//				TaskType type = new TaskType();
//				type.setLabel("TestLabel");
//				this.taskTypeRepository.save(type);
//
//				//Task
//				Task task = new Task();
//				task.setTitle("TEST");
//				task.setNbHoursForecast(1);
//				task.setNbHoursReal(3);
//				task.setCreated(LocalDate.now());
//				task.setType(type);
//				task.setStatus(todo);
//				
//				this.taskRepository.save(task);
//
//				
//				//ChangeLog
//				ChangeLog changeLog = new ChangeLog();
//				changeLog.setOccuredDate(LocalDate.now());
//				changeLog.setTask(task);
//				changeLog.setSourceStatus(todo);
//				changeLog.setTargetStatus(done);
//				this.changeLogRepository.save(changeLog);
//				
//				task.addChangeLog(changeLog);
//
//				Collection<ChangeLog> changeLogs = this.taskServiceImpl.findChangeLogsForTask(task);
//				Collection<ChangeLog> changeLogsTest = task.getChangeLogs();
//				Long id = changeLogs.iterator().next().getTask().getId();
//
//				Assert.assertEquals(1, changeLogsTest.size());
//				Assert.assertEquals(id, changeLogsTest.iterator().next().getTask().getId());
//
//				//DELETE
//				this.taskRepository.delete(task);
//				this.changeLogRepository.delete(changeLog);
//				this.taskTypeRepository.delete(type);
//				
//	}
}
