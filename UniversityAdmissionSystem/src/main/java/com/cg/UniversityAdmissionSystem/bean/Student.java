
package com.cg.UniversityAdmissionSystem.bean;

import java.util.Date;

public class Student 
{
	private String FName;
	private String LName;
	private Date DOB;
	private String FatherName;
	private String Email;
	private long MobNO;
	private double SSC;
	private double HSC;
	
	
	
public Student(String FName, String LName, Date DOB, String FatherName, String Email, long MobNO, double SSC, double HSC) {
	
	this.FName = FName;
	this.LName = LName;
	this.DOB = DOB;
	this.FatherName = FatherName;
	this.Email = Email;
	this.MobNO = MobNO;
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
	public long getMobNO() {
		return MobNO;
	}
	public void setMobNO(long mobNO) {
		MobNO = mobNO;
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
		return "Student [FName=" + FName + ", LName=" + LName + ", DOB=" + DOB + ", FatherName=" + FatherName
				+ ", Email=" + Email + ", MobNO=" + MobNO + ", SSC=" + SSC + ", HSC=" + HSC + "]";
	}
	
}
	
	
	
	
	


