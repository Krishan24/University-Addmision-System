package com.cg.UniversityAdmissionSystem.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.cg.UniversityAdmissionSystem.bean.ParticipantBean;
import com.cg.UniversityAdmissionSystem.exception.NoSuchParticipant;
import com.cg.UniversityAdmissionSystem.exception.ParticipantAlreadyExistsException;
import com.cg.UniversityAdmissionSystem.exception.ProgramAlreadyExistsException;


public class ParticipantDaoImpl implements IParticipantDao{
	
	private static HashMap<String, ParticipantBean> participants = new HashMap<String, ParticipantBean>();
	
	
	@Override
	public ParticipantBean readParticipant(String rollNo) throws NoSuchParticipant{
		ParticipantBean pb = participants.get(rollNo);
		if(pb !=null) {
			System.out.println("Participant with roll no: " + rollNo + " was found");
			return pb;
		}
		else {
			System.out.println("Participant with roll no: " + rollNo + " was not found");
			throw new NoSuchParticipant();
		}
		
	}
	
	@Override
	public boolean createParticipant(ParticipantBean pb) throws ParticipantAlreadyExistsException{
		ParticipantBean result = participants.putIfAbsent(pb.getRollNo(), pb);
		if(result == null) {
			System.out.println("Participant with roll no: " + pb.getRollNo() + " was created");
			return true;
		}
		else {
			System.out.println("Participant with roll no: " + pb.getRollNo() + " already exists");
			throw new ParticipantAlreadyExistsException();
		}
		
	}
	
	@Override
	public boolean updateParticipant(String rollNo, ParticipantBean pb) throws NoSuchParticipant{
		if (participants.containsKey(rollNo)) {
			ParticipantBean result = participants.put(rollNo, pb);

			if (result != null) {
				System.out.println("Participant with roll no: " + pb.getRollNo() + " was updated");
				return true;
			} else {
				System.out.println("Participant with roll no: " + pb.getRollNo() + " update failed");
				return false;
			}
		} else {
			System.out.println("Participant with roll no: " + rollNo + " not found");
			throw new NoSuchParticipant();
		}
	}
	
	

	@Override
	public boolean deleteParticipant(String rollNo) throws NoSuchParticipant {
		if (participants.containsKey(rollNo)) {
			ParticipantBean pb = participants.remove(rollNo);
			if (participants.containsKey(rollNo)) {
				System.out.println("Participant with roll no: " + pb.getRollNo() + " was not deleted.");
				return false;
			} else {
				System.out.println("Participant with roll no: " + pb.getRollNo() + " was deleted.");
				return true;
			}
		} else {
			System.out.println("Participant with roll no: " + rollNo + " not found");
			throw new NoSuchParticipant();
		}
	}
	
	public void mockData() {
		participants.put("1001", new ParticipantBean("1001", "yash@gmail.com", "3", "A1003"));
		participants.put("1002", new ParticipantBean("1002", "yash2@gmail.com", "4", "A1004"));
	}
	
	public void print() {
		System.out.println(participants);
	}
	
	@Override
	public ArrayList<ParticipantBean> getAll() {
		List<ParticipantBean> result = participants.values().stream().collect(Collectors.toList());
		return new ArrayList<ParticipantBean>(result);
	}
	
	
}
