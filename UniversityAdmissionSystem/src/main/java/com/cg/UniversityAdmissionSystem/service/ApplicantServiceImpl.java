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
	
	public static boolean fullNameValidation(String fname)
	{
		String pattern = "[A-Z][A-Za-z ]{2,19}";
		if(fname.matches(pattern))
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
	
	public static boolean highestqualification(String hq)
	{
		String pattern = "[0-9A-Za-z .]{1,10}";
		if(hq.matches(pattern))
		{
			return true;
		}
		else
			return false;
	
	}
	
	
	public static boolean goalsValidation(String goals)
	{
		String pattern = "[A-Z][A-Za-z ]{2,19}";
		if(goals.matches(pattern))
		{
			return true;
		}
		else
			return false;
	
	}
	
}
	
	
	
	
	
	



