package com.mafik.main.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mafik.main.model.Email;

public interface EmailRepo extends JpaRepository<Email, Integer> {

	@Query("SELECT e FROM Email e WHERE e.to = :to" )
	List<Email> findByInbox(String to);
	
	@Query("SELECT e FROM Email e WHERE e.from = :from" )
	List<Email> checkSentBox(String from);
	

}
