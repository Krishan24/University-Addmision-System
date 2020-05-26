package com.cg.UniversityAdmissionSystem.service;

import com.cg.UniversityAdmissionSystem.exception.AuthenticationfailedException;

@FunctionalInterface
public interface ValidationService {

	
	
	boolean authenticate(String loginId,String password) throws AuthenticationfailedException;
}
