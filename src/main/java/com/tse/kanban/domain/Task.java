package com.tse.kanban.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
public class Task {

	private @Id @GeneratedValue Long id;
	private String title;
	private Integer nbHoursForecast;
	private Integer nbHoursReal;
	private LocalDate created;
	
	@ManyToOne
	private TaskType type;
	
	@ManyToOne
	private TaskStatus status;
	
	@ManyToMany(mappedBy="tasks", fetch = FetchType.EAGER)
	private Set<Developer> developers = new HashSet<Developer>();
	
	@OneToMany(mappedBy="task", fetch = FetchType.EAGER, cascade={CascadeType.ALL}, orphanRemoval=true)
	private Set<ChangeLog> changeLogs = new HashSet<ChangeLog>();
	
	public void addDeveloper(Developer developer)
	{
		developer.getTasks().add(this);	
		this.developers.add(developer);
	}
	
	public Long getId() {
		return id;
	}

	public Set<ChangeLog> getChangeLogs() {
		return changeLogs;
	}

	public void setChangeLogs(Set<ChangeLog> changeLogs) {
		this.changeLogs = changeLogs;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getNbHoursForecast() {
		return nbHoursForecast;
	}

	public void setNbHoursForecast(Integer nbHoursForecast) {
		this.nbHoursForecast = nbHoursForecast;
	}

	public Integer getNbHoursReal() {
		return nbHoursReal;
	}

	public void setNbHoursReal(Integer nbHoursReal) {
		this.nbHoursReal = nbHoursReal;
	}

	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}

	public TaskType getType() {
		return type;
	}

	public void setType(TaskType type) {
		this.type = type;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public Set<Developer> getDevelopers() {
		return developers;
	}

	public void setDevelopers(Set<Developer> developers) {
		this.developers = developers;
	}

	public Task(Long id, String title, int nbHoursForecast, int nbHoursReal, LocalDate created) {
		super();
		this.id = id;
		this.title = title;
		this.nbHoursForecast = nbHoursForecast;
		this.nbHoursReal = nbHoursReal;
		this.created = created;
	}
	public Task() {
		super();
	}
	
	public void addChangeLog(ChangeLog changeLog) {
		changeLog.setTask(this);
		this.changeLogs.add(changeLog);
	}
	
	public void clearChangeLogs() {
		for(ChangeLog changeLog : this.changeLogs)
		{
			changeLog.setTask(null);
		}
	}
	
}
