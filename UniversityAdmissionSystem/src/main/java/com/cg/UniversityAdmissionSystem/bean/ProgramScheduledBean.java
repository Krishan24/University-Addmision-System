package com.cg.UniversityAdmissionSystem.bean;

import java.time.LocalDate;
import java.util.Date;

public class ProgramScheduledBean 
{
	private String scheduledProgramId;
	private String programName;
	private String location;
	private Date startDate;
	private Date endDate;
	private int sessionsPerWeek;

	public ProgramScheduledBean() {

	}

	public ProgramScheduledBean(String scheduledProgramId, String programName, String location, Date startDate,
			Date endDate, int sessionsPerWeek) {
		super();
		this.scheduledProgramId = scheduledProgramId;
		this.programName = programName;
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
		this.sessionsPerWeek = sessionsPerWeek;
	}

	public String getScheduledProgramId() {
		return scheduledProgramId;
	}

	public void setScheduledProgramId(String scheduledProgramId) {
		this.scheduledProgramId = scheduledProgramId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date date2) {
		this.startDate = date2;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date date3) {
		this.endDate = date3;
	}

	public int getSessionsPerWeek() {
		return sessionsPerWeek;
	}

	public void setSessionsPerWeek(int sessionsPerWeek) {
		this.sessionsPerWeek = sessionsPerWeek;
	}

	@Override
	public String toString() {
		return "scheduledProgramId = " + scheduledProgramId + ", programName = " + programName + ", location = "
				+ location + ", startDate = " + startDate + ", endDate = " + endDate + ", sessionsPerWeek = "
				+ sessionsPerWeek;
	}

	public void setSessionPerWeek(int sessionPerWeek) {
		// TODO Auto-generated method stub
		
	}

}
