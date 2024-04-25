package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Project {
	@Id
	private int projectId;
	private String projectName;
	private String techStack;

	@ManyToOne
	private Employee employee;

}
