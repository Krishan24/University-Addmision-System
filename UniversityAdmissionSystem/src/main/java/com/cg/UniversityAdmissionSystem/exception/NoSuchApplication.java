package com.cg.UniversityAdmissionSystem.exception;

public class  NoSuchApplication extends Exception{
	
	@Override
	public String getMessage() {
		return ExceptionDetail.getExceptionDetail("NoSuchApplication");
	}

}
