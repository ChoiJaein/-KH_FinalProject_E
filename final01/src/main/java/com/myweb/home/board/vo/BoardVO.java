package com.myweb.home.board.vo;

public class BoardVO {
	private int bid;
	private String btitle;
	private String bcontent;
	
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
	
	@Override
	public String toString() {
		return "BoardVO [bid=" + bid + ", btitle=" + btitle + ", bcontent=" + bcontent + "]";
	}

}


