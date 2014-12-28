package com.huasheng.business.action;

public class UserAction {

	private String username;
	
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String execute(){
		System.out.println(username);
		System.out.println(password);
		return "success";
	}
}
