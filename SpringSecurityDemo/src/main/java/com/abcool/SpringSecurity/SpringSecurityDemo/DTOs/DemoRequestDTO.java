package com.abcool.SpringSecurity.SpringSecurityDemo.DTOs;

public class DemoRequestDTO {

	String userName;
	
	String password;
	
	String roles;

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getRoles() {
		return roles;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
	
}
