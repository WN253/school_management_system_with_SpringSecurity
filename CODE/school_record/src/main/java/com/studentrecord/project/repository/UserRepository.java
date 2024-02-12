package com.studentrecord.project.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.studentrecord.project.model.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	Optional<User> findByUsername(String username);

//	@Query("SELECT s FROM User s WHERE s.username =:username")
//	Optional<User> findByusername(@Param("username") String username);
	
	
	@Modifying
	@Transactional
	@Query("DELETE FROM User s WHERE s.username = :username")
	void deleteByUsername(@Param("username") String username);
}
