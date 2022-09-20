package com.myweb.home.upload.model;

public class PhotoUploadDTO {
	
	private int fileid;
	private int bid;
	private String accountid;
	private String uuidname;
	private String filename;
	private String location;
	private String url;
	private int filesize;
	private String filetype;
	
	public int getFileid() {
		return fileid;
	}
	
	public void setFileid(int fileid) {
		this.fileid = fileid;
	}
	
	public int getBid() {
		return bid;
	}
	
	public void setBid(int bid) {
		this.bid = bid;
	}
	
	public String getAccountid() {
		return accountid;
	}
	
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	
	public String getUuidname() {
		return uuidname;
	}
	
	public void setUuidname(String uuidname) {
		this.uuidname = uuidname;
	}
	
	public String getFilename() {
		return filename;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public int getFilesize() {
		return filesize;
	}
	
	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}
	
	public String getFiletype() {
		return filetype;
	}
	
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	@Override
	public String toString() {
		return "PhotoUploadDTO [fileid=" + fileid + ", bid=" + bid + ", accountid=" + accountid + ", uuidname="
				+ uuidname + ", filename=" + filename + ", location=" + location + ", url=" + url + ", filesize="
				+ filesize + ", filetype=" + filetype + "]";
	}
	
}
