package com.cg.UniversityAdmissionSystem.dao;

import com.cg.UniversityAdmissionSystem.bean.UsersBean;

public interface IUserDao
{
	
	public UsersBean getUserOnId(String loginId);

}
