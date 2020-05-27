package com.cg.UniversityAdmissionSystem.dao;

import java.util.ArrayList;

import com.cg.UniversityAdmissionSystem.bean.ApplicationBean;
import com.cg.UniversityAdmissionSystem.exception.ApplicationAlreadyExistsException;
import com.cg.UniversityAdmissionSystem.exception.NoSuchApplication;

public interface IApplicationDao {
	
	ApplicationBean readApplication(String applicationId) throws NoSuchApplication;
	
	ArrayList<ApplicationBean> getAll();
	
	ApplicationBean readApplicationByProgramId(String ProgramId) throws NoSuchApplication;
	
	boolean createApplication(ApplicationBean ab) throws ApplicationAlreadyExistsException;
	
	boolean updateApplication(String applicationId, ApplicationBean ab) throws NoSuchApplication;
	
	boolean deleteApplication(String applicationId) throws NoSuchApplication;
	
	

}
