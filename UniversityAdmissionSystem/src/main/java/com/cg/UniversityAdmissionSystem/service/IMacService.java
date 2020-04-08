package com.cg.UniversityAdmissionSystem.service;

import java.util.List;

import com.cg.UniversityAdmissionSystem.bean.ApplicationBean;

public interface IMacService {

		public List<String> viewAllAplicationsOfSpecPro(String program);
		public boolean updateApplication(ApplicationBean stu);
		public void updateApplicationStatus();
		
}
