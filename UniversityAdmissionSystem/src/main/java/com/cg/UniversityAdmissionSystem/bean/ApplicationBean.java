
package com.cg.UniversityAdmissionSystem.bean;

import java.util.Date;

public class ApplicationBean 
{
	private String FName;
	private String LName;
	private Date DOB;
	private String FatherName;
	private String Email;
	private String Goals;
	private double SSC;
	private double HSC;
	
	
	
public ApplicationBean(String FName, String LName, Date DOB, String FatherName, String Email, long MobNO, double SSC, double HSC) {
	
	this.FName = FName;
	this.LName = LName;
	this.DOB = DOB;
	this.FatherName = FatherName;
	this.Email = Email;
	this.Goals = Goals;
	this.SSC = SSC;
	this.HSC = HSC;
	
	

}


	public String getFName() {
		return FName;
	}
	public void setFName(String fName) {
		FName = fName;
	}
	public String getLName() {
		return LName;
	}
	public void setLName(String lName) {
		LName = lName;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public String getFatherName() {
		return FatherName;
	}
	public void setFatherName(String fatherName) {
		FatherName = fatherName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getGoals() {
		return Goals;
	}
	public void setGoals(String goals) {
		Goals = goals;
	}
	public double getSSC() {
		return SSC;
	}
	public void setSSC(double sSC) {
		SSC = sSC;
	}
	public double getHSC() {
		return HSC;
	}
	public void setHSC(double hSC) {
		HSC = hSC;
	}


	@Override
	public String toString() {
		return "ApplicationBean [FName=" + FName + ", LName=" + LName + ", DOB=" + DOB + ", FatherName=" + FatherName
				+ ", Email=" + Email + ", Goals=" + Goals + ", SSC=" + SSC + ", HSC=" + HSC + "]";
	}
	
	
	
	
	
}
	
	
	
	
	


