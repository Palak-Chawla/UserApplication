package com.example.demo.domain;

import java.util.List;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity	
public class User {
//	 id, name, grade,roles, supervisor,team
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String name;
	 private String grade;
	 
	 @OneToOne
	 private User supervisor;
	 
	 @OneToMany
	 List<User> team;
	 
	 @ManyToMany
	 List<Role> roles;

	public void setName(String name) {
		this.name = name;
		
	}
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}	 
}
