package com.exilant.mongorepo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	
	@Id
	private int id;
	private String name;
	private int age;
	private int salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name,int age,int salary) {
		super();
		this.id = id;
		this.name = name;
		this.age=age;
		this.salary=salary;
	}

}
