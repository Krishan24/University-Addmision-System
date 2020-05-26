package com.cg.UniversityAdmissionSystem.dao;

 
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.cg.UniversityAdmissionSystem.bean.ApplicationBean;
import com.cg.UniversityAdmissionSystem.bean.ParticipantBean;
import com.cg.UniversityAdmissionSystem.bean.ProgramOfferedBean;
import com.cg.UniversityAdmissionSystem.bean.ProgramScheduledBean;
import com.cg.UniversityAdmissionSystem.exception.InvalidProgramException;
import com.cg.UniversityAdmissionSystem.exception.ProgramAlreadyExistsException;

public class AdminDaoImpl implements IAdminDao{
	
	
	private static HashMap<String, ProgramOfferedBean> progOffered = new HashMap<String, ProgramOfferedBean>();
	private static HashMap<String, ProgramScheduledBean> programsScheduled = new HashMap<String, ProgramScheduledBean>();

	@Override
	public ProgramOfferedBean readProgramsOffered(String programName) throws InvalidProgramException {
		ProgramOfferedBean programsOffered = progOffered.get(programName);
		if (programsOffered != null) {
			//logger.info("Program with name: " + programName + " was found.");
			return programsOffered;
		} else {
			//logger.info("Program with name: " + programName + " was not found.");
			throw new InvalidProgramException();
		}
	}

	@Override
	public boolean createProgramsOffered(ProgramOfferedBean programsOffered) throws ProgramAlreadyExistsException {
		ProgramOfferedBean p = progOffered.putIfAbsent(programsOffered.getProgramName(), programsOffered);
		if (p == null) {
			//logger.info("Program with name: " + programOffered.getProgramName() + " was created.");
			return true;
		} else {
			//logger.info("Program with name: " + programOffered.getProgramName() + " already exists.");
			throw new ProgramAlreadyExistsException();
		}
	}

	@Override
	public boolean updateProgramsOffered(String programName, ProgramOfferedBean programsOffered)
			throws InvalidProgramException {
		if (progOffered.containsKey(programName)) {
			ProgramOfferedBean po = progOffered.put(programName, programsOffered);
			if (po != null) {
				//logger.info("Program with name: " + programName + " was updated");
				return true;
			} else {
				//logger.info("Program with name: " + programName + " update failed");
				return false;
			}
		} else {
			//logger.info("Program with name: " + programName + " was not found.");
			throw new InvalidProgramException();
		}
	}

	@Override
	public boolean deleteProgramsOffered(String programName) throws InvalidProgramException {
		if (progOffered.containsKey(programName)) {
			progOffered.remove(programName);
			if (progOffered.containsKey(programName)) {
				//logger.info("Program with name: " + programName + "was not deleted.");
				return false;
			} else {
				//logger.info("Program with name: " + programName + " was deleted");
				return true;
			}
		} else {
			//logger.info("Program with name: " + programName + " was not found.");
			throw new InvalidProgramException();
		}
	}

	@Override
	public ArrayList<ProgramOfferedBean> reportAllProgramOffered() {
		return new ArrayList<ProgramOfferedBean>(progOffered.values());
	}

	
	public static void mockdataPO() {
		progOffered.put("BTECH",
				new ProgramOfferedBean("BTECH", "Bachelors of Tech", "passed 10+2 (PCM) with 60% or above", 4, "NA"));
		progOffered.put("MCA",
				new ProgramOfferedBean("MCA", "Masters in Comp. App.", "passed BCA with 60% or above", 3, "NA"));
		progOffered.put("BCA",
				new ProgramOfferedBean("BCA", "Bachelors in Comp. App.", "passed 10+2 with 60% or above", 3, "NA"));
		progOffered.put("BA", 
				new ProgramOfferedBean("BA", "Bachelors in Arts", "passed 10+2 with 60% or above", 3, "NA"));
		progOffered.put("MBA",
				new ProgramOfferedBean("MBA", "Masters in business adm", "passed 10+2 with 60% or above", 3, "NA"));

	}
	
	@Override
	public ProgramScheduledBean readProgramsScheduled(String scheduledProgramId) throws InvalidProgramException {
		ProgramScheduledBean scheduled = programsScheduled.get(scheduledProgramId);
		if (scheduled != null) {
			//logger.info("Program Scheduled with id: " + scheduledProgramId + " was found");
			return scheduled;
		} else {
			//logger.info("Program Scheduled with id: " + scheduledProgramId + " was not found");
			throw new InvalidProgramException();
		}
	}

	@Override
	public ArrayList<ProgramScheduledBean> reportAllScheduledProgram() {
		//logger.info(programsScheduled.size() + " applications were read.");
		return new ArrayList<ProgramScheduledBean>(programsScheduled.values());

	}

	@Override
	public boolean createProgramsScheduled(ProgramScheduledBean scheduled) throws ProgramAlreadyExistsException {
		ProgramScheduledBean p = programsScheduled.putIfAbsent(scheduled.getScheduledProgramId(), scheduled);
		if (p == null) {
			//logger.info("Program Scheduled with id: " + scheduled.getScheduledProgramId() + " was created");
			return true;
		} else {
			//logger.info("Program Scheduled with id: " + scheduled.getScheduledProgramId() + " already exists");
			throw new ProgramAlreadyExistsException();
		}
	}

	@Override
	public boolean updatePogramsScheduled(String scheduledProgramId, ProgramScheduledBean scheduled)
			throws InvalidProgramException {
		ProgramScheduledBean p = programsScheduled.put(scheduledProgramId, scheduled);
		if (p != null) {
			//logger.info("Program scheduled with id: " + scheduledProgramId + " was updated");
			return true;
		} else {
			//logger.info("Program scheduled with id: " + scheduledProgramId + " was not valid");
			throw new InvalidProgramException();
		}
	}

	@Override
	public boolean deleteProgramsScheduled(String scheduledProgramId) throws InvalidProgramException {
		if (programsScheduled.containsKey(scheduledProgramId)) {
			programsScheduled.remove(scheduledProgramId);
			if (programsScheduled.containsKey(scheduledProgramId)) {
				//logger.info("Program with name: " + scheduledProgramId + "was not deleted.");
				return false;
			} else {
				//logger.info("Program with name: " + scheduledProgramId + " was deleted");
				return true;
			}
		} else {
			//logger.info("Program with name: " + scheduledProgramId + " was not found.");
			throw new InvalidProgramException();
		}
	}
	
	public static void mockDataPS() {
		programsScheduled.put("A1001",
				new ProgramScheduledBean("A1001", "BE", "Mumbai", LocalDate.of(2020, 2, 1),
				LocalDate.of(2020, 3, 1), 6));
		programsScheduled.put("A1002",
				new ProgramScheduledBean("A1002", "BCA", "Kolkata", LocalDate.of(2020, 2, 11),
				LocalDate.of(2020, 3, 1), 6));
		programsScheduled.put("A1003", 
				new ProgramScheduledBean("A1003", "MCA", "Kolkata", LocalDate.of(2020, 3, 1),
				LocalDate.of(2020, 3, 1), 6));
		programsScheduled.put("A1004",
				new ProgramScheduledBean("A1004", "BA", "Pune", LocalDate.of(2020, 4, 1),
				LocalDate.of(2020, 3, 1), 6));
		programsScheduled.put("A1005",
				new ProgramScheduledBean("A1005", "MBBS", "Bangalore",LocalDate.of(2020, 5, 1),
				LocalDate.of(2020, 3, 1), 6));
		programsScheduled.put("A1006",
				new ProgramScheduledBean("A1006", "LAW", "Bangalore", LocalDate.of(2020, 5, 1),
				LocalDate.of(2020, 3, 1), 6));
	}
	
	
	
	
//	ParticipantBean pb=new ParticipantBean();
//
//	List<ProgramOfferedBean> proOffList=new ArrayList<ProgramOfferedBean>();
//	List<ProgramScheduledBean> proSchList=new ArrayList<ProgramScheduledBean>();
//	List<String> ProNameList = new ArrayList<String>();
//	List<String> ShNameList = new ArrayList<String>();
//	List<ParticipantBean> participantList=new ArrayList<ParticipantBean>();
//	
//	public void addProgramOffered(ProgramOfferedBean pOffered) {
//		proOffList.add(pOffered);
//		
//	}
//
//	public boolean deleteProgramOffered(String programName) {
//		proOffList.remove(programName);
//		return true;
//	}
//
//	public boolean deleteProgramScheduled(String programId) {
//		proSchList.remove(programId);
//		return true;
//	}
//
//	public int addProgramScheduled(ProgramScheduledBean pScheduled) {
//		proSchList.add(pScheduled);
//		return 1;
//	}
//
//	public List<ProgramScheduledBean> getAllDetails() {
//		
//		return proSchList;
//	}
//
//	public List<String> getAllProgramName() {
//		Iterator iterator = proOffList.iterator();
//		while(iterator.hasNext()){
//			  ProNameList.add(((ProgramOfferedBean) iterator.next()).getProgramName());
//			}
//		return ProNameList;
//	}
//
//	public List<String> getAllScheduleNames() {
//		Iterator iterator = proSchList.iterator();
//		while(iterator.hasNext()){
//			  ProNameList.add(((ProgramOfferedBean) iterator.next()).getProgramName());
//			}
//		return ShNameList;
//		
//	}
//
//	public List<ParticipantBean> getApplicantsByScheduledProgramId(String pScheduledId) 
//	{
//		
//		List<ParticipantBean> result=participantList.stream().filter((p) -> {
//			return p.getScheduledProgramId().equalsIgnoreCase(pScheduledId);
//		}).collect(Collectors.toList());
//		return new ArrayList<ParticipantBean>(result);
//	
//			
//	}
//
//	public List<ParticipantBean> getAllConfirmedApplicants() {
//		return participantList;
//		
//	}
//
//	public List<ProgramOfferedBean> getOfferedProgram() {
//		
//		return proOffList;
//	}
//
//	public List<ProgramScheduledBean> getScheduledProgListForProg(String prog) {
//		List<ProgramScheduledBean> result=proSchList.stream().filter((p) -> {
//			return p.getScheduledProgramId().equalsIgnoreCase(prog);
//		}).collect(Collectors.toList());
//		return new ArrayList<ProgramScheduledBean>(result);
//	}

}
