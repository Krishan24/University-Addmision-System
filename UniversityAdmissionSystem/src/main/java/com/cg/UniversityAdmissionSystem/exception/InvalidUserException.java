package com.cg.UniversityAdmissionSystem.exception;

public class InvalidUserException extends Exception {
	
	
	@Override
	public String getMessage() {
		return ExceptionDetail.getExceptionDetail("InvalidUserException");
	}

}
