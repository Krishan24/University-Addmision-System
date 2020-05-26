package com.cg.UniversityAdmissionSystem.exception;

public class NoProgramsAvailableException extends Exception {
	

	@Override
	public String getMessage() {
		return ExceptionDetail.getExceptionDetail("NoProgramsAvailableException");
	}
	

}
