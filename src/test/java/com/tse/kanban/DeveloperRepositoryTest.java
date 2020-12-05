package com.tse.kanban;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tse.kanban.dao.DeveloperRepository;
import com.tse.kanban.domain.Developer;


@SpringBootTest
@RunWith(SpringRunner.class)
public class DeveloperRepositoryTest {
	
	@Autowired
	private DeveloperRepository developerRepository;
	
	@Test
	public void findAllDevelopersTest() {
		Collection<Developer> developerList = this.developerRepository.findAll();
		Assert.assertEquals(1,developerList.size());
	}

}
