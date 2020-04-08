package com.cg.UniversityAdmissionSystem.bean;

public class ParticipantBean {

	private int applicationId;
	private String emailId;
	private String scheduledProgramId;
	
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getScheduledProgramId() {
		return scheduledProgramId;
	}
	public void setScheduledProgramId(String scheduledProgramId) {
		this.scheduledProgramId = scheduledProgramId;
	}
	@Override
	public String toString() {
		return "Participant [applicationId=" + applicationId + ", emailId=" + emailId + ", scheduledProgramId="
				+ scheduledProgramId + "]";
	}
	
	
}
