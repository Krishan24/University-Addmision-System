package com.cg.UniversityAdmissionSystem.dao;

import com.cg.UniversityAdmissionSystem.bean.Student;

public interface IStudentDao 
{
	public int addDetail(Student ab);
	public Student showStatus(int applicationId);

}
