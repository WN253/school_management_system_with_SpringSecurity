package com.studentrecord.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Student_Details")
public class  Student_model {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "Admission Number cannot be empty ")
	private String admission_no;
	
	@NotEmpty(message = "Name cannot be empty ")
	private String name;
	
	@NotEmpty(message = "Username cannot be empty ")
	private String username;
	
	@NotEmpty(message = "password cannot be empty ")
	private String Password;
	
	@NotEmpty(message = "Class Number cannot be empty ")
	private String class_no;
	
	@NotEmpty(message = "Age cannot be empty ")
	private String age;

	public Student_model() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdmission_no() {
		return admission_no;
	}

	public void setAdmission_no(String admission_no) {
		this.admission_no = admission_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getClass_no() {
		return class_no;
	}

	public void setClass_no(String class_no) {
		this.class_no = class_no;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student_model [id=" + id + ", admission_no=" + admission_no + ", name=" + name + ", username="
				+ username + ", Password=" + Password + ", class_no=" + class_no + ", age=" + age + "]";
	}

	public Student_model(int id, @NotEmpty(message = "Admission Number cannot be empty ") String admission_no,
			@NotEmpty(message = "Name cannot be empty ") String name,
			@NotEmpty(message = "Username cannot be empty ") String username,
			@NotEmpty(message = "password cannot be empty ") String password,
			@NotEmpty(message = "Class Number cannot be empty ") String class_no,
			@NotEmpty(message = "Age cannot be empty ") String age) {
		super();
		this.id = id;
		this.admission_no = admission_no;
		this.name = name;
		this.username = username;
		Password = password;
		this.class_no = class_no;
		this.age = age;
	}
	
	
	
}
