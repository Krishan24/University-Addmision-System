package com.cg.UniversityAdmissionSystem.bean;

public class ProgramOffered 
{
	private String programName;
	private String description;
	private String applicantEligibility;
	
	public ProgramOffered(String programName, String description,String applicantEligibility)
	{
		super();
		this.programName = programName;
		this.description = description;
		this.applicantEligibility = applicantEligibility;
	}
	
	
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getApplicantEligibility() {
		return applicantEligibility;
	}
	
	public void setApplicantEligibility(String applicantEligibility) {
		this.applicantEligibility = applicantEligibility;
	}
	
	@Override
	public String toString() {
		return "ProgramOffered [programName=" + programName + ", description=" + description + ", applicantEligibility="
				+ applicantEligibility + "]";
	}
}