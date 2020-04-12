package com.cg.UniversityAdmissionSystem.service;

import java.util.List;

import com.cg.UniversityAdmissionSystem.bean.ApplicationBean;
import com.cg.UniversityAdmissionSystem.bean.ProgramOfferedBean;
import com.cg.UniversityAdmissionSystem.bean.ProgramScheduledBean;

public interface IAdminService {

	public void addProgramOffered(ProgramOfferedBean pOffered);
	public boolean deleteProgramOffered(String programName);
	public boolean deleteProgramScheduled(String programId);
	public int addProgramScheduled(ProgramScheduledBean pScheduled);
	
	public List<ProgramScheduledBean> getAllDetails();
	
	public List<String> getAllProgramName();
	public List<String> getAllScheduleNames();
	
	public List<ApplicationBean> getApplicantsByStatusByScheduledProgramId(String status,String pScheduledId);
	public List<ApplicationBean> getApplicantsByScheduledProgramId(String pScheduledId) ;
	public List<ApplicationBean> getAllConfirmedApplicants();
	public List<ProgramOfferedBean> getOfferedProgram();
	public List<ProgramScheduledBean> getScheduledProgListForProg(String prog) ;
	public boolean validateProgramDescription(String pDesc);
	public List<String> getAllScheduleId();
	public boolean validateLocation(String location);
	public boolean generateParticipants(List<ApplicationBean> confirmList);


}
