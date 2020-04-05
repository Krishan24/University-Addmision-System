package com.cg.UniversityAdmissionSystem.service;

import java.util.List;

import com.cg.UniversityAdmissionSystem.bean.Student;

public interface IStudentService  
{

	public List<String> listOfAllPrograms();
	public Student applyForprogram(String program);
	
	public Student viewApplication(int applicationid);

}
