package com.cg.UniversityAdmissionSystem.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.cg.UniversityAdmissionSystem.bean.ApplicationBean;
import com.cg.UniversityAdmissionSystem.exception.ApplicationAlreadyExistsException;
import com.cg.UniversityAdmissionSystem.exception.NoSuchApplication;

public class ApplicationDaoImpl implements IApplicationDao{
	
	private static HashMap<String, ApplicationBean> applications = new HashMap<String, ApplicationBean>();
	
	@Override
	public  ApplicationBean readApplication(String applicationId) throws NoSuchApplication{
		ApplicationBean ab = applications.get(applicationId);
		if(ab == null) {
			System.out.println("Application with id: " + applicationId + " was not found");
			throw new NoSuchApplication(); 
		}
		else {
			System.out.println("Application with id: " + applicationId + " was not found");
			return ab;
		}
	}
	
	@Override
	public ApplicationBean readApplicationByProgramId(String programId) throws NoSuchApplication{
		System.out.println("the id:"+ programId);
		for(ApplicationBean ab:applications.values()) {
			if(ab.getScheduledProgramId().equals(programId) && !ab.getStatus().equalsIgnoreCase("Confirmed")) {
				System.out.println("Application with program id: " + programId + " was read");
				return ab;
			}
			
		}
		System.out.println("Application with program id: " + programId + " was not found");
		throw new NoSuchApplication();
	}
	
	
	@Override
	public ArrayList<ApplicationBean> getAll(){
		List<ApplicationBean> result = applications.values().stream().collect(Collectors.toList());
		System.out.println(result.size()+"applications were read.");
		return new ArrayList<ApplicationBean>(result);
		
	}
	
	@Override
	public boolean createApplication(ApplicationBean ab) throws ApplicationAlreadyExistsException{
		ApplicationBean result = applications.putIfAbsent(ab.getApplicationId(),ab);
		if(result == null) {
			System.out.println("Application with id: " + ab.getApplicationId() + " was created");
			return true;
		}
		else {
			System.out.println("Application with id: " + result.getApplicationId() + " already exists");
			throw new ApplicationAlreadyExistsException();
		}
		
	}
	
	@Override
	public boolean updateApplication(String applicationId, ApplicationBean ab) throws NoSuchApplication{
		if(applications.containsKey(applicationId)) {
			ApplicationBean result = applications.put(applicationId, ab);
			if(result!= null) {
				System.out.println("Application with id: " + applicationId + " was updated ");
				
			}
			else {
				System.out.println("Application with id: " + applicationId + " was failed to be updated");
				return false;
			}
		}
			else {
				System.out.println("Application with id: " + applicationId + " not found");
				throw new NoSuchApplication();
				
			}
		return true;
		}
		
	@Override
	public boolean deleteApplication(String applicationId) throws NoSuchApplication{
		if(applications.containsKey(applicationId)) {
			ApplicationBean ab = applications.remove(applicationId);
			if(applications.containsKey(applicationId)) {
				System.out.println("Application: " + applicationId + " delete failed");
				return false;
			}
			else {
				System.out.println("Application: " + applicationId + " delete successful");
				return true;
			}
		}
			else {
				System.out.println("Application with id: " + applicationId + " was not found");
				throw new NoSuchApplication();
				
			}
		}
		
	public static void mockData() {
		applications.put("1", new ApplicationBean("1","Charul", LocalDate.parse("1997-07-25"),"12th",80,
				"Aim to be a Pilot","charul@gmail.com","A1001","Accepted", LocalDate.parse("2018-11-25")));
		
		applications.put("2", new ApplicationBean("2","Yash", LocalDate.parse("1997-08-12"),"12th",76,
				"Aim to be an Designer","yash@gmail.com","A1002","Accepted", LocalDate.parse("2018-11-25")));
		
		applications.put("3", new ApplicationBean("3","Krishan", LocalDate.parse("1997-05-15"),"12th",70,
				"Aim to be a Developer","Krishan@gmail.com","A1003","pending", LocalDate.parse("2018-11-25")));
		
		applications.put("4", new ApplicationBean("4","Pavini", LocalDate.parse("1997-09-16"),"12th",90,
				"Aim to be a Enineer","pavini@gmail.com","A1004","confirmed", LocalDate.parse("2018-11-25")));
		
	}
	
	public void print() {
		System.out.println(applications);
	}
	

}
