package com.cg.UniversityAdmissionSystem.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.UniversityAdmissionSystem.bean.ApplicationBean;

public class MacServiceImpl implements IMacService {

   public List<Integer> getApplicantId() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getScheduleId() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ApplicationBean> getApplicantOnScheduledId(String scheduledProgramId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ApplicationBean> getApplicantAfterInterviewOnId(String scheduledProgramId) {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateApplicantStatus(int applicationId, String status) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateApplicantDateOfInterview(int applicationId, LocalDate dateOfInterview) {
		// TODO Auto-generated method stub
		
	}
	
	public static boolean validateScheduledId(String id)
	{
		String pattern = "[0-9]{1,5}";
		if(id.matches(pattern))
		{
			return true;
		}
		else
		 return false;
	}

}
