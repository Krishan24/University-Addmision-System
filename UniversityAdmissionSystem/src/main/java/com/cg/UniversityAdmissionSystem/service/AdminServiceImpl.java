package com.cg.UniversityAdmissionSystem.service;

import java.util.List;

import com.cg.UniversityAdmissionSystem.bean.ApplicationBean;
import com.cg.UniversityAdmissionSystem.bean.ProgramOfferedBean;
import com.cg.UniversityAdmissionSystem.bean.ProgramScheduledBean;

public class AdminServiceImpl implements IAdminService {

	public void addProgramOffered(ProgramOfferedBean pOffered) {
		// TODO Auto-generated method stub
		
	}

	public boolean deleteProgramOffered(String programName) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteProgramScheduled(String programId) {
		// TODO Auto-generated method stub
		return false;
	}

	public int addProgramScheduled(ProgramScheduledBean pScheduled) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<ProgramScheduledBean> getAllDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getAllProgramName() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getAllScheduleNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ApplicationBean> getApplicantsByStatusByScheduledProgramId(String status, String pScheduledId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ApplicationBean> getApplicantsByScheduledProgramId(String pScheduledId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ApplicationBean> getAllConfirmedApplicants() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ProgramOfferedBean> getOfferedProgram() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ProgramScheduledBean> getScheduledProgListForProg(String prog) {
		// TODO Auto-generated method stub
		return null;
	}

	public static boolean validateDate(String date) {
		String pattern = "[0-9]{2}[/]{1}[0-9]{2}[/]{1}[0-9]{4}";
		if(date.matches(pattern))
		{
			return true;
		}
		else
			return false;
	}
	
}
