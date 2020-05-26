package com.cg.UniversityAdmissionSystem.exception;

public class InvalidProgramException  extends Exception{
	

	@Override
	public String toString() {
		return "InvalidProgramException";
	}
	
	@Override
	public String getMessage() {
		return ExceptionDetail.getExceptionDetail("InvalidProgramException");
	}

}
