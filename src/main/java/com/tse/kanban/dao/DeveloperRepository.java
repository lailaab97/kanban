package com.tse.kanban.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tse.kanban.domain.Developer;


public interface DeveloperRepository extends JpaRepository<Developer, Long>  {

}
