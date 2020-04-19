package com.cg.UniversityAdmissionSystem.ui;
import com.cg.UniversityAdmissionSystem.bean.ApplicationBean;
import com.cg.UniversityAdmissionSystem.bean.ProgramScheduledBean;
import com.cg.UniversityAdmissionSystem.service.ApplicantServiceImpl;
import com.cg.UniversityAdmissionSystem.service.IApplicanttService;
import com.cg.UniversityAdmissionSystem.service.IMacService;
import com.cg.UniversityAdmissionSystem.service.MacServiceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;



public class StudentConsole
{
	private static IApplicanttService appServices;
	private static DateTimeFormatter format;
	
	

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String fname,dob,email,highestQualification, goals;
		
		boolean flag = true, flag1=true;
		LocalDate dateOfBirth=null; LocalDate dateOfInterview = null;
		double marksObtained=0.0;
		int applicationId = 0;
		
		
		int choice = -1;
		
		Scanner scr = new Scanner(System.in);
		System.out.println("Choose an operation");
		
			
				System.out.println("1. Program Scheduled");
				System.out.println("2. Apply Online");
				System.out.println("3. Application Status");
				System.out.println("4. Exit");
				System.out.println("---------------------------");
				System.out.print("\nPlease Enter a Choice : ");
				if(scr.hasNextInt()) 
				{
					choice = scr.nextInt();
				}
				else 
				{
					System.out.println("Please Enter a number as in menu");
					scr.hasNext();
				}
				List<ProgramScheduledBean> programScheduled = null;
				switch(choice)
		{
				case 1:	
					programScheduled = appServices.showProgramScheduled();
			    for (ProgramScheduledBean pBean : programScheduled) 
			    {
					System.out.println(pBean);
			    }
					break;
					
				case 2:
					 fname = scr.nextLine();
					
				do
				{
					System.out.println("Enter your Full Name as per the 10th Marksheet ");
					fname = scr.nextLine();
					flag = ApplicantServiceImpl.fullNameValidation(fname);
					if(flag==false)
					{
						System.out.println("Name should be entered less than 20 character and first letter is capital");
					}
				}
				while(flag==false);
				
				
			
				
				do
				{
					System.out.println("Enter Date Of Birth e.g(16/Dec/1995)");
					dob = scr.next();
					flag = ApplicantServiceImpl.dateOfBirthValidation(dob);
					if(flag==false)
					{
						System.out.println(" Please enter the Date Of Birth in given Format");
					}
				}
				while(flag==false);
				
				format = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
				dateOfBirth = LocalDate.parse(dob,format);
				dob = scr.nextLine();
				

				
				System.out.println("Enter your Email ID");
					email = scr.next();
					while(!ApplicantServiceImpl.emailValidation(email))
					{
						System.err.println("Enter your Email ID in correct format");
						email = scr.next();
						
					}
					
					
					System.out.println("Enter your Highest Qualification");
					do
					{
					highestQualification =scr.nextLine();
					flag = ApplicantServiceImpl.highestqualification(highestQualification);
					if(flag==false) {
						System.err.println("Length should be less than 10");
					}
					}while(flag==false);
					
					
					
					System.out.println("Enter your Marks");
					do
					{
						if(scr.hasNextDouble()) {
							marksObtained = scr.nextDouble();
							flag=true;
						}else {
							System.out.println("Enter the marks in the number");
							scr.next();
							flag=false;
						}
					}while(flag==false);
					
					
					
					
					System.out.println("Enter your Goals");
					do
					{
					goals =scr.nextLine();
					flag = ApplicantServiceImpl.goalsValidation(goals);
					if(flag==false) {
						System.err.println("Define Goals in less then 20 characters");
					}
					}while(flag==false);
					
					
					
					
					
					System.out.println("Please see below programs");
					programScheduled = appServices.showProgramScheduled();
					
					if(programScheduled.isEmpty()){
						System.out.println("No program Available");
//						continue;
					}
					
					for (ProgramScheduledBean pBean : programScheduled)
						{
							System.out.println(pBean);
						}
					
					String scheduledProgramId = null;
					IMacService macservice = new MacServiceImpl();
					System.out.println("Enter program scheduled ID from the above table");
					flag1=false;
					
					do
					{
						scheduledProgramId = scr.next();
						flag = MacServiceImpl.validateScheduledId(scheduledProgramId);
						if(!flag) {
							System.out.println("Scheduled ID should be in number and less than 5 digit");
							flag=true;
						}else {
							List<String> clist = macservice.getScheduleId();
							if(clist.contains(scheduledProgramId )) {
								flag=false;
								flag1=true;
							}else {
								System.out.println("No such ID found");
								System.out.println("Press 1 to enter other Id otherwise press any key");
								if("1".equals(scr.next())) {
									flag= true;
									System.out.println("Enter program scheduled ID from the above table");
								}else 
									flag=false;
							}
						}	
							
						}while(flag=false);
						if(!flag1) 
						break;	
						
					
						
						ApplicationBean applicationbean = new ApplicationBean();
						applicationbean.setFullName(fname);
						applicationbean.setDateOfBirth(dateOfBirth);
						applicationbean.setEmailId(email); 
						applicationbean.setHighestQualification(highestQualification);
						applicationbean.setMarksObtained(marksObtained);
						applicationbean.setGoals(goals);
						applicationbean.setScheduledProgramId(scheduledProgramId);
						dateOfInterview = LocalDate.parse("2020-12-12");
						applicationbean.setDateOfInterview(dateOfInterview);
						applicationId=appServices.addDetail(applicationbean);
						System.out.println("Successfully applied. Your Application Id is :" +applicationId);
				break;
					
					
							
					
						
						case 3:
							do {
							System.out.println("Enter your Application Id");
							try
							{
								applicationId = scr.nextInt();
								applicationbean = appServices.showStatus(applicationId);
								if(applicationbean!=null) {
									flag1 = true;
									LocalDate checkDoi = LocalDate.parse("2021-05-01");
									if(applicationbean.getDateOfInterview().equals(checkDoi)) {
										System.out.println("Status:" +applicationbean.getStatus());
									}else
									{
										System.out.println("Status:"+applicationbean.getStatus());
										System.out.println("Date of Interview :" +applicationbean.getDateOfInterview());
									}
								}else {
									flag1=true;
									System.out.println("Data not found");
								}
								
								
							}catch(Exception e) {
								flag1=false;
								System.out.println("Value should be in integer and length should be less than 10" );
								scr.hasNextLine();
							}
							
							
					}while(flag1==false);
					break;
					
					
					
					
						default :	
						
							if(choice!=4) {
								if(choice<1  || choice>4) {
									System.out.println("Please enter a Valid Number");
								}
								System.out.println("Do You Want to continue : \nPress 1  to continue\nAny Other key to exit ");
								String decision = scr.next();
								if(!("1".equals(decision))) {
									System.out.println("Successfully Logged Out.\\n Thanks For Visting...");
									choice=4;
								}
								
							}else 
								System.out.println("Successfully Logged Out.\n Thanks For Visting");
							break;
		
					
					
			
		}
	while(choice!=4);
	
	

}
}

	
	
					

	

					
				
				
				
					
				
				
			
	

		
			