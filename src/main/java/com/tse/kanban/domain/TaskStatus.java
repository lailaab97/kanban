package com.tse.kanban.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class TaskStatus {

	private @Id @GeneratedValue Long id;
	private String Label;
	public TaskStatus(Long id, String label) {
		super();
		this.id = id;
		Label = label;
	}
	public TaskStatus() {
		super();
	}
	
	
	
	
}
