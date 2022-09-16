package com.myweb.home.board.vo;
 
public class BoardVO {
	private int bid;
	private String btitle;
	private String bcontent;
	private int categoryid;
	private String dealmethod;
	private int price;
	private String pcondition;
	private String buystatus;
	
	public int getBid() {
		return bid;
	}
	
	public void setBid(int bid) {
		this.bid = bid;
	}
	
	public String getBtitle() {
		return btitle;
	}
	
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	
	public String getBcontent() {
		return bcontent;
	}
	
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	
	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getDealmethod() {
		return dealmethod;
	}

	public void setDealmethod(String dealmethod) {
		this.dealmethod = dealmethod;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPcondition() {
		return pcondition;
	}

	public void setPcondition(String pcondition) {
		this.pcondition = pcondition;
	}

	public String getBuystatus() {
		return buystatus;
	}

	public void setBuystatus(String buystatus) {
		this.buystatus = buystatus;
	}

	@Override
	public String toString() {
		return "BoardVO [bid=" + bid + ", btitle=" + btitle + ", bcontent=" + bcontent + ", categoryid=" + categoryid
				+ ", dealmethod=" + dealmethod + ", price=" + price + ", pcondition=" + pcondition + ", buystatus="
				+ buystatus + "]";
	}

}


