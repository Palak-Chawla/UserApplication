package com.example.userapplication.model;

@Entity
public class User {
	@Id
	private Long id;
	private String name;
	private String grade;
	
	private Set<Role> roles;
	private User supervisor;
	private Set<User> team;
	
}
