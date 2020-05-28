package com.cg.UniversityAdmissionSystem.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.cg.UniversityAdmissionSystem.bean.ApplicationBean;
import com.cg.UniversityAdmissionSystem.bean.ParticipantBean;
import com.cg.UniversityAdmissionSystem.bean.UsersBean;
import com.cg.UniversityAdmissionSystem.dao.ApplicationDaoImpl;
import com.cg.UniversityAdmissionSystem.dao.ParticipantDaoImpl;
import com.cg.UniversityAdmissionSystem.dao.UserDaoImpl;
import com.cg.UniversityAdmissionSystem.exception.AuthenticationfailedException;
import com.cg.UniversityAdmissionSystem.exception.InvalidUserException;
import com.cg.UniversityAdmissionSystem.exception.NoSuchApplication;
import com.cg.UniversityAdmissionSystem.exception.NoSuchParticipant;
import com.cg.UniversityAdmissionSystem.exception.ParticipantAlreadyExistsException;

public class MacServiceImpl implements IMacService {

	private static MacServiceImpl credentials = null;
	private static UserDaoImpl udimp = new UserDaoImpl();
	private ApplicationDaoImpl adimp = new ApplicationDaoImpl();
	private ParticipantDaoImpl pdimp = new ParticipantDaoImpl();
	private static int rollNo = 1004;

	private MacServiceImpl() {

	}

	public static void setUdimp(UserDaoImpl udimp) {
		MacServiceImpl.udimp = udimp;
	}

	public void setAdimp(ApplicationDaoImpl adimp) {
		this.adimp = adimp;
	}

	public void setPdimp(ParticipantDaoImpl pdimp) {
		this.pdimp = pdimp;
	}

	public static MacServiceImpl getMemberService(String loginId, String password)
			throws AuthenticationfailedException {
		ValidationService val = (user, pass) -> {
			try {
				UsersBean u= udimp.readUser(user);
				if (u.getPassword().equals(pass) && u.getRole().equalsIgnoreCase("mac")) {
					return true;
				} else {
					throw new AuthenticationfailedException();
				}
			} catch (InvalidUserException e) {
				throw new AuthenticationfailedException();
			}
		};

		boolean auth;
		try {
			auth = val.authenticate(loginId, password);
			if (auth) {
				credentials = new MacServiceImpl();
			}
			return credentials;
		} catch (AuthenticationfailedException e) {
			throw e;
		}

	}

	@Override
	public ArrayList<ApplicationBean> applicationsOfProgram(String scheduledProgramId) {
		List<ApplicationBean> applications = adimp.getAll().stream().filter((a) -> {
			return a.getScheduledProgramId().equalsIgnoreCase(scheduledProgramId);
		}).collect(Collectors.toList());
		return new ArrayList<ApplicationBean>(applications);
	}

	@Override
	public boolean updateApplicationStatus(String applicationId, int status) throws NoSuchApplication {

		ApplicationBean app = adimp.readApplication(applicationId);
		if (app == null) {
			throw new NoSuchApplication();
		}
		switch (status) {
		case 1:
			if (app.getStatus().equalsIgnoreCase("Accepted")) {
				app.setStatus("Confirmed");
			} else {
				return false;
			}
			break;
		case 2:
			app.setStatus("Rejected");
			break;
		case 3:
			if (app.getStatus().equalsIgnoreCase("Pending")) {
				app.setStatus("Accepted");
			} else {
				return false;
			}
			break;
		default:
			return false;
		}

		try {
			boolean result = adimp.updateApplication(applicationId, app);
			if (result && app.getStatus().equalsIgnoreCase("confirmed")) {
				String rollNum = Integer.toString(rollNo);
				ParticipantBean p = new ParticipantBean(rollNum, app.getEmailId(), app.getApplicationId(),
						app.getScheduledProgramId());
				try {
					result = pdimp.createParticipant(p);
					if (result) {
						rollNo++;
						return true;
					} else {
						return false;
					}
				} catch (ParticipantAlreadyExistsException e) {
					try {
						return pdimp.updateParticipant(p.getRollNo(), p);
					} catch (NoSuchParticipant e1) {
						return false;
					}

				}
			} else if (result) {
				return true;
			} else {
				return false;
			}
		} catch (NoSuchApplication e) {
			throw e;
		}
	}

	@Override
	public boolean scheduleInterview(String applicationId, LocalDate date) throws NoSuchApplication {
		try {
			ApplicationBean apBean = adimp.readApplication(applicationId);
			if (apBean.getStatus().equalsIgnoreCase("Pending")) {
				boolean result = this.updateApplicationStatus(applicationId, 3);
				if (result) {
					apBean.setDateOfInterview(date);
					return true;
				}
			}
		} catch (NullPointerException | NoSuchApplication e) {
			throw new NoSuchApplication();
		}
		return false;
	}

	@Override
	public ArrayList<ParticipantBean> getParticipants(String scheduledProgramId) {
		List<ParticipantBean> result = pdimp.getAll().stream().filter((p) -> {
			return p.getScheduledProgramId().equalsIgnoreCase(scheduledProgramId);
		}).collect(Collectors.toList());
		return new ArrayList<ParticipantBean>(result);
	}

//   public List<Integer> getApplicantId() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<String> getScheduleId() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<ApplicationBean> getApplicantOnScheduledId(String scheduledProgramId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<ApplicationBean> getApplicantAfterInterviewOnId(String scheduledProgramId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public String updateApplicantStatus(int applicationId, String status) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public void updateApplicantDateOfInterview(int applicationId, LocalDate dateOfInterview) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//	public static boolean validateScheduledId(String id)
//	{
//		String pattern = "[0-9]{4}";
//		if(id.matches(pattern))
//		{
//			return true;
//		}
//		else
//		 return false;
//	}
//
//	public List<String> getscheduleId() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
