package com.cg.UniversityAdmissionSystem.exception;

public class  UpdateFailedException extends Exception {
	
	@Override
	public String getMessage() {
		return ExceptionDetail.getExceptionDetail("UpdateFailedException");
	}

}
