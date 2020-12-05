package com.tse.kanban.service;

import java.util.Collection;

import com.tse.kanban.domain.Developer;

public interface DeveloperService {

	public Collection<Developer> findAllDevelopers();
	public Developer findDeveloper(Long id);
}
