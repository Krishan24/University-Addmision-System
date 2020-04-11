package com.cg.UniversityAdmissionSystem.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.UniversityAdmissionSystem.bean.ApplicationBean;

public interface IMacService {

		public List<Integer> getApplicantId();
		public List<String> getScheduleId();
		public List<ApplicationBean> getApplicantOnScheduledId(String scheduledProgramId);
		public List<ApplicationBean> getApplicantAfterInterviewOnId(String scheduledProgramId);
		public String updateApplicantStatus(int applicationId, String status);
		public void updateApplicantDateOfInterview(int applicationId, LocalDate dateOfInterview);
		
}
