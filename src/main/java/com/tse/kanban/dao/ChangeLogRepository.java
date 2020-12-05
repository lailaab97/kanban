package com.tse.kanban.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tse.kanban.domain.ChangeLog;


public interface ChangeLogRepository extends JpaRepository<ChangeLog, Long> {

}
