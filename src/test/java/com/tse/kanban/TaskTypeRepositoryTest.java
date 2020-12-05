package com.tse.kanban;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tse.kanban.dao.TaskTypeRepository;
import com.tse.kanban.domain.TaskStatus;
import com.tse.kanban.domain.TaskType;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskTypeRepositoryTest {

	@Autowired
	private TaskTypeRepository taskTypeRepository;
	
	
	@Test
	public void testSaveTaskStatus() {
		TaskType type = new TaskType();
		type.setLabel("TestLabel");
		this.taskTypeRepository.save(type);
		Collection<TaskType> taskTypeList = this.taskTypeRepository.findAll();
		Assert.assertEquals(3, taskTypeList.size());
		this.taskTypeRepository.delete(type);
	}
	
	@Test
	public void testFindAllTaskType() {
		Collection<TaskType> taskTypeList = this.taskTypeRepository.findAll();
		Assert.assertEquals(2, taskTypeList.size());
	}
	
}
