package com.cg.UniversityAdmissionSystem.exception;

public class ProgramAlreadyExistsException extends Exception {
	
	@Override
	public String getMessage() {
		return ExceptionDetail.getExceptionDetail("ProgramAlreadyExistsException");
	}

}
