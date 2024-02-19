package com.mafik.main.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mafik.main.model.Email;
import com.mafik.main.model.User;
import com.mafik.main.repo.UserRepo;
import com.mafik.main.response.EmailResponse;
import com.mafik.main.response.UserResponse;
import com.mafik.main.service.MyService;

@RestController
public class MainController {
	@Autowired
	private MyService service;
	@Autowired
	private UserResponse uresponse;
	@Autowired
	private EmailResponse er;

	@GetMapping("/registration")
	public ResponseEntity<UserResponse> registration(@RequestBody User user) {
		User register = service.userRegistration(user);
		if (register != null) {
			uresponse.setError(false);
			uresponse.setMsg("User registration successful");
			uresponse.setUser(Arrays.asList(register));
			return new ResponseEntity<UserResponse>(uresponse, HttpStatus.OK);

		} else {
			uresponse.setError(true);
			uresponse.setMsg("Failed to register");
			uresponse.setUser(null);
			return new ResponseEntity<UserResponse>(uresponse, HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/login")
	public ResponseEntity<UserResponse> loginUser(@RequestBody User user){
		User user1=service.loginCheck(user.getuName(),user.getPassword());
		if (user1 != null) {
			uresponse.setError(false);
			uresponse.setMsg("User login successful");
			uresponse.setUser(Arrays.asList(user1));
			return new ResponseEntity<UserResponse>(uresponse, HttpStatus.OK);

		} else {
			uresponse.setError(true);
			uresponse.setMsg("Failed to login");
			uresponse.setUser(null);
			return new ResponseEntity<UserResponse>(uresponse, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/sendEMail")
	
	public ResponseEntity<UserResponse> sendEMail(@RequestBody Email email){
		User email2 =service.sendEmail(email.getTo());
			
		if(email2!=null) {
			service.save(email);
			uresponse.setError(false);
			uresponse.setMsg("Email sent successfully");
//			uresponse.setUser(Arrays.asList(email2));
			return new ResponseEntity<UserResponse>(uresponse,HttpStatus.OK);
		
		
		}else {
			uresponse.setError(true);
			uresponse.setMsg("Email sent failed");
			uresponse.setUser(null);
			return new ResponseEntity<UserResponse>(uresponse,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/inbox")
	public ResponseEntity<EmailResponse> checkInbox(@RequestBody Email email){
		List<Email> inbox = service.checkInbox(email.getTo());
		
			if(inbox!=null) {
			er.setError(false);
			er.setMsg("Mails in inbox");
			er.setEmail(inbox);
			return new ResponseEntity<EmailResponse>(er,HttpStatus.OK);
		
		
		}else {
			er.setError(true);
			er.setMsg("Reciver not found");
			er.setEmail(null);
			return new ResponseEntity<EmailResponse>(er,HttpStatus.NOT_FOUND);
		}
	
	}
	
	@GetMapping("/sentBox")
	public ResponseEntity<EmailResponse> checkSentBox(@RequestBody Email email){
		List<Email> sentBox = service.checkSentBox(email.getFrom());
		
			if(sentBox!=null) {
			er.setError(false);
			er.setMsg("Email in sentBox");
			er.setEmail(sentBox);
			return new ResponseEntity<EmailResponse>(er,HttpStatus.OK);
		
		
		}else {
			er.setError(true);
			er.setMsg("Not in sentBox");
			er.setEmail(null);
			return new ResponseEntity<EmailResponse>(er,HttpStatus.NOT_FOUND);
		}
}}
