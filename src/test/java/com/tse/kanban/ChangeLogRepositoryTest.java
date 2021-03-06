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
import com.tse.kanban.domain.ChangeLog;
import com.tse.kanban.domain.Task;
import com.tse.kanban.domain.TaskStatus;
import com.tse.kanban.domain.TaskType;


@SpringBootTest
@RunWith(SpringRunner.class)
public class ChangeLogRepositoryTest {
	
	@Autowired
	private ChangeLogRepository changeLogRepository;
	
	@Test
	public void saveChangeLog()
	{
		//TaskStatus
		TaskStatus todo = new TaskStatus(1L, "TODO");
		TaskStatus done = new TaskStatus(2L, "DONE");
		
		//TaskType
		TaskType type = new TaskType();
		type.setLabel("TestLabel");
		
		//Task
		Task task = new Task();
		task.setTitle("TEST");
		task.setNbHoursForecast(1);
		task.setNbHoursReal(3);
		task.setCreated(LocalDate.now());
		task.setType(type);
		task.setStatus(todo);
		
		//ChangeLog
		ChangeLog changeLog = new ChangeLog();
		changeLog.setOccuredDate(LocalDate.now());
		changeLog.setTask(task);
		changeLog.setSourceStatus(todo);
		changeLog.setTargetStatus(done);
		changeLogRepository.save(changeLog);
		Collection<ChangeLog> changeLogs = this.changeLogRepository.findAll();
		Assert.assertEquals(1, changeLogs.size());
		this.changeLogRepository.delete(changeLog);
	}

}
