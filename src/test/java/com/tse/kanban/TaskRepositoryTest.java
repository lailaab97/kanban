package com.tse.kanban;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tse.kanban.dao.TaskRepository;
import com.tse.kanban.domain.Developer;
import com.tse.kanban.domain.Task;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskRepositoryTest {

	@Autowired
	private TaskRepository taskRepository;
	
//	@Test
//	public void testFindAllTasks() {
//		Collection<Task> taskList = this.taskRepository.findAll();
//		Assert.assertEquals(1, taskList.size());
//	}
	
	@Test
	public void testAddDeveloper() {
		Developer dev1 = new Developer();
		Task task1 = new Task();
		task1.addDeveloper(dev1);
		Assert.assertEquals(1, task1.getDevelopers().size());
	}
	
}
