package com.mafik.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mafik.main.model.Email;
import com.mafik.main.model.User;
import com.mafik.main.repo.EmailRepo;
import com.mafik.main.repo.UserRepo;

@Component
public class MyServiceImp implements MyService{
@Autowired
private UserRepo ur;
@Autowired
private EmailRepo er;
	
	public User userRegistration(User user) {
		return ur.save(user);
	}
	
	@Override
	public User loginCheck(String uName, String password) {
		User findByUser=ur.findByUser(uName,password);
		return findByUser;
	}

	@Override
	public User sendEmail(String to) {
		User user=ur.findByTo(to);
		return user;
	}

	@Override
	public void save(Email email) {
		er.save(email);
		
	}

	@Override
	public List<Email> checkInbox(String to) {
		List<Email> inbox = er.findByInbox(to);
		return inbox;
	}

	@Override
	public List<Email> checkSentBox(String from) {
		List<Email> sent = er.checkSentBox(from);
		return sent;
	}
	
}
