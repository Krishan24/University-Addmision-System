package com.cg.UniversityAdmissionSystem.service;

import java.util.List;

import com.cg.UniversityAdmissionSystem.bean.Student;

public interface IAdministrationService {
	public void updateProgram(String program);
	public void addProgrma(String pogram);
	public void deleteProgram(String program);
	public void addschedulesProgram();
	public void deleteScheduleProgram();
	public List<Student> viewConfirmedApplicants();

}
