package com.cg.UniversityAdmissionSystem.service;

import java.util.ArrayList;
import java.util.List;

import com.cg.UniversityAdmissionSystem.bean.ApplicationBean;
import com.cg.UniversityAdmissionSystem.bean.ProgramScheduledBean;
import com.cg.UniversityAdmissionSystem.exception.ApplicationAlreadyExistsException;
import com.cg.UniversityAdmissionSystem.exception.InvalidProgramException;
import com.cg.UniversityAdmissionSystem.exception.NoProgramsAvailableException;
import com.cg.UniversityAdmissionSystem.exception.NoSuchApplication;


public interface IApplicanttService  
{


	ArrayList<ProgramScheduledBean> getScheduledProgramList() throws NoProgramsAvailableException;
	
	public int applyOnline(ApplicationBean ab) throws ApplicationAlreadyExistsException,InvalidProgramException ;
	
	public String applicationStatus(String ApplicationId) throws NoSuchApplication;
}
