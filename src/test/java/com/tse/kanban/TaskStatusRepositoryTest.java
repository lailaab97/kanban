package com.tse.kanban;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tse.kanban.dao.TaskStatusRepository;
import com.tse.kanban.dao.TaskTypeRepository;
import com.tse.kanban.domain.TaskStatus;
import com.tse.kanban.domain.TaskType;

import org.junit.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskStatusRepositoryTest {

	@Autowired
	private TaskStatusRepository taskStatusRepository;
	
	@Test
	public void testFindAllTaskStatus() {
		Collection<TaskStatus> taskStatusList = this.taskStatusRepository.findAll();
		Assert.assertEquals(3, taskStatusList.size());
	}
	

}
