package com.cg.UniversityAdmissionSystem.service;

import java.util.List;

import com.cg.UniversityAdmissionSystem.bean.ApplicationBean;
import com.cg.UniversityAdmissionSystem.bean.ProgramScheduledBean;

public interface IApplicanttService  
{

	public List<ProgramScheduledBean> showProgramScheduled();
	public int addDetail(ApplicationBean ab);
	public ApplicationBean showStatus(int applicationId);
}
