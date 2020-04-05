package com.cg.UniversityAdmissionSystem.bean;

public class Administrator {
	
	private String UserName;
	private String Password;
	
	
	public Administrator(String UserName, String Password) {
	this.UserName=UserName;
	this.Password=Password;
	
}
	
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "Administrator [UserName=" + UserName + ", Password=" + Password + "]";
	}
	
	

}
