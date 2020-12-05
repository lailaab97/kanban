package com.tse.kanban.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class TaskType {

	private @Id @GeneratedValue Long id;
	
	private String label;
	public TaskType(Long id, String label) {
		super();
		this.id = id;
		this.label = label;
	}
	public TaskType() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
