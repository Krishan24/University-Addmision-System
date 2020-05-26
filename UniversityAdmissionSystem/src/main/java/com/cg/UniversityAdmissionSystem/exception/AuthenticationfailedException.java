package com.cg.UniversityAdmissionSystem.exception;

public class AuthenticationfailedException extends Exception{
	
	public String getMessage() {
		return ExceptionDetail.getExceptionDetail("AuthenticationfailedException");
	}

}
