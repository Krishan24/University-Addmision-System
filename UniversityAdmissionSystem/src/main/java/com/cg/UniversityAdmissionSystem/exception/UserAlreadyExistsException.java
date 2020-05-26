package com.cg.UniversityAdmissionSystem.exception;

public class UserAlreadyExistsException extends Exception {

	
	@Override
	public String getMessage() {
		return ExceptionDetail.getExceptionDetail("UserAlreadyExistsException");
	}
}
