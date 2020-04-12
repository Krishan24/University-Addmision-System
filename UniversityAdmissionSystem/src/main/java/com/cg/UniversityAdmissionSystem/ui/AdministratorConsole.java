package com.cg.UniversityAdmissionSystem.ui;

import java.util.Scanner;

import com.cg.UniversityAdmissionSystem.service.AdminServiceImpl;
import com.cg.UniversityAdmissionSystem.service.IAdminService;
import com.cg.UniversityAdmissionSystem.service.IMacService;
import com.cg.UniversityAdmissionSystem.service.MacServiceImpl;

public class AdministratorConsole {
	
	String userName;
	IAdminService service;
	IMacService macService=new MacServiceImpl();
	
	public AdministratorConsole(String userName) {
		super();
		this.userName = userName;
	}
	public void start()
	{
		int choice=-1;
		String scheduledProgramId;
		service = new AdminServiceImpl();
		Scanner sc;
		sc = new Scanner(System.in);
		System.out.println("Welcome "+userName);
		System.out.println("Choose an operation");
		System.out.println("test");
	}
	
	

}
