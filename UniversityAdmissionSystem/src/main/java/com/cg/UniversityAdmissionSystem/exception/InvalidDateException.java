package com.cg.UniversityAdmissionSystem.exception;

public class InvalidDateException extends Exception {
	
	@Override
	public String getMessage() {
		return ExceptionDetail.getExceptionDetail("InvalidDateException");
	}

}
