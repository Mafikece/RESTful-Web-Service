package com.mafik.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mafik.main.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	@Query("SELECT e FROM User e WHERE e.uName = :uName and e.password= :password")
	User findByUser(String uName,String password);
	
	@Query("SELECT e FROM User e WHERE e.uName = :to")
	User findByTo(String to);
	

	
}
