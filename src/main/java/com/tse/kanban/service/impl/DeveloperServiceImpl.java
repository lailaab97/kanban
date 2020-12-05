package com.tse.kanban.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tse.kanban.dao.DeveloperRepository;
import com.tse.kanban.domain.Developer;
import com.tse.kanban.service.DeveloperService;
@Service
public class DeveloperServiceImpl implements DeveloperService {
	
	@Autowired
	private DeveloperRepository developerRepository;

	@Override
	@Transactional(readOnly = true)
	public Collection<Developer> findAllDevelopers() {
		return this.developerRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Developer findDeveloper(Long id) {
		return this.developerRepository.findById(id).orElse(null);
	}
}
