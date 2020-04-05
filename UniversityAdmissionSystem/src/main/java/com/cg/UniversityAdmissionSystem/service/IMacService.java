package com.cg.UniversityAdmissionSystem.service;

import java.util.List;

import com.cg.UniversityAdmissionSystem.bean.Student;

public interface IMacService {

		public List<String> viewAllAplicationsOfSpecPro(String program);
		public boolean updateApplication(Student stu);
		public void updateApplicationStatus();
		
}
