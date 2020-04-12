package com.cg.UniversityAdmissionSystem.bean;

public class ParticipantBean {

	private String rollNo;
	private String emailId;
	private String applicationId;
	private String scheduledProgramId;

	public ParticipantBean() {

	}

	public ParticipantBean(String rollNo, String emailId, String applicationId, String scheduledProgramId) {
		super();
		this.rollNo = rollNo;
		this.emailId = emailId;
		applicationId = applicationId;
		this.scheduledProgramId = scheduledProgramId;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		applicationId = applicationId;
	}

	public String getScheduledProgramId() {
		return scheduledProgramId;
	}

	public void setScheduledProgramId(String scheduledProgramId) {
		this.scheduledProgramId = scheduledProgramId;
	}

	@Override
	public String toString() {
		return "Participant [rollNo=" + rollNo + ", emailId=" + emailId + ", ApplicationId=" + applicationId
				+ ", scheduledProgramId=" + scheduledProgramId + "]";
	}

}