package com.cg.UniversityAdmissionSystem.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.UniversityAdmissionSystem.bean.ApplicationBean;
import com.cg.UniversityAdmissionSystem.bean.ParticipantBean;
import com.cg.UniversityAdmissionSystem.bean.ProgramOfferedBean;
import com.cg.UniversityAdmissionSystem.bean.ProgramScheduledBean;
import com.cg.UniversityAdmissionSystem.exception.InvalidProgramException;
import com.cg.UniversityAdmissionSystem.exception.ProgramAlreadyExistsException;

public interface IAdminDao 
{
	
//	public void addProgramOffered(ProgramOfferedBean pOffered);
//	public boolean deleteProgramOffered(String programName);
//	public boolean deleteProgramScheduled(String programId);
//	public int addProgramScheduled(ProgramScheduledBean pScheduled);
//	
//	public List<ProgramScheduledBean> getAllDetails();
//	
//	public List<String> getAllProgramName();
//	public List<String> getAllScheduleNames();
//	public List<ParticipantBean> getApplicantsByScheduledProgramId(String pScheduledId) ;
//	public List<ParticipantBean> getAllConfirmedApplicants();
//	public List<ProgramOfferedBean> getOfferedProgram();
//	public List<ProgramScheduledBean> getScheduledProgListForProg(String prog) ;
	ProgramOfferedBean readProgramsOffered(String programName) throws InvalidProgramException;

	boolean createProgramsOffered(ProgramOfferedBean programsOffered) throws ProgramAlreadyExistsException;

	boolean updateProgramsOffered(String programName, ProgramOfferedBean programsOffered) throws InvalidProgramException;

	boolean deleteProgramsOffered(String programName) throws InvalidProgramException;

	ArrayList<ProgramOfferedBean> reportAllProgramOffered();
	
	ProgramScheduledBean readProgramsScheduled(String scheduledProgramId) throws InvalidProgramException;
	
	ArrayList<ProgramScheduledBean> reportAllScheduledProgram();

	boolean createProgramsScheduled(ProgramScheduledBean scheduled) throws ProgramAlreadyExistsException;

	boolean updatePogramsScheduled(String scheduledProgramId, ProgramScheduledBean scheduled) throws InvalidProgramException;

	boolean deleteProgramsScheduled(String scheduledProgramId)  throws InvalidProgramException;


}
