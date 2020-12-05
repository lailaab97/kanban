package com.tse.kanban.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Developer {

	private @Id @GeneratedValue Long id;
	private String firstname;
	private String lastname;
	private String password;
	private String email;
	private LocalDate startContract;
	
	@ManyToMany
	private Set<Task> tasks = new HashSet<Task>();
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public LocalDate getStartContract() {
		return startContract;
	}


	public void setStartContract(LocalDate localDate) {
		this.startContract = localDate;
	}


	public Set<Task> getTasks() {
		return tasks;
	}


	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}


	
	public Developer(Long id, String firstname, String lastname, String password, String email, LocalDate startContract,
			Set<Task> tasks) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.email = email;
		this.startContract = startContract;
		this.tasks = tasks;
	}


	public Developer() {
		super();
	}
	
}
