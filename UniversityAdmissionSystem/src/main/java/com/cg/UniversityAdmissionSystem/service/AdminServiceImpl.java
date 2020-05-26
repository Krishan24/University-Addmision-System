package com.cg.UniversityAdmissionSystem.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.cg.UniversityAdmissionSystem.bean.ApplicationBean;
import com.cg.UniversityAdmissionSystem.bean.ProgramOfferedBean;
import com.cg.UniversityAdmissionSystem.bean.ProgramScheduledBean;
import com.cg.UniversityAdmissionSystem.bean.UsersBean;
import com.cg.UniversityAdmissionSystem.dao.AdminDaoImpl;
import com.cg.UniversityAdmissionSystem.dao.ApplicantDaoImp;
import com.cg.UniversityAdmissionSystem.dao.UserDaoImpl;
import com.cg.UniversityAdmissionSystem.exception.AuthenticationfailedException;
import com.cg.UniversityAdmissionSystem.exception.InvalidDateException;
import com.cg.UniversityAdmissionSystem.exception.InvalidProgramException;
import com.cg.UniversityAdmissionSystem.exception.NoSuchApplication;
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

	
//	private static ValidationService val = (user, pass) -> {
//		try {
//			UsersBean u = udi.readUser(user);
//			if (u.getPassword().equals(pass) && u.getRole().equalsIgnoreCase("admin")) {
//				return true;
//			} else {
//				throw new AuthenticationfailedException();
//			}
//		} catch (InvalidUserException e) {
//			throw new AuthenticationfailedException();
//		}
//
//	};
//	
//	
//	public static AdminServiceImpl getAdminService(String loginId, String password)
//			throws AuthenticationfailedException {
//		
//		try {
//			boolean auth = val.authenticate(loginId, password);
//			if (auth) {
//				//logger.info("Admin login authenticated");
//				asi = new AdminServiceImpl();
//			}
//			return asi;
//		} catch (AuthenticationfailedException e) {
//			//logger.info("Admin login Failed");
//			throw e;
//		}
//	}
	
	
	
	
	@Override
	public int addProgram(ProgramOfferedBean po) throws ProgramAlreadyExistsException {
		boolean result = false;
		try {
			result = adimp.createProgramsOffered(po);
			if (result) {
				//logger.info("New Program : " + po.getProgramName() + " added");
				return 1;
			} else {
				//logger.info("New Program : " + po.getProgramName() + " addition failed");
				return 0;
			}
		} catch (ProgramAlreadyExistsException e) {
			//logger.info("New Program : " + po.getProgramName() + " already present");
			throw e;
		}
	}

	@Override
	public int updateOfferedProgram(ProgramOfferedBean po) throws InvalidProgramException {
		try {
			boolean result = adimp.updateProgramsOffered(po.getProgramName(), po);
			if (result) {
				//logger.info("Program : " + po.getProgramName() + " updated");
				return 1;
			} else {
				//logger.info("Program : " + po.getProgramName() + " update failed");
				return 0;
			}
		} catch (InvalidProgramException e) {
			//logger.info("Program : " + po.getProgramName() + " invalid");
			throw e;
		}
	}

	@Override
	public int removeProgram(String program) throws InvalidProgramException {
		try {
			boolean result = adimp.deleteProgramsOffered(program);
			if (result) {
				//logger.info("offered program deleted.");
				return 1;
			} else {
				//logger.info("offered program deletion failed.");
				return 0;
			}
		} catch (InvalidProgramException e) {
			try {
				ApplicationBean a = adi.readApplicationByProgramId(program);
				if (a != null) {
					//logger.info("program has 1 or more applications, delete failed.");
					return 0;
				}
			} catch (NoSuchApplication e1) {
				try {
					boolean result = adimp.deleteProgramsScheduled(program);
					if (result) {
						//logger.info("scheduled program deleted successfully.");
						return 1;
					} else {
						//logger.info("scheduled program failed to delete.");
						return 0;
					}
				} catch (InvalidProgramException e2) {
					throw e2;
				}
			}
		}

		return 0;

	}

	@Override
	public ArrayList<ApplicationBean> applicationsByStatus(String status) {
		List<ApplicationBean> result = adi.getAll().stream().filter((a) -> {
			return a.getStatus().equalsIgnoreCase(status);
		}).collect(Collectors.toList());
		//logger.info(result.size() + " applications have " + status + " status");
		return new ArrayList<ApplicationBean>(result);
	}

	@Override
	public ArrayList<ProgramScheduledBean> reportOfScheduledProgramsByDate(LocalDate s, LocalDate e) {
		List<ProgramScheduledBean> result = adimp.reportAllScheduledProgram().stream().filter((ProgramScheduledBean ps) -> {
			int t1 = ps.getStartDate().compareTo(s); // ps-s
			int t2 = ps.getStartDate().compareTo(e); // ps-e
			if (t1 >= 0 && t2 <= 0) {
				return true;
			} else {
				return false;
			}
		}).collect(Collectors.toList());
		//logger.info(result.size() + " scheduled programs start between :" + s + " and " + e);
		return new ArrayList<ProgramScheduledBean>(result);
	}

	@Override
	public ArrayList<ProgramOfferedBean> offeredProgramsList() {
		return adimp.reportAllProgramOffered();
	}

	@Override
	public ArrayList<ProgramScheduledBean> scheduledProgramsList() {
		return adimp.reportAllScheduledProgram();
	}

	@Override
	public boolean addScheduledProgram(ProgramScheduledBean ps)
			throws ProgramAlreadyExistsException, InvalidDateException, InvalidProgramException {
		LocalDate d1 = ps.getStartDate();
		LocalDate d2 = ps.getEndDate();
		int t1 = d2.compareTo(d1);
		int t2 = d1.compareTo(LocalDate.now());
		int t3 = d2.compareTo(LocalDate.now());
		if (t1 < 0 || t2 < 0 || t3 < 0) {
		//	logger.info("Wrong pair of date was entered.");
			throw new InvalidDateException();
		}
		try {
			adimp.readProgramsScheduled(ps.getScheduledProgramId());
		//	logger.info("the program :" + ps.getScheduledProgramId() + " is already scheduled.");
			throw new ProgramAlreadyExistsException();
		} catch (InvalidProgramException e) {
			//logger.info("the program :" + ps.getScheduledProgramId() + " is not yet scheduled.");
			try {
				ProgramOfferedBean po = adimp.readProgramsOffered(ps.getProgramName());
				if (po != null) {
				//	logger.info("the program : " + ps.getProgramName() + " is available in offered programs.");
					boolean result = adimp.createProgramsScheduled(ps);
					if (result) {
						//logger.info("The program : " + ps.getScheduledProgramId() + " was scheduled.");
						return true;
					} else {
						//logger.info("The program : " + ps.getScheduledProgramId() + " failed to schedule.");
						return false;
					}
				} else {
					//logger.info("the program : " + ps.getProgramName() + " is unavailable in offered programs.");
					throw new InvalidProgramException();
				}
			} catch (InvalidProgramException e1) {
				//logger.info("the program : " + ps.getProgramName() + " is not available in offered programs.");
				throw e1;
			}

		}
	}
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
