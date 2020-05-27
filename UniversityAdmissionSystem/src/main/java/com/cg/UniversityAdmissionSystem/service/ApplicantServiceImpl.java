package com.cg.UniversityAdmissionSystem.service;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.cg.UniversityAdmissionSystem.bean.ApplicationBean;
import com.cg.UniversityAdmissionSystem.bean.ProgramScheduledBean;
import com.cg.UniversityAdmissionSystem.dao.AdminDaoImpl;
import com.cg.UniversityAdmissionSystem.dao.ApplicationDaoImpl;

import com.cg.UniversityAdmissionSystem.exception.ApplicationAlreadyExistsException;
import com.cg.UniversityAdmissionSystem.exception.InvalidProgramException;
import com.cg.UniversityAdmissionSystem.exception.NoProgramsAvailableException;
import com.cg.UniversityAdmissionSystem.exception.NoSuchApplication;



public class ApplicantServiceImpl implements IApplicanttService{
	
	private static int applicationId = 5;
	
	private static AdminDaoImpl adimpl = new AdminDaoImpl();
	private static ApplicationDaoImpl adi = new ApplicationDaoImpl();
	
	
	@Override
	public ArrayList<ProgramScheduledBean> getScheduledProgramList() throws NoProgramsAvailableException{
		ArrayList<ProgramScheduledBean> result = adimpl.reportAllScheduledProgram();
		if(result == null) {
			throw new NoProgramsAvailableException();
		}
		else {
			return result;
		}
	}
	
	@Override
	public int applyOnline(ApplicationBean ab) throws ApplicationAlreadyExistsException,InvalidProgramException{
		ProgramScheduledBean psb = adimpl.readProgramsScheduled(ab.getScheduledProgramId());
		if(psb == null) {
			throw new InvalidProgramException();
		}
		ab.setApplicationId(Integer.toString(applicationId));
		System.out.println("application started");
		try {
			boolean result = adi.createApplication(ab);
			applicationId++;
			return applicationId - 1;
		}
		catch(ApplicationAlreadyExistsException e) {
			throw e;
		}
	}
	
	public String applicationStatus(String ApplicationId)throws NoSuchApplication{
		try {
			ApplicationBean ab = adi.readApplication(ApplicationId);
			return ab.getStatus();
		}
		catch(NoSuchApplication e) {
			throw e;	
		}
	}
	
}
	
	
//	private IApplicantDao appDao;
//	private  static String patternDob = "[0-3][0-9]/[A-Za-z]{3}/[0-9]{4}";
//
//	public List<ProgramScheduledBean> showProgramScheduled() {
//		// TODO Auto-generated method stub
//		return appDao.showProgramScheduled();
//	}
//
//	public int addDetail(ApplicationBean ab) {
//		// TODO Auto-generated method stub
//		return appDao.addDetail(ab);
//	}
//
//	public ApplicationBean showStatus(int applicationId) {
//		// TODO Auto-generated method stub
//		return appDao.showStatus(applicationId);
//	}
//	
//	public static boolean fullNameValidation(String fname)
//	{
//		String pattern = "[A-Z][A-Za-z ]{2,19}";
//		if(fname.matches(pattern))
//		{
//			return true;
//		}
//		else
//			return false;
//	}
//	
//	public static boolean isAgeEligible(LocalDate date) {
//		int dDob = date.getDayOfMonth();
//		int yDob = date.getYear();
//		int yNow = LocalDate.now().getYear();
//		if((yNow-yDob)>=17 && (yNow-yDob)<25) {
//		return true;
//	}else
//	{
//		return false;
//	}
//}
//	
//	
//	public static boolean dateOfBirthValidation(String dateOfBirth) {
//		LocalDate dob;
//		if(dateOfBirth.matches(patternDob)) {
//			try {
//				DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMM-YYYY");
//				dob = LocalDate.parse(dateOfBirth,format);
//				if(!isAgeEligible(dob)) {
//					System.out.println("Age Should be 17 to 25 years");
//					return isAgeEligible(dob);
//				}
//			}catch(Exception e) {
//				System.err.println("Date should be entered in proper format e.g(16/Dec/1995)");
//				return false;
//			}
//			
//		}else {
//			System.err.println("Date should be entered in proper format e.g(16/Dec/1995)");
//			return false;
//		}
//		return false;
//	}
//	
//	
//	
//	
//	public static boolean emailValidation(String email)
//	{
//		String pattern = "[a-zA-Z0-9]{4,15}[@][a-zA-Z]{1,10}[.](com|net|gov|in|org)";
//		if(email.matches(pattern))
//		{
//			return true;
//		}
//		else
//			return false;
//	}
//	
//	public static boolean highestqualification(String hq)
//	{
//		String pattern = "[0-9A-Za-z .]{1,10}";
//		if(hq.matches(pattern))
//		{
//			return true;
//		}
//		else
//			return false;
//	
//	}
//	
//	
//	public static boolean goalsValidation(String goals)
//	{
//		String pattern = "[A-Z][A-Za-z ]{1,19}";
//		if(goals.matches(pattern))
//		{
//			return true;
//		}
//		else
//			return false;
//	
//	}
//	
//}
//	
	
	
	
	
	



