package com.studentrecord.project.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.studentrecord.project.model.Student_model;
import com.studentrecord.project.model.Teacher_model;
import com.studentrecord.project.model.User;
import com.studentrecord.project.repository.Student_repository;
import com.studentrecord.project.repository.Teacher_repository;
import com.studentrecord.project.repository.UserRepository;


@Service
public class Student_service {
	
	@Autowired
    private Student_repository Srepository;
	
	@Autowired
    private Teacher_repository Trepository;
	
	@Autowired
    private UserRepository Rrepository;
	
	@Autowired     
 	private PasswordEncoder passwordEncoder;
	
	//TEACHER
	//TEACHER
	//TEACHER
	
	//SAVE/UPDATE TEACHER TO TEACHER DATABASE
	public Teacher_model saveTeacher(Teacher_model Teacher) {
		Teacher.setPassword(passwordEncoder.encode(Teacher.getPassword()));
        return Trepository.save(Teacher);
    }
	
	//SAVE TEACHER TO ROLE DATABASE
	public User saveRoles(Teacher_model Teacher) {
		User Converted = new User();
		Converted.setUsername(Teacher.getUsername());
		Converted.setPassword(passwordEncoder.encode(Teacher.getPassword()));
		Converted.setRoles("ROLE_TEACHER");
		Rrepository.save(Converted);
		return null;
    }
	
	//UPDATE TO TEACHER DATABASE
	public String UpdateTeacher(String username,Teacher_model TeacherProfile) {
		Optional<Teacher_model> TeacherData = Trepository.findByTUsername(username);
    	
    	
    	if (TeacherData.isPresent()) {
	    	Teacher_model Teacher=TeacherData.get();
	    	Teacher.setName(TeacherProfile.getName());
	    	Teacher.setAge(TeacherProfile.getAge());
	    	Teacher.setPassword(passwordEncoder.encode(TeacherProfile.getPassword()));
	    	Trepository.save(Teacher);
	    	return "Teacher of Username "+username+ "is updated";
    	}
    	else {
    		return "Teacher Not Updated/Not Found";
    	}
    }
	
	//UPDATE TO ROLE DATABASE
	public String UpdateTeacherRole(String username,Teacher_model TeacherRoleProfile) {

    		Optional<User> TeacherRoleData = Rrepository.findByUsername(username);
	        User TeacherRole=TeacherRoleData.get();
	        TeacherRole.setPassword(passwordEncoder.encode(TeacherRoleProfile.getPassword()));
	    	Rrepository.save(TeacherRole);
	    	return null;
    	}
	
	//GET ALL TEACHER LIST
    public Iterable<Teacher_model> getTeacher() {
        return Trepository.findAll();
    }
	
    //Find Teacher by username in Teacher Database
    public Optional<Teacher_model> getTeacherUsername(String username) {
        return Trepository.findByTUsername(username);
    }
    
    //Find Teacher by username in Role Database
    public Optional<User> getTeacherByUsername(String username) {
        return Rrepository.findByUsername(username);
    }
    
    //Delete Teacher by username in Teacher Database
    public String deleteTeacher(String username) {
    	Trepository.deleteByTUsername(username);    	
        return "Deleted Teacher " + username;
    }
    
    //Delete Teacher by username in Role Database
    public String deleteTeacherRole(String username) {
    	Rrepository.deleteByUsername(username);    	
        return "Deleted Teacher in Role " + username;
    }

    
	//STUDENT
	//STUDENT
	//STUDENT
    
	  //SAVE/UPDATE STUDENT TO TEACHER DATABASE
	  	public Student_model saveStudent(Student_model Student) {
	  		Student.setPassword(passwordEncoder.encode(Student.getPassword()));
	          return Srepository.save(Student);
	      }
	  	
	  	//SAVE STUDENT TO ROLE DATABASE
	  	public User saveStudentRoles(Student_model Student) {
	  		User Converted = new User();
	  		Converted.setUsername(Student.getUsername());
	  		Converted.setPassword(passwordEncoder.encode(Student.getPassword()));
	  		Converted.setRoles("ROLE_USER");
	  		Rrepository.save(Converted);
	  		return null;
	      }
	  	
	  //UPDATE TO STUDENT DATABASE
	  	public String UpdateStudent(String username,Student_model StudentProfile) {
	  		Optional<Student_model> StudentData = Srepository.findBySUsername(username);
	      	
	      	
	      	if (StudentData.isPresent()) {
	      		Student_model Student=StudentData.get();
//	  	    	Student.setName(StudentProfile.getName());
//	  	    	Student.setAge(StudentProfile.getAge());
//	  	    	Student.setClass_no(StudentProfile.getClass_no());
	  	    	Student.setPassword(passwordEncoder.encode(StudentProfile.getPassword()));
	  	    	Srepository.save(Student);
	  	    	return "Student of Username "+username+ " is updated";
	      	}
	      	else {
	      		return "Student Not Updated/Not Found";
	      	}
	      }
	  	
	  	//UPDATE STUDENT TO ROLE DATABASE
	  	public String UpdateStudentRole(String username,Student_model StudentRoleProfile) {
	
	      		Optional<User> StudentRoleData = Rrepository.findByUsername(username);
	  	        User StudentRole=StudentRoleData.get();
	  	        StudentRole.setPassword(passwordEncoder.encode(StudentRoleProfile.getPassword()));
	  	    	Rrepository.save(StudentRole);
	  	    	return null;
	      	}
    
	  	//GET ALL STUDENT LIST
	    public Iterable<Student_model> getStudent() {
	        return Srepository.findAll();
	    }
	    
	    //Find Student by username in Teacher Database
	    public Optional<Student_model> getStudentUsername(String username) {
	        return Srepository.findBySUsername(username);
	    }
	    
	    //Find Student by username in Role Database
	    public Optional<User> getStudentByUsername(String username) {
	        return Rrepository.findByUsername(username);
	    }
	    
	    //Delete Student by username in Teacher Database
	    public String deleteStudent(String username) {
	    	Srepository.deleteBySUsername(username);    	
	        return "Deleted Student " + username;
	    }
	    
	    //Delete Student by username in Role Database
	    public String deleteStudentRole(String username) {
	    	Rrepository.deleteByUsername(username);    	
	        return "Deleted Student in Role " + username;
	    }
    

}
