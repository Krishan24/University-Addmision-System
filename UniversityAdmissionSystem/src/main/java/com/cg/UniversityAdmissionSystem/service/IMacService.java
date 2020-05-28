package com.cg.UniversityAdmissionSystem.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cg.UniversityAdmissionSystem.bean.ApplicationBean;
import com.cg.UniversityAdmissionSystem.bean.ParticipantBean;
import com.cg.UniversityAdmissionSystem.exception.NoSuchApplication;

public interface IMacService {


ArrayList<ApplicationBean> applicationsOfProgram(String scheduledProgramId);

	boolean updateApplicationStatus(String applicationId, int status) throws NoSuchApplication;

	boolean scheduleInterview(String applicationId, LocalDate date) throws NoSuchApplication;

	ArrayList<ParticipantBean> getParticipants(String scheduledProgramId);
		
}
