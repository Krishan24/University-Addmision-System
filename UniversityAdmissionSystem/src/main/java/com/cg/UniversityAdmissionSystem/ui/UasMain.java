package com.cg.UniversityAdmissionSystem.ui;

import java.util.Scanner;

import com.cg.UniversityAdmissionSystem.bean.UsersBean;

public class UasMain {

	public static void main(String[] args) {
		
		int choice = -1;
		String loginId;
		String password;
		
		Scanner scr = new Scanner(System.in);
		System.out.println("\n-----------Welcome to University Admission System----------");

		System.out.println("Please Choose an operation");
		
		do
		{
			System.out.println("1.Enter as a Administrator");
			System.out.println("2. Enter as a Member Of Admission Committee");
			System.out.println("3. Enter as a Applicant");
			System.out.println("4. Exit");
			System.out.println("--------------------------------------------");
			System.out.println("\n Please Enter a choice : ");
			if(scr.hasNextInt()) {
				choice = scr.nextInt();
			}
			else {
				System.out.println("Please Enter a number as in menu");
				scr.hasNext();
				continue;
			}
			

			switch(choice)
			{
			
			
			case 1:
				
						System.out.println("Enter User Name : ");
						loginId = scr.next();
						System.out.println("Enter Password : ");
						password = scr.next();
						UsersBean userBeanMain = new UsersBean(loginId, password,"admin");
						
						AdministratorConsole admin=new AdministratorConsole(loginId);
						admin.start();
						break;
						
			case 2:
						System.out.println("Enter User Name ");
						loginId = scr.next();
						System.out.println("Enter Password ");
						password = scr.next();
						break;
						
			case 3:
				
						System.out.println("Welcome to University Admission System");
						break;
						
			case 4:
				
						System.out.println("Thanks for visiting!!!");
						StudentConsole sc = new StudentConsole();
						break;
						
			}
		}
		
	while(choice!=4);
	scr.close();
	
}
}
				
				
			
			
			
		
		
		
		
		


