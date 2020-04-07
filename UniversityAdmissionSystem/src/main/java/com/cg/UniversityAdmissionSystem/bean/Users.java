package com.cg.UniversityAdmissionSystem.bean;

public class Users {
	
	private String loginId;
	private String password;
	private String role;
	
	
	
	public Users() {
		
		this.loginId = loginId;
		this.password = password;
		this.role = role;
	}



	public String getLoginId() {
		return loginId;
	}



	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	@Override
	public String toString() {
		return "Users [loginId=" + loginId + ", password=" + password + ", role=" + role + "]";
	}
	
	
	
	
	
	

}
