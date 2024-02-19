package com.mafik.main.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mafik.main.model.Email;
import com.mafik.main.model.User;

@Component
public class EmailResponse {
	private Boolean error;
	private String msg;
	private List<Email> email;
	public Boolean getError() {
		return error;
	}
	public void setError(Boolean error) {
		this.error = error;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<Email> getEmail() {
		return email;
	}
	public void setEmail(List<Email> email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "EmailResponse [error=" + error + ", msg=" + msg + ", email=" + email + "]";
	}
}
