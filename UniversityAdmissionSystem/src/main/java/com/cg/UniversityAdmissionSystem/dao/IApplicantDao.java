package com.cg.UniversityAdmissionSystem.dao;

import java.util.List;

import com.cg.UniversityAdmissionSystem.bean.ApplicationBean;
import com.cg.UniversityAdmissionSystem.bean.ProgramScheduledBean;

public interface IApplicantDao 
{
	public int addDetail(ApplicationBean ab);
	public ApplicationBean showStatus(int applicationId);
	public List<ProgramScheduledBean> showProgramScheduled();
}
