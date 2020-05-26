package com.cg.UniversityAdmissionSystem.dao;

import java.util.HashMap;

import com.cg.UniversityAdmissionSystem.bean.UsersBean;
import com.cg.UniversityAdmissionSystem.exception.InvalidUserException;
import com.cg.UniversityAdmissionSystem.exception.UserAlreadyExistsException;

public class UserDaoImpl  implements IUserDao
{
	
	private static HashMap<String, UsersBean> users = new HashMap<String, UsersBean>();

	@Override
	public UsersBean readUser(String loginId) throws InvalidUserException {
		UsersBean u = users.get(loginId);
		if (u != null) {
			//logger.info("User with id: " + loginId + " was found");
			return u;
		} else {
			//logger.info("User with id: " + loginId + " was not found");
			throw new InvalidUserException();
		}
	}

	@Override
	public boolean createUser(UsersBean u) throws UserAlreadyExistsException {
		UsersBean result = users.putIfAbsent(u.getLoginId(), u);
		if (result == null) {
			//logger.info("User with id: " + u.getLoginId() + " was created");
			return true;
		} else {
			//logger.info("User with id: " + u.getLoginId() + " already exists");
			throw new UserAlreadyExistsException();
		}
	}

	@Override
	public boolean updateUser(String loginId, UsersBean u) throws InvalidUserException {
		if (users.containsKey(loginId)) {
			//logger.info("User with id: " + loginId + " exists");
			UsersBean result = users.put(loginId, u);

			if (result != null) {
			//	logger.info("User with id: " + loginId + " update successfull");
				return true;
			} else {
			//	logger.info("User with id: " + loginId + " update unsuccessfull");
				return false;
			}
		} else {
			//logger.info("User with id: " + loginId + " doesn't exists");
			throw new InvalidUserException();
		}
	}

	@Override
	public boolean deleteUser(String loginId) throws InvalidUserException {
		UsersBean u = users.remove(loginId);
		if (u != null) {
			//logger.info("User with id: " + loginId + " deletion successfull");
			return true;
		} else {
			//logger.info("User with id: " + loginId + " doesn't exists");
			throw new InvalidUserException();
		}
	}
	
	
	public static void mockData() {
		users.put("user1", new UsersBean("user1", "Pass1", "mac"));
		users.put("user2", new UsersBean("user2", "Pass2", "mac"));
		users.put("user3", new UsersBean("user4", "Pass4", "admin"));
		users.put("user4", new UsersBean("user5", "Pass5", "admin"));

	}


}
