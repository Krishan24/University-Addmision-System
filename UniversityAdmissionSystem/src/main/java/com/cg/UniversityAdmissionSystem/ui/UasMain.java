package com.cg.UniversityAdmissionSystem.ui;

import java.util.Scanner;

public class UasMain {

	public static void main(String[] args) {
		
		Scanner scr = new Scanner(System.in);
		System.out.println("-----------Welcome to University Admission System----------");
//		System.out.println("Following Courses are as follows:1.B.Tech 2.BBA 3.BCA 4.MBA ");
		System.out.println("Please Chhose the Offered Programs:- \n"+"1.B.Tech \n" + "2.BBA \n" +"3.BCA \n" + "4.MBA \n" +"5.Exit");
		int option = scr.nextInt();
		
		switch(option)
		{
		case 1:System.out.println("Online Application form for B.Tech");
		       System.out.println("Please enter the First Name");
		       String fname = scr.next();
		       System.out.println("Please enter the Last Name");
		       String lname = scr.next();
		       System.out.println("Please enter the DOB");
		       String dob = scr.next();
		       System.out.println("Please enter the Father Name");
		       String fathername = scr.next();
		       System.out.println("Please enter the Email");
		       String email = scr.next();
		       System.out.println("Please enter the Mobile Number");
		       long mobnum = scr.nextLong();
		       System.out.println("Please enter the SSC Marks");
		       double ssc = scr.nextDouble();
		       System.out.println("Please enter the HSC Marks");
		       double hsc = scr.nextDouble();
		       System.out.println("Successfully Submit the Form");
		       break;
		       
		case 2: System.out.println("Online Application form for BBA");
	       		System.out.println("Please enter the First Name");
	       		String fname1 = scr.next();
	       		System.out.println("Please enter the Last Name");
	       		String lname1 = scr.next();
	       		System.out.println("Please enter the DOB");
	       		String dob1 = scr.next();
	       		System.out.println("Please enter the Father Name");
	       		String fathername1 = scr.next();
	       		System.out.println("Please enter the Email");
	       		String email1 = scr.next();
	       		System.out.println("Please enter the Mobile Number");
	       		long mobnum1 = scr.nextLong();
	       		System.out.println("Please enter the SSC Marks");
	       		double ssc1= scr.nextDouble();
	       		System.out.println("Please enter the HSC Marks");
	       		double hsc1 = scr.nextDouble();
	       		System.out.println("Successfully Submit the Form");
	       		break;
	       		
		case 3: System.out.println("Online Application form for BCA");
		   		System.out.println("Please enter the First Name");
		   		String fname2 = scr.next();
		   		System.out.println("Please enter the Last Name");
		   		String lname2 = scr.next();
		   		System.out.println("Please enter the DOB");
		   		String dob2 = scr.next();
		   		System.out.println("Please enter the Father Name");
		   		String fathername2 = scr.next();
		   		System.out.println("Please enter the Email");
		   		String email2 = scr.next();
		   		System.out.println("Please enter the Mobile Number");
		   		long mobnum2 = scr.nextLong();
		   		System.out.println("Please enter the SSC Marks");
		   		double ssc2= scr.nextDouble();
		   		System.out.println("Please enter the HSC Marks");
		   		double hsc2 = scr.nextDouble();
		   		System.out.println("Successfully Submit the Form");
		   		break;
		   		
		case 4: System.out.println("Online Application form for MBA");
		   		System.out.println("Please enter the First Name");
		   		String fname3 = scr.next();
		   		System.out.println("Please enter the Last Name");
		   		String lname3 = scr.next();
		   		System.out.println("Please enter the DOB");
		   		String dob3 = scr.next();
		   		System.out.println("Please enter the Father Name");
		   		String fathername3 = scr.next();
		   		System.out.println("Please enter the Email");
		   		String email3 = scr.next();
		   		System.out.println("Please enter the Mobile Number");
		   		long mobnum3 = scr.nextLong();
		   		System.out.println("Please enter the SSC Marks");
		   		double ssc3= scr.nextDouble();
		   		System.out.println("Please enter the HSC Marks");
		   		double hsc3 = scr.nextDouble();
		   		System.out.println("Successfully Submit the Form");
		   		break; 
		   		
		   		
		case 5: System.out.println("Thank You For Visiting");
			System.exit(0);
			
			
			
	           
		       
		}
		
	}

}
