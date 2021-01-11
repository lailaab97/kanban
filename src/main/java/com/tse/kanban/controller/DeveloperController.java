package com.tse.kanban.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tse.kanban.domain.Developer;
import com.tse.kanban.service.DeveloperService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DeveloperController {

	@Autowired
	private DeveloperService developerService;
	
	@GetMapping("/developers")
	Collection<Developer> findAllDevelopers() {
		return this.developerService.findAllDevelopers();
	}
}
