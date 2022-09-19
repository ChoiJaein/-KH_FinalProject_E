package com.myweb.home.info.model;

import java.sql.Date;

public class ProfileStaticsDTO {
	
	private int profileId;
	private String accId;
	private int bId;
	private String visited;
	private Date latestVisit;
	
	public int getProfileId() {
		return profileId;
	}
	
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	
	public String getAccId() {
		return accId;
	}
	
	public void setAccId(String accId) {
		this.accId = accId;
	}
	
	public int getbId() {
		return bId;
	}
	
	public void setbId(int bId) {
		this.bId = bId;
	}
	
	public String getVisited() {
		return visited;
	}
	
	public void setVisited(String visited) {
		this.visited = visited;
	}
	
	public Date getLatestVisit() {
		return latestVisit;
	}
	
	public void setLatestVisit(Date latestVisit) {
		this.latestVisit = latestVisit;
	}
	
	

}
