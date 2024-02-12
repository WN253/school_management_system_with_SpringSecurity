package com.studentrecord.project.repository;

import com.studentrecord.project.model.Teacher_model;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Teacher_repository extends JpaRepository<Teacher_model,Integer>{
	
//	Optional<Teacher_model> findBystaff_id(String staffId);
//	Optional<User> findByTUsername(String username);
	
	@Query("SELECT t FROM Teacher_model t WHERE t.Username =:username")
	Optional<Teacher_model> findByTUsername(@Param("username") String username);
	
	@Modifying
	@Transactional
	@Query("DELETE FROM Teacher_model t WHERE t.Username = :username")
	void deleteByTUsername(@Param("username") String username);
//    void deleteByStaff_id(String staffId);
	
}
