package com.cg.UniversityAdmissionSystem.dao;

import java.util.ArrayList;

import com.cg.UniversityAdmissionSystem.bean.ParticipantBean;
import com.cg.UniversityAdmissionSystem.exception.NoSuchParticipant;
import com.cg.UniversityAdmissionSystem.exception.ParticipantAlreadyExistsException;

public interface IParticipantDao {
	
	ParticipantBean readParticipant(String RollNo) throws NoSuchParticipant;
	
	boolean createParticipant(ParticipantBean pb) throws ParticipantAlreadyExistsException;
	
	boolean updateParticipant(String rollNo, ParticipantBean pb) throws NoSuchParticipant;
	
	boolean deleteParticipant(String rollNo) throws NoSuchParticipant;
	
	ArrayList<ParticipantBean> getAll();
		
	

}
