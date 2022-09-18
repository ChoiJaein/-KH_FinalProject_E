package com.myweb.home.info.model;


public class InfoDTO {
	
	private String accId;
	private String name;
	private String url;
	private int regDate;
	private String buyStatus;
	private int num;
	
	public String getAccId() {
		return accId;
	}
	
	public void setAccId(String accId) {
		this.accId = accId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public int getRegDate() {
		return regDate;
	}

	public void setRegDate(int regDate) {
		this.regDate = regDate;
	}
	
	public String getBuyStatus() {
		return buyStatus;
	}
	
	public void setBuyStatus(String buyStatus) {
		this.buyStatus = buyStatus;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "InfoDTO [accId=" + accId + ", name=" + name + ", url=" + url + ", buyStatus=" + buyStatus + ", num="
				+ num + "]";
	}
	
	

}
