package com.myweb.home.board.model;

public class CategoryDTO {
	private String categoryid;
	private String categoryname;
	
	public String getCategoryid() {
		return categoryid;
	}
	
	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}
	
	public String getCategoryname() {
		return categoryname;
	}
	
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	@Override
	public String toString() {
		return "CategoryDTO [categoryid=" + categoryid + ", categoryname=" + categoryname + "]";
	}
	
}
