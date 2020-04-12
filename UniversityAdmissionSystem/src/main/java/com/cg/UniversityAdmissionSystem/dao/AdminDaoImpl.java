package com.cg.UniversityAdmissionSystem.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.cg.UniversityAdmissionSystem.bean.ApplicationBean;
import com.cg.UniversityAdmissionSystem.bean.ProgramOfferedBean;
import com.cg.UniversityAdmissionSystem.bean.ProgramScheduledBean;

public class AdminDaoImpl implements IAdminDao{

	List<ProgramOfferedBean> proOffList=new ArrayList<ProgramOfferedBean>();
	List<ProgramScheduledBean> proSchList=new ArrayList<ProgramScheduledBean>();
	List<String> ProNameList = new ArrayList<String>();
	
	public void addProgramOffered(ProgramOfferedBean pOffered) {
		proOffList.add(pOffered);
		
	}

	public boolean deleteProgramOffered(String programName) {
		proOffList.remove(programName);
		return true;
	}

	public boolean deleteProgramScheduled(String programId) {
		proSchList.remove(programId);
		return true;
	}

	public int addProgramScheduled(ProgramScheduledBean pScheduled) {
		proSchList.add(pScheduled);
		return 1;
	}

	public List<ProgramScheduledBean> getAllDetails() {
		
		return proSchList;
	}

	public List<String> getAllProgramName() {
		Iterator iterator = proSchList.iterator();
		while(iterator.hasNext()){
			  ProNameList.add(((ProgramOfferedBean) iterator.next()).getProgramName());
			}
		return ProNameList;
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

}
