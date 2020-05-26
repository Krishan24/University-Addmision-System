package com.cg.UniversityAdmissionSystem.dao;

import com.cg.UniversityAdmissionSystem.bean.UsersBean;
import com.cg.UniversityAdmissionSystem.exception.InvalidUserException;
import com.cg.UniversityAdmissionSystem.exception.UserAlreadyExistsException;

public interface IUserDao
{
	
	UsersBean readUser(String loginId) throws InvalidUserException;

	boolean createUser(UsersBean u) throws UserAlreadyExistsException;

	boolean updateUser(String loginId, UsersBean u) throws InvalidUserException;

	boolean deleteUser(String loginId) throws InvalidUserException;

}
