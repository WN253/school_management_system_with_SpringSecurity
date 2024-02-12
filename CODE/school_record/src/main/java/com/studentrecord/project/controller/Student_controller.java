package com.studentrecord.project.controller;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.studentrecord.project.model.Student_model;
import com.studentrecord.project.model.Teacher_model;
import com.studentrecord.project.service.Student_service;

import javax.validation.Valid;



@RestController
@RequestMapping("School-reg/")
public class Student_controller {

	 	@Autowired
	    private Student_service service;
		 	
	 	//TEACHER
	 	//TEACHER
	 	//TEACHER
	 	
	 	//SAVE TEACHER
	 	@PreAuthorize("hasRole('ADMIN')")
	 	@PostMapping("/teacher/save")
	    public String addTeacher(@Valid @RequestBody Teacher_model Teacher) {
	 		service.saveRoles(Teacher);
	 		service.saveTeacher(Teacher);
	        return "Teacher Saved Successfully";
	        
	    }
	 	
	 	//GET ALL TEACHER
	 	@PreAuthorize("hasRole('ADMIN')")
	    @GetMapping("/teacher/get")
	    public Iterable<Teacher_model> findAllTeacher() {
	        return service.getTeacher();
	    }


	  //GET ONE TEACHER
	    @PreAuthorize("authentication.name == #username or hasAnyRole('ADMIN')")
	    @GetMapping("/teacher/get/{username}")
	    public Optional<Teacher_model> getTeacherUsername(@PathVariable String username) {
	    		return service.getTeacherUsername(username);
	    		
	    }
	    
	    //UPDATE ONE TEACHER
	    @PreAuthorize("authentication.name == #username or hasRole('ADMIN')")
	    @PutMapping("/teacher/update/{username}")
	    public String update(@PathVariable String username,@RequestBody Teacher_model Tdata) {

	    		//UPDATE TO ROLE DATABASE
		        service.UpdateTeacherRole(username,Tdata);
		        //UPDATE TO TEACHER DATABASE AND RETURN
		        return service.UpdateTeacher(username,Tdata);	    	
	    }
	    
	    //DELETE ONE TEACHER
	    @PreAuthorize("hasRole('ADMIN')")
	    @DeleteMapping("/teacher/delete/{username}")
	    public String deleteTeacher(@PathVariable String username) {
	    	 Optional<Teacher_model> teacherData = service.getTeacherUsername(username);
		    		if (teacherData.isPresent()) {
//			        	 Teacher_model teacher = teacherData.get();
			        	 service.deleteTeacher(username); //delete in teacher database
			             service.deleteTeacherRole(username); //delete in role database
			             return "Teacher with "+username +" deleted successfully";
			         } else {
			             return "Teacher not found with username: " + username;
			         }

	    }
	 	
	 	//STUDENT
	 	//STUDENT
	 	//STUDENT
	 	
	    
	    //SAVE STUDENT
	    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
	 	@PostMapping("/student/save")
	    public String addStudent(@Valid @RequestBody Student_model Student) {
	 		service.saveStudentRoles(Student);
	 		service.saveStudent(Student);
	        return "Student Saved Successfully";
	        
	    }
	    
	    //GET ALL STUDENT
	    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
	    @GetMapping("/student/get")
	    public Iterable<Student_model> findAllStudent() {
	        return service.getStudent();
	    }
	    
	    //GET ONE STUDENT
	    @PreAuthorize("authentication.name == #username or hasAnyRole('ADMIN', 'TEACHER')")
	    @GetMapping("/student/get/{username}")
	    public Optional<Student_model> getOneStudent(@PathVariable String username) {
	    		return service.getStudentUsername(username);
	        
	    }
	    
	    //UPDATE ONE STUDENT
	    @PreAuthorize("authentication.name == #username or hasAnyRole('ADMIN', 'TEACHER')")
	    @PutMapping("/student/update/{username}")
	    public String update(@PathVariable String username,@RequestBody Student_model Tdata) {

	        //UPDATE TO ROLE DATABASE
	        service.UpdateStudentRole(username,Tdata);
	        //UPDATE TO STUDENT DATABASE AND RETURN
	        return service.UpdateStudent(username,Tdata);
	    	
	    }
	    
	    //DELETE ONE STUDENT
	    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
	    @DeleteMapping("/student/delete/{username}")
	    public String deleteStudent(@PathVariable String username) {
	    	 Optional<Student_model> StudentData = service.getStudentUsername(username);

	         if (StudentData.isPresent()) {
	        	 service.deleteStudent(username); //delete STUDENT in database
	             service.deleteStudentRole(username); //delete STUDENT in role database
	             return "Student with "+username +" deleted successfully";
	         } else {
	             return "Student not found with username: " + username;
	         }
	    	
	    }
	    
}

	 	