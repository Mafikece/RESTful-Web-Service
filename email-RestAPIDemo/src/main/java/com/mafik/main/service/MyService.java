package com.mafik.main.service;

import java.util.List;

import com.mafik.main.model.Email;
import com.mafik.main.model.User;

public interface MyService {

	User userRegistration(User user);

	User loginCheck(String getuName, String password);

	User sendEmail(String to);

	void save(Email email);

	List<Email> checkInbox(String to);

	List<Email> checkSentBox(String from);
	
	

}
