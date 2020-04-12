package com.cg.UniversityAdmissionSystem.ui;
import com.cg.UniversityAdmissionSystem.bean.ApplicationBean;
import com.cg.UniversityAdmissionSystem.service.AdminServiceImpl;
import com.cg.UniversityAdmissionSystem.service.IMacService;
import com.cg.UniversityAdmissionSystem.service.MacServiceImpl;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class MAC_Console {

	private static String userName;
	private static IMacService macService;
	public static void main(String[] args) 
	{
		int choice= -1, applicationId;
		boolean flag;
		String scheduledProgramId, status;
		macService = new MacServiceImpl();
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome "+userName);
		System.out.println("Choose an operation:");
		do
		{
			System.out.println("1. View list of applicants of particular program scheduled for Interview");
			System.out.println("2. View list of applicants of particular program scheduled after Interview");
			System.out.println("3. Update status of applicant");
			System.out.println("4. Back to Home Page");
			System.out.println("Please Enter a Choice:");
			if (scan.hasNextInt())
			{
				choice = scan.nextInt();
			}
			else
			{
				System.out.println("Please enter a number as in menu");
				scan.next();
				continue;
			}
			List<ApplicationBean> applicantDetails = new ArrayList<ApplicationBean>();
			switch(choice) 
			{
			case 1:
				do
				{
					System.out.println("Enter Program Scheduled Id:");
					scheduledProgramId = scan.next();
					flag = MacServiceImpl.validateScheduledId(scheduledProgramId);
					if(flag==false)
					{
					System.err.println("Scheduled ID should be number and less than 5 digit.");
					}
					else
					{
					List<String> cList = macService.getScheduleId();
					if(cList.contains(scheduledProgramId))
                    {						
					  applicantDetails = macService.getApplicantOnScheduledId(scheduledProgramId);
						if(applicantDetails.isEmpty())
						{
							System.err.println("Sorry No Data Found!!");
									}
						else
						{
							for(ApplicationBean applicants : applicantDetails) 
							System.out.println(applicants);		
										}
									}
					else
					{
						System.err.println("No such Id found");
					}
					}
               System.out.println("To continue press 1 otherwise any other key");
				if("1".equals(scan.next())){
				flag=true;	
				}
				else	
					flag=false;
				}while(flag);
				break;
			case 2:
				do {
					System.out.println("Enter Program Scheduled Id:");
					scheduledProgramId = scan.next();
					flag = MacServiceImpl.validateScheduledId(scheduledProgramId);
					if(flag==false)
					{
					System.err.println("Scheduled ID should be number and less than 5 digit.");
					}
					else
					{
						List<String> cList = macService.getScheduleId();
						if(cList.contains(scheduledProgramId))
						{						
						applicantDetails = macService.getApplicantAfterInterviewOnId(scheduledProgramId);
						if(applicantDetails.isEmpty())
						{
						  System.err.println("Sorry No Data Found!!");
						}
						else
						{
						for (ApplicationBean applicants : applicantDetails) 
						System.out.println(applicants);		
						}
						}
						else
						{
						System.err.println("No such Id found");
							}
						}
						System.out.println("To continue press 1 otherwise any other key");
						if("1".equals(scan.next()))
						{
							flag=true;	
						}
						else	
						  flag=false;	
					
				}while(flag);
				break;
			case 3:
				do {
					System.out.println("Enter Applicant Id:"); 
					List<Integer> idList =macService.getApplicantId();
					System.out.println("Available Appicants Id "+idList);
					String applId = scan.next();
					flag = MacServiceImpl.validateScheduledId(applId);  
					if(flag==false)
					{
					System.err.println("Aplcation ID should be number and less than 5 digit");
						}
					else
					{
					applicationId=Integer.parseInt(applId);
					if(idList.contains(applicationId))
					{
					System.out.println("Enter Updated Status ");
						ArrayList<String> staustList=new ArrayList<String>();
						staustList.add("accepted");
						staustList.add("rejected");
						staustList.add("confirmed");
						do
					{
						status = scan.next();
						if(staustList.contains(status))
					{
						flag=false;
					}
					else
					{
					System.err.println("Allowed status are : accepted, rejected, confirmed\nEnter Again: ");
							}
						}
					while(flag);
					status = macService.updateApplicantStatus(applicationId, status);
					System.out.println(status);
					if(status.equals("accepted"))
					{
					 System.out.println("Please Enter Date of Interview of Accepted Applicant(yyyy-MM-dd)");
					String date;
					flag=false;
					Date date2;
					do
					{
					date=scan.next();
					if(!AdminServiceImpl.validateDate(date))
					{
					flag=true;
					}
					DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDate date1 = LocalDate.parse(date,formatter);
					}while(flag);
					} }
					else
					{
					  System.err.println("No such Application id");
					}}
					System.out.println("To continue press 1 otherwise any other key");
						if("1".equals(scan.next())){
					flag=true;	
					}
					else	
					flag=false;
              }while(flag);
				break;
			default:
				if(choice!=4) 
				{
					if(choice<1 || choice>4) 
					{
						System.err.println("No such choice");
					}
					System.out.println("Do You Want to continue : \nPress 1  to continue\nAny Other key to exit ");
					String decision = scan.next();
					if(!("1".equals(decision)))
					{
						System.out.println("Successfully Logged Out.\\nThanks For Visiting MacServices..");
						choice=4;
					}
				}
				else
					System.out.println("Successfully Logged Out.\nThanks For Visiting MacServices..");
				break;

			}


		}while(choice!=4);
	}
}
