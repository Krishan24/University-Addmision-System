package com.cg.UniversityAdmissionSystem.service;

import java.util.List;

import com.cg.UniversityAdmissionSystem.bean.ApplicationBean;
import com.cg.UniversityAdmissionSystem.bean.ProgramScheduledBean;

public class ApplicantServiceImpl implements IApplicanttService{

	public List<ProgramScheduledBean> showProgramScheduled() {
		// TODO Auto-generated method stub
		return null;
	}

	public int addDetail(ApplicationBean ab) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ApplicationBean showStatus(int applicationId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static boolean firstNameValidation(String fname)
	{
		String pattern = "[A-Z][A-Za-z]{3,20}";
		if(fname.matches(pattern))
		{
			return true;
		}
		else
			return false;
	}
	
	public static boolean lastNameValidation(String lastName)
	{
		String pattern = "[A-Z][A-Za-z]{4,20}";
		if(lastName.matches(pattern))
		{
			return true;
		}
		else
			return false;
	}
	
	public static boolean dateOfBirthValidation(String dateOfBirth)
	{
		String pattern = "[0-3][0-9]/[a-zA-Z]{3}/[0-9]{4}";
		if(dateOfBirth.matches(pattern))
		{
			return true;
		}
		else
			return false;

	}
	
	public static boolean fatherNameValidation(String fatherName)
	{
		String pattern = "[A-Za-z]{4,30}";
		if(fatherName.matches(pattern))
		{
			return true;
		}
		else
			return false;
	}
	
	
	public static boolean emailValidation(String email)
	{
		String pattern = "[A-Za-z]{4,20}[@]{1}[gmail]{5}[.com]{4}";
		if(email.matches(pattern))
		{
			return true;
		}
		else
			return false;
	}
	
	public static boolean mobileNumberValidation(String mobileNumber)
	{
		String pattern = "^\\+(?:[0-9] ?) {6,14}[0-9]$";
		if(mobileNumber.matches(pattern))
		{
			return true;
		}
		else
			return false;
	}
	
	
	
	
	


}
