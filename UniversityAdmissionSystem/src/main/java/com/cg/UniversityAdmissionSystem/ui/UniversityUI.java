package com.cg.UniversityAdmissionSystem.ui;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

import com.cg.UniversityAdmissionSystem.bean.ApplicationBean;
import com.cg.UniversityAdmissionSystem.bean.ProgramScheduledBean;
import com.cg.UniversityAdmissionSystem.dao.ApplicationDaoImpl;
import com.cg.UniversityAdmissionSystem.exception.ApplicationAlreadyExistsException;
import com.cg.UniversityAdmissionSystem.exception.InvalidProgramException;
import com.cg.UniversityAdmissionSystem.exception.NoProgramsAvailableException;
import com.cg.UniversityAdmissionSystem.exception.NoSuchApplication;
import com.cg.UniversityAdmissionSystem.service.ApplicantServiceImpl;

public class UniversityUI {
	
	private static ApplicantServiceImpl asi = new ApplicantServiceImpl();
	
	public static void main(String[] args) {
		ApplicationDaoImpl.mockData();
		
		Scanner s = new Scanner(System.in);
		
	boolean run = true;
	
	while(run) {
		System.out.println(" WELCOME TO UNIVERSITY ADMISSION SYSTEM ");
		System.out.println("****************************************");
		System.out.println("   1.View Scheduled Programs:   ");
		System.out.println("   2.Apply Online:   ");
		System.out.println("   3.View Application Status:   ");
		System.out.println("   4.Exit   ");
		System.out.println("****************************************");
		int choice;
		try {
			choice = s.nextInt();
		}
		catch(InputMismatchException e) {
			choice = 0;
		}
		
		switch(choice) {
		case 1:
			viewScheduledPrograms();
			break;
			
		case 2:
			applyOnline(s);
			break;
			
		case 3:
			System.out.println("Enter the applicationId");
			String applicationId = s.next();
			try {
				String status = asi.applicationStatus(applicationId);
				System.out.println("Your application is :"+ status);
			}
			catch(NoSuchApplication e) {
				System.out.println(e.getMessage());
				
			}
			break;
			
		
		
		case 4:
			run = false;
			System.out.println("Thank You For Visiting.");
			break;
		default:
			System.out.println("Invalid choice");
		
		
	}
	}
	s.close();
	}
	
	private static void viewScheduledPrograms() {
		try {
			ArrayList<ProgramScheduledBean> result = asi.getScheduledProgramList();
			for(ProgramScheduledBean psb : result) {
				System.out.println(psb);
			}
		}
		catch(NoProgramsAvailableException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private static void applyOnline(Scanner s) {
		ApplicationBean ab = null;
		try {
			s.nextLine();
			
			System.out.println("Enter your FullName: ");
			String fullName = s.nextLine();
			System.out.println("Enter your Date Of Birth in yyyy-mm-dd:");
			String dateOfBirth = s.next();
			s.nextLine();
			System.out.println("Enter the Highest Qualification:");
			String highestQualification = s.nextLine();
			System.out.println("Enter Marks Obtained:");
			int marksObtained = s.nextInt();
			s.nextLine();
			System.out.println("Enter your Goals:");
			String goals = s.nextLine();
			System.out.println("Enter the EmailID:");
			String emailID = s.nextLine();
			System.out.println("Enter the Scheduled Program Id:");
			String scheduledProgramid = s.nextLine();
			String status = "pending";
			
			ab = new ApplicationBean("", fullName, LocalDate.parse(dateOfBirth), highestQualification, marksObtained, goals, emailID, scheduledProgramid, status, null );
			
			int id = asi.applyOnline(ab);
			System.out.println("Your application is Successfully Submitted:" + id);
		}
		catch(ApplicationAlreadyExistsException | InvalidProgramException e) {
			System.out.println(e);
			ab = null;
			
		}
		catch(DateTimeParseException e) {
			System.out.println("Invalid date entered");
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid Data Entered");
		}
	}

}
