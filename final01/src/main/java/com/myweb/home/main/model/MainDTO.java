package com.myweb.home.main.model;

import java.sql.Date;

public class MainDTO {
	
	private int bId;
	private String bTitle;
	private int price;
	private String dealMethod;
	private Date createDate;
	private String url;
	
	public int getbId() {
		return bId;
	}
	
	public void setbId(int bId) {
		this.bId = bId;
	}
	
	public String getbTitle() {
		return bTitle;
	}
	
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getDealMethod() {
		return dealMethod;
	}
	
	public void setDealMethod(String dealMethod) {
		this.dealMethod = dealMethod;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "MainDTO [bId=" + bId + ", bTitle=" + bTitle + ", price=" + price + ", dealMethod=" + dealMethod
				+ ", createDate=" + createDate + ", url=" + url + "]";
	}
	
	
	

}
