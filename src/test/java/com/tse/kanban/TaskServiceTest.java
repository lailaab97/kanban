package com.tse.kanban;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tse.kanban.domain.Task;
import com.tse.kanban.domain.TaskStatus;
import com.tse.kanban.service.impl.TaskServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskServiceTest {

	@Autowired
	private TaskServiceImpl taskServiceImpl;
	
	
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
		TaskStatus done = new TaskStatus(2L, "DONE");
		task.setStatus(todo);
		this.taskServiceImpl.moveRightTask(task);
		Assert.assertEquals("DONE",task.getStatus().getLabel());
	}
	
	@Test 
	public void moveLeftTaskTest() {
		Task task = new Task();
		TaskStatus todo = new TaskStatus(1L, "TODO");
		TaskStatus done = new TaskStatus(2L, "DONE");
		task.setStatus(done);
		this.taskServiceImpl.moveLeftTask(task);
		Assert.assertEquals("TODO",task.getStatus().getLabel());
	}
}
