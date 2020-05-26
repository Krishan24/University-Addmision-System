package com.cg.UniversityAdmissionSystem.exception;

public class NoSuchParticipant extends Exception {

	
	@Override
	public String getMessage() {
		return ExceptionDetail.getExceptionDetail("NoSuchParticipant");
	}
}
