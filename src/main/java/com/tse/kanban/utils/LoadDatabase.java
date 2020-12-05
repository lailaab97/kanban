package com.tse.kanban.utils;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tse.kanban.dao.DeveloperRepository;
import com.tse.kanban.dao.TaskRepository;
import com.tse.kanban.dao.TaskStatusRepository;
import com.tse.kanban.dao.TaskTypeRepository;
import com.tse.kanban.domain.Developer;
import com.tse.kanban.domain.Task;
import com.tse.kanban.domain.TaskStatus;
import com.tse.kanban.domain.TaskType;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class LoadDatabase {

	@Bean
	CommandLineRunner initTestDatabase(TaskStatusRepository taskStatusRepository,
										TaskRepository taskRepository,
										TaskTypeRepository taskTypeRepository,
										DeveloperRepository developerRepository) {
		return args -> {
			
			initTaskStatusAndType(taskStatusRepository,taskTypeRepository);
			Developer dev1 = new Developer();
			dev1.setEmail("dev1@dev.com");
			dev1.setFirstname("dev1FirstName");
			dev1.setLastname("dev1LastName");
			dev1.setPassword("dev1");
			dev1.setStartContract(LocalDate.of(2017, Month.DECEMBER, 5));
			developerRepository.save(dev1);
			System.out.println(dev1.getFirstname()+ " saved to database");
			
			Task task1 = new Task();
			task1.setCreated(LocalDate.now());
			task1.setTitle("task1");
			task1.setNbHoursForecast(0);
			task1.setNbHoursReal(0);
			task1.addDeveloper(dev1);
			task1.setType(taskTypeRepository.findById(1L).orElse(null));
			task1.setStatus(taskStatusRepository.findById(1L).orElse(null));
			taskRepository.save(task1);
			System.out.println(task1.getTitle()+ " saved to database");

		};
		
			
		};
	
	
	private void initTaskStatusAndType(TaskStatusRepository taskStatusRepository, TaskTypeRepository taskTypeRepository)
	{
		TaskStatus todo = new TaskStatus(1L, "TODO");
		taskStatusRepository.save(todo);
		
		TaskStatus done = new TaskStatus(2L, "DONE");
		taskStatusRepository.save(done);
		
		TaskStatus doing = new TaskStatus(3L, "DOING");
		taskStatusRepository.save(doing);
		
		TaskType feature = new TaskType(1L, "FEATURE");
		taskTypeRepository.save(feature);
		
		TaskType bug = new TaskType(2L, "BUG");
		taskTypeRepository.save(bug);
		
	}
}
