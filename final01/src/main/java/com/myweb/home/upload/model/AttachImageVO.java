package com.myweb.home.upload.model;

public class AttachImageVO {
	
//	private int fileid;			// 순번. 시퀀스 이용.
	private String uploadPath;	// 경로
	private String fileName;	// 원래 파일 이름
	private String uuid;	// uuid로 변경한 이름
	private int accountid;		// 어느회원의 사진인지 구분하기 위함.
//	private String url;			// 업로드URL
//	private int filesize;
//	private String filetype;
	
	public String getUploadPath() {
		return uploadPath;
	}
	
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public int getAccountid() {
		return accountid;
	}
	
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	@Override
	public String toString() {
		return "AttachImageVO [uploadPath=" + uploadPath + ", fileName=" + fileName + ", uuid=" + uuid + ", accountid="
				+ accountid + "]";
	}
	
}
