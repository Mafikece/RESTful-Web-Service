package com.mafik.main.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mafik.main.model.User;

@Component
public class UserResponse {
	private Boolean error;
	private String msg;
	private List<User> user;
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
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "UserResponse [error=" + error + ", msg=" + msg + ", user=" + user + "]";
	}
	
	
}
