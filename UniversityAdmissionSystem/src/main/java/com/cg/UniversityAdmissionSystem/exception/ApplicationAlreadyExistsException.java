package com.cg.UniversityAdmissionSystem.exception;

public class ApplicationAlreadyExistsException extends Exception{
	
	@Override
	public String getMessage() {
		return ExceptionDetail.getExceptionDetail("ApplicationAlreadyexistsException");
	}

}
