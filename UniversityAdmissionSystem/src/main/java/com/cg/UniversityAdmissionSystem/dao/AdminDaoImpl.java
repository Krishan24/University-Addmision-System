package com.cg.UniversityAdmissionSystem.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.cg.UniversityAdmissionSystem.bean.ApplicationBean;
import com.cg.UniversityAdmissionSystem.bean.ParticipantBean;
import com.cg.UniversityAdmissionSystem.bean.ProgramOfferedBean;
import com.cg.UniversityAdmissionSystem.bean.ProgramScheduledBean;

public class AdminDaoImpl implements IAdminDao{
	ParticipantBean pb=new ParticipantBean();

	List<ProgramOfferedBean> proOffList=new ArrayList<ProgramOfferedBean>();
	List<ProgramScheduledBean> proSchList=new ArrayList<ProgramScheduledBean>();
	List<String> ProNameList = new ArrayList<String>();
	List<String> ShNameList = new ArrayList<String>();
	List<ParticipantBean> participantList=new ArrayList<ParticipantBean>();
	
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
		Iterator iterator = proOffList.iterator();
		while(iterator.hasNext()){
			  ProNameList.add(((ProgramOfferedBean) iterator.next()).getProgramName());
			}
		return ProNameList;
	}

	public List<String> getAllScheduleNames() {
		Iterator iterator = proSchList.iterator();
		while(iterator.hasNext()){
			  ProNameList.add(((ProgramOfferedBean) iterator.next()).getProgramName());
			}
		return ShNameList;
		
	}

	public List<ParticipantBean> getApplicantsByScheduledProgramId(String pScheduledId) 
	{
		
		List<ParticipantBean> result=participantList.stream().filter((p) -> {
			return p.getScheduledProgramId().equalsIgnoreCase(pScheduledId);
		}).collect(Collectors.toList());
		return new ArrayList<ParticipantBean>(result);
	
			
	}

	public List<ParticipantBean> getAllConfirmedApplicants() {
		return participantList;
		
	}

	public List<ProgramOfferedBean> getOfferedProgram() {
		
		return proOffList;
	}

	public List<ProgramScheduledBean> getScheduledProgListForProg(String prog) {
		List<ProgramScheduledBean> result=proSchList.stream().filter((p) -> {
			return p.getScheduledProgramId().equalsIgnoreCase(prog);
		}).collect(Collectors.toList());
		return new ArrayList<ProgramScheduledBean>(result);
	}

}
