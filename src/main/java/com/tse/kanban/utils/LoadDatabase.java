package com.tse.kanban.utils;

import java.time.LocalDate;
import java.time.Month;

import com.tse.kanban.service.TaskService;
import com.tse.kanban.utils.Constants;
import com.tse.kanban.utils.LoadDatabase;
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
	@Profile("!test")
	CommandLineRunner initDatabase(DeveloperRepository developerRepository,
									TaskRepository taskRepository,
									TaskStatusRepository taskStatusRepository,
									TaskTypeRepository taskTypeRepository,
									TaskService taskService) {
		
		return args -> {			
			initTaskStatusAndTypes(taskStatusRepository, taskTypeRepository);
			
			initDevelopers(developerRepository);					
		};
	}
	
	private void initDevelopers(DeveloperRepository developerRepository) {
		
		Developer dev1 = new Developer();
		dev1.setEmail("laila.abouzaid@gmail.com");
		dev1.setFirstname("Laila");
		dev1.setLastname("Abouzaid");
		dev1.setPassword("laila111");
		dev1.setStartContract(LocalDate.of(2019, Month.JULY, 1));
		developerRepository.save(dev1);
		log.info(dev1 + " saved to database.");
		
		Developer dev2 = new Developer();
		dev2.setEmail("asmae@gmail.com");
		dev2.setFirstname("Asmae");
		dev2.setLastname("Nedday");
		dev2.setPassword("asmae222");
		dev2.setStartContract(LocalDate.of(2020, Month.AUGUST, 1));
		developerRepository.save(dev2);
		log.info(dev2 + " saved to database.");
		
		Developer dev3 = new Developer();
		dev3.setEmail("mariam@gmail.com");
		dev3.setFirstname("Mariam");
		dev3.setLastname("Bouhriz");
		dev3.setPassword("mariam333");
		dev3.setStartContract(LocalDate.of(2021, Month.SEPTEMBER, 1));
		developerRepository.save(dev3);
		log.info(dev3 + " saved to database.");
	}
	
	private void initTaskStatusAndTypes(TaskStatusRepository taskStatusRepository,TaskTypeRepository taskTypeRepository) {
		//Statuses
		TaskStatus todo = new TaskStatus(Constants.TASK_STATUS_TODO_ID, Constants.TASK_STATUS_TODO_LABEL);
		taskStatusRepository.save(todo);
		log.info(todo + " saved to database.");
		
		TaskStatus doing = new TaskStatus(Constants.TASK_STATUS_DOING_ID, Constants.TASK_STATUS_DOING_LABEL);
		taskStatusRepository.save(doing);
		log.info(doing + " saved to database.");
		
		TaskStatus test = new TaskStatus(Constants.TASK_STATUS_TEST_ID, Constants.TASK_STATUS_TEST_LABEL);
		taskStatusRepository.save(test);
		log.info(test + " saved to database.");
		
		TaskStatus done = new TaskStatus(Constants.TASK_STATUS_DONE_ID, Constants.TASK_STATUS_DONE_LABEL);
		taskStatusRepository.save(done);
		log.info(done + " saved to database.");
		
		//TYPES
		TaskType feature = new TaskType(Constants.TASK_TYPE_FEATURE_ID, Constants.TASK_TYPE_FEATURE_LABEL);
		taskTypeRepository.save(feature);
		log.info(feature + " saved to database.");
		
		TaskType bug = new TaskType(Constants.TASK_TYPE_BUG_ID, Constants.TASK_TYPE_BUG_LABEL);
		taskTypeRepository.save(bug);
		log.info(bug + " saved to database.");
	}
	
	@Bean
	@Profile("test")
	CommandLineRunner initTestDatabase(DeveloperRepository developerRepository,
									TaskRepository taskRepository,
									TaskStatusRepository taskStatusRepository,
									TaskTypeRepository taskTypeRepository) {
		
		return args -> {			
			initTaskStatusAndTypes(taskStatusRepository, taskTypeRepository);
			//Developer
			Developer dev1 = new Developer();
			dev1.setEmail("dev1@dev.dev");
			dev1.setFirstname("dev1");
			dev1.setLastname("dev1");
			dev1.setPassword("dev1");
			dev1.setStartContract(LocalDate.of(2020, Month.JULY, 1));
			developerRepository.save(dev1);
			log.info(dev1 + " saved to database.");
			//Task
			Task task1 = new Task();
			task1.setCreated(LocalDate.now());
			task1.setTitle("task1");
			task1.setNbHoursForecast(0);
			task1.setNbHoursReal(0);
			task1.addDeveloper(dev1);
			task1.setType(taskTypeRepository.findById(Constants.TASK_TYPE_FEATURE_ID).orElse(null));
			task1.setStatus(taskStatusRepository.findById(Constants.TASK_STATUS_TODO_ID).orElse(null));
			taskRepository.save(task1);
			log.info(task1 + " saved to database.");
			
		};
	}
}