package com.studentrecord.project.repository;

import com.studentrecord.project.model.Student_model;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Student_repository extends JpaRepository<Student_model,Integer> {
	
	@Query("SELECT s FROM Student_model s WHERE s.username =:username")
	Optional<Student_model> findBySUsername(@Param("username") String username);
	
	@Modifying
	@Transactional
	@Query("DELETE FROM Student_model s WHERE s.username = :username")
	void deleteBySUsername(@Param("username") String username);
}
	

//public class Student_repository {
//
//	private ArrayList <Student_model> list = new ArrayList<Student_model>();
//	
//	int counter=0;
//	
//	//	SAVE
//	public Student_model save(Student_model S) {
//		Student_model Stud = new Student_model();
//		counter++;
//		Stud.setId(counter);		
//		Stud.setAdmission_no(S.getAdmission_no());
//		Stud.setName(S.getName());
//		Stud.setPassword(S.getPassword());
//		Stud.setAge(S.getAge());
//		Stud.setClass_no(S.getClass_no());
//        list.add(Stud);
//        return Stud;
//    }
//	
//	//	GET
//	public ArrayList<Student_model> getAllStudents() {
//        return list;
//        
//    }
//	
//	//	DELETE
//	public String delete(int id) {
//        for (int i = 0; i < list.size(); i++) {
//        	
//	        if (list.get(i).getId() == (id)) {
//	        	list.remove(i);
//	        	return "Student " +id+ " Removed";
//	        }
//        }
//		return "Student not Found";
//	}
//
//	//	UPDATE
//	 public Student_model update(Student_model Student) {
//		 	
//		 	int icount=0;
//	        for (int i = 0; i < list.size(); i++) {
//	            if (list.get(i).getId() == (Student.getId())) {
//	                icount = i;
//	                break;
//	            }
//	        }
//		 
//			
//	        Student_model Stud2 = new Student_model();
//	        Stud2.setId(Student.getId());
//			Stud2.setAdmission_no(Student.getAdmission_no());
//			Stud2.setName(Student.getName());
//			Stud2.setAge(Student.getAge());
//			Stud2.setClass_no(Student.getClass_no());
//			list.set(icount, Student);
//	        return Stud2;
//	    }
////	 GET SINGLE ID
//	 public Student_model findById(int id){
//	        for (int i = 0; i < list.size(); i++) {
//	            if (list.get(i).getId() == (id)) {
//	                return list.get(i);
//	            }
//	        }
//	        return null;
//	    }
//	 
//	 
////	 LOGIN CODE
//	 public String findByUsernameAndPassword(String name, String password) {
//	        for (Student_model user : list) {
//	            if (user.getName().equals(name) && user.getPassword().equals(password)) {
//	                return "Logged In";
//	            }
//	        }
//	        return "Login Failed";
//	    }
//	 
//}
//                                                                                                                                