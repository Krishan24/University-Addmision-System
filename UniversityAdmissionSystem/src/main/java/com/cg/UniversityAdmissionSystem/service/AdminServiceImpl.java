package com.cg.UniversityAdmissionSystem.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cg.UniversityAdmissionSystem.bean.ApplicationBean;
import com.cg.UniversityAdmissionSystem.bean.ProgramOfferedBean;
import com.cg.UniversityAdmissionSystem.bean.ProgramScheduledBean;
import com.cg.UniversityAdmissionSystem.dao.AdminDaoImpl;
import com.cg.UniversityAdmissionSystem.dao.ApplicantDaoImp;
import com.cg.UniversityAdmissionSystem.dao.UserDaoImpl;
import com.cg.UniversityAdmissionSystem.exception.InvalidDateException;
import com.cg.UniversityAdmissionSystem.exception.InvalidProgramException;
import com.cg.UniversityAdmissionSystem.exception.ProgramAlreadyExistsException;

public class AdminServiceImpl implements IAdminService {
	
	private static AdminServiceImpl asi = null;
	private static UserDaoImpl udi = new UserDaoImpl();
	private AdminDaoImpl adimp = new AdminDaoImpl();
	private ApplicantDaoImp adi = new ApplicantDaoImp();
	



	public static void setUdi(UserDaoImpl udi) {
		AdminServiceImpl.udi = udi;
	}

	public void setPodi(AdminDaoImpl adimp) {
		this.adimp = adimp;
	}

	public void setAdi(ApplicantDaoImp adi) {
		this.adi = adi;
	}

	
	private static ValidationService val = (user, pass) -> {
		try {
			User u = udi.readUser(user);
			if (u.getPassword().equals(pass) && u.getRole().equalsIgnoreCase("admin")) {
				logger.info("authenticated");
				return true;
			} else {
				logger.info("admin auth error.");
				throw new AuthenticationfailedException();
			}
		} catch (InvalidUserException e) {
			logger.info("admin auth error.");
			throw new AuthenticationfailedException();
		}

	};
	
	
	
	
	@Override
	public int addProgram(ProgramOfferedBean po) throws ProgramAlreadyExistsException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOfferedProgram(ProgramOfferedBean po) throws InvalidProgramException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeProgram(String program) throws InvalidProgramException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ApplicationBean> applicationsByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ProgramScheduledBean> reportOfScheduledProgramsByDate(LocalDate s, LocalDate e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ProgramOfferedBean> offeredProgramsList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ProgramScheduledBean> scheduledProgramsList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addScheduledProgram(ProgramScheduledBean ps)
			throws ProgramAlreadyExistsException, InvalidDateException, InvalidProgramException {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	

//	public void addProgramOffered(ProgramOfferedBean pOffered) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public boolean deleteProgramOffered(String programName) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	public boolean deleteProgramScheduled(String programId) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	public int addProgramScheduled(ProgramScheduledBean pScheduled) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	public List<ProgramScheduledBean> getAllDetails() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<String> getAllProgramName() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<String> getAllScheduleNames() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<ApplicationBean> getApplicantsByStatusByScheduledProgramId(String status, String pScheduledId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<ApplicationBean> getApplicantsByScheduledProgramId(String pScheduledId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<ApplicationBean> getAllConfirmedApplicants() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<ProgramOfferedBean> getOfferedProgram() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<ProgramScheduledBean> getScheduledProgListForProg(String prog) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public static boolean validateDate(String date) {
//		String pattern = "[0-9]{2}[/]{1}[0-9]{2}[/]{1}[0-9]{4}";
//		if(date.matches(pattern))
//		{
//			return true;
//		}
//		else
//			return false;
//	}
//
//	public static boolean validateEligibility(String eligible) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	public boolean validateProgramDescription(String pDesc) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	public List<String> getAllScheduleId() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public boolean validateLocation(String location) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	public boolean generateParticipants(List<ApplicationBean> confirmList) {
//		// TODO Auto-generated method stub
//		return false;
//	}
	
}
