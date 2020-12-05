package com.tse.kanban;

import java.time.LocalDate;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tse.kanban.dao.TaskRepository;
import com.tse.kanban.dao.TaskStatusRepository;
import com.tse.kanban.dao.TaskTypeRepository;
import com.tse.kanban.domain.Developer;
import com.tse.kanban.domain.Task;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskTest {
	
	@Autowired
	private TaskTypeRepository taskTypeRepository;
	
	@Autowired
	private TaskStatusRepository taskStatusRepository;
	
	@Autowired
	private TaskRepository taskRepository;

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
	
}
