package com.cg.UniversityAdmissionSystem.bean;

import java.util.Date;

public class ProgramScheduledBean 
{
	private String shProgramName;
	private String location;
	private Date startDate;
	private Date endDate;
	
	public String getShProgramName() {
		return shProgramName;
	}
	public void setShProgramName(String programName) {
		this.shProgramName = programName;
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
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "ScheduledProgram [programName=" + shProgramName + ", location=" + location + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
	
	

}
