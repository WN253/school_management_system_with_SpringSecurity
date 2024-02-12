package com.studentrecord.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Teacher_Details")
public class Teacher_model {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private	String Staff_id;
	private String Name;
	private String Username;
	private String Password;
	private String Age;
	
	public Teacher_model() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStaff_id() {
		return Staff_id;
	}

	public void setStaff_id(String staff_id) {
		Staff_id = staff_id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getAge() {
		return Age;
	}

	public void setAge(String age) {
		Age = age;
	}

	@Override
	public String toString() {
		return "Teacher_model [id=" + id + ", Staff_id=" + Staff_id + ", Name=" + Name + ", Username=" + Username
				+ ", Password=" + Password + ", Age=" + Age + "]";
	}

	public Teacher_model(int id, String staff_id, String name, String username, String password, String age) {
		super();
		this.id = id;
		Staff_id = staff_id;
		Name = name;
		Username = username;
		Password = password;
		Age = age;
	}
	
	
	
}
