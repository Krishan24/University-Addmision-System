package com.cg.UniversityAdmissionSystem.dao;

import java.time.LocalDate;
import java.util.List;

import com.cg.UniversityAdmissionSystem.bean.ApplicationBean;

public interface IMacDao 
{
	
	public List<String> getscheduleId();
	public List<Integer> getApplicantId();
	public List<ApplicationBean> getApplicantsOnSchduledId(String scheduledProgramId);
	public List<ApplicationBean> getApplicantsAfterInterviewOnId(String scheduledProgramId);
	public String updateApplicantStatus(int applicationId,String status);
	public void updateApplicantDateOfInterview(int applicationId, LocalDate dateOfInterview);
	
}
