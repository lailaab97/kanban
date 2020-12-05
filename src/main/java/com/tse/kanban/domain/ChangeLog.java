package com.tse.kanban.domain;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class ChangeLog {
	
	private @Id @GeneratedValue Long id;
	@ManyToOne
	private Task task;
	private LocalDate occuredDate;
	@ManyToOne
	private TaskStatus sourceStatus;
	@ManyToOne
	private TaskStatus targetStatus;

	public TaskStatus getSourceStatus() {
		return sourceStatus;
	}

	public void setSourceStatus(TaskStatus sourceStatus) {
		this.sourceStatus = sourceStatus;
	}

	public TaskStatus getTargetStatus() {
		return targetStatus;
	}

	public void setTargetStatus(TaskStatus targetStatus) {
		this.targetStatus = targetStatus;
	}

	public ChangeLog() {
		super();
	}

	public ChangeLog(Long id, Task task, LocalDate occuredDate) {
		super();
		this.id = id;
		this.task = task;
		this.occuredDate = occuredDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getOccuredDate() {
		return occuredDate;
	}

	public void setOccuredDate(LocalDate localDate) {
		this.occuredDate = localDate;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

}
