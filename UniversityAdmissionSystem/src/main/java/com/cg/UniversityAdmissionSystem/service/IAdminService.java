package com.cg.UniversityAdmissionSystem.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cg.UniversityAdmissionSystem.bean.ApplicationBean;
import com.cg.UniversityAdmissionSystem.bean.ProgramOfferedBean;
import com.cg.UniversityAdmissionSystem.bean.ProgramScheduledBean;
import com.cg.UniversityAdmissionSystem.exception.InvalidDateException;
import com.cg.UniversityAdmissionSystem.exception.InvalidProgramException;
import com.cg.UniversityAdmissionSystem.exception.ProgramAlreadyExistsException;

public interface IAdminService {

	int addProgram(ProgramOfferedBean po) throws ProgramAlreadyExistsException;

	int updateOfferedProgram(ProgramOfferedBean po) throws InvalidProgramException;

	int removeProgram(String program) throws InvalidProgramException;

	ArrayList<ApplicationBean> applicationsByStatus(String status);

	ArrayList<ProgramScheduledBean> reportOfScheduledProgramsByDate(LocalDate s, LocalDate e);

	ArrayList<ProgramOfferedBean> offeredProgramsList();
	
	ArrayList<ProgramScheduledBean> scheduledProgramsList();

	boolean addScheduledProgram(ProgramScheduledBean ps)
			throws ProgramAlreadyExistsException, InvalidDateException, InvalidProgramException;
	
	
	
	
//	public void addProgramOffered(ProgramOfferedBean pOffered);
//	public boolean deleteProgramOffered(String programName);
//	public boolean deleteProgramScheduled(String programId);
//	public int addProgramScheduled(ProgramScheduledBean pScheduled);
//	
//	public List<ProgramScheduledBean> getAllDetails();
//	
//	public List<String> getAllProgramName();
//	public List<String> getAllScheduleNames();
//	
//	public List<ApplicationBean> getApplicantsByStatusByScheduledProgramId(String status,String pScheduledId);
//	public List<ApplicationBean> getApplicantsByScheduledProgramId(String pScheduledId) ;
//	public List<ApplicationBean> getAllConfirmedApplicants();
//	public List<ProgramOfferedBean> getOfferedProgram();
//	public List<ProgramScheduledBean> getScheduledProgListForProg(String prog) ;
//	public boolean validateProgramDescription(String pDesc);
//	public List<String> getAllScheduleId();
//	public boolean validateLocation(String location);
//	public boolean generateParticipants(List<ApplicationBean> confirmList);


}
