package com.cg.UniversityAdmissionSystem.ui;
import com.cg.UniversityAdmissionSystem.bean.ProgramScheduledBean;
import com.cg.UniversityAdmissionSystem.service.ApplicantServiceImpl;
import com.cg.UniversityAdmissionSystem.service.IApplicanttService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;



public class StudentConsole {
	private static IApplicanttService appServices;
	private static DateTimeFormatter format;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fname,lname,dob, FatherName,email,num = null;
		int num1;
		boolean flag = true;
		LocalDate dateOfBirth=null;
		double SSCMarks = 0.0;
		double HSCMarks = 0.0;
		
		int choice = -1;
		
		Scanner scr = new Scanner(System.in);
		System.out.println("Choose an operation");
		
			
				System.out.println("1. Program Scheduled");
				System.out.println("2. Apply Online");
				System.out.println("3. Application Status");
				System.out.println("4. Exit");
				System.out.println("---------------------------");
				System.out.print("\nPlease Enter a Choice : ");
				if(scr.hasNextInt()) {
					choice = scr.nextInt();
				}
				else {
					System.out.println("Please Enter a number as in menu");
					scr.hasNext();
				}
				List<ProgramScheduledBean> programScheduled = null;
				switch(choice)
				{
				case 1:	
					programScheduled = appServices.showProgramScheduled();
			    for (ProgramScheduledBean pBean : programScheduled) {
					System.out.println(pBean);
			    }
					break;
					
				case 2:
					 fname = scr.nextLine();
					
				do
				{
					System.out.println("Enter your First Name as per the 10th Marksheet ");
					fname = scr.nextLine();
					flag = ApplicantServiceImpl.firstNameValidation(fname);
					if(flag==false){
						System.out.println("Name should be entered less than 20 character and first letter is capital");
					}
				}while(flag==false);
				
				
//				lname = scr.nextLine();
				do
				{
					System.out.println("Enter your Last Name as per the 10th Marksheet ");
					lname = scr.next();
					flag = ApplicantServiceImpl.lastNameValidation(lname);
					if(flag==false){
						System.out.println("Name should be entered less than 20 character and first letter is capital");
					}
				}while(flag==false);
				
				do
				{
					System.out.println("Enter Date Of Birth e.g(16/Dec/1995)");
					dob = scr.next();
					flag = ApplicantServiceImpl.dateOfBirthValidation(dob);
					if(flag==false){
						System.out.println(" Please enter the Date Of Birth in given Format");
					}
				}while(flag==false);
				
				format = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
				dateOfBirth = LocalDate.parse(dob,format);
				dob = scr.nextLine();
				
				do
				{
					System.out.println("Enter your Father Name as per the 10th Marksheet ");
					FatherName = scr.next();
					flag = ApplicantServiceImpl.fatherNameValidation(FatherName);
					if(flag==false){
						System.out.println("Name should be entered less than 20 character and first letter is capital");
					}
				}while(flag==false);
				
				
				
				
					System.out.println("Enter your Email ID");
					email = scr.next();
					while(!ApplicantServiceImpl.emailValidation(email)){
						System.err.println("Enter your Email ID in correct format");
						email = scr.next();
						
					}
					
					
					do
					{
						System.out.println("Enter your Mobile Number");
						num = scr.next();
						flag = ApplicantServiceImpl.mobileNumberValidation(num);
						if(flag==false) {
						
							System.err.println("Enter correct phone number");
						}
							
						}while(flag==false);
						
					
					
					num1 = Integer.parseInt(num);
					num = scr.nextLine();
					
					
					System.out.println("Enter you SSC Marks");
					do
					{
						if(scr.hasNextDouble()) {
							SSCMarks = scr.nextDouble();
							flag=true;
						}else {
							System.out.println("Please enter a marks in number");
							scr.next();
							flag=false;
							
							
						}
					}while(flag==false);
					
					
					System.out.println("Enter you HSC Marks");
					do
					{
						if(scr.hasNextDouble()) {
							HSCMarks = scr.nextDouble();
							flag=true;
						}else {
							System.out.println("Please enter a marks in number");
							scr.next();
							flag=false;
							
							
						}
					}while(flag==false);
					
					
					
					System.out.println("Please see below programs");
					programScheduled = appServices.showProgramScheduled();
					
					if(programScheduled.isEmpty()){
						System.out.println("No program Available");
						continue;
					}
						for (ProgramScheduledBean pBean : programScheduled) {
							System.out.println(pBean);
					}
					
					
					
					
					
					
					
				
					
				
					
				
				
					
				
						
						
					
					
				
				
				
				}
				
	
	
	}
	

	

					
				
				
				
					
				
				
			
	

		
			