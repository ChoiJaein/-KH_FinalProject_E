package com.myweb.home.login.model;

public class AccountDTO {

	private String accountid;
	private String password;
	private String name;
	private String email;
	private String address;
	private String phone;
	private String birth;
	private String admin;
	private String filename;
	private String location;
	private String url;
	
	
	
	public String getaccountid() {
		return accountid;
	}
	public void setaccountid(String accountid) {
		this.accountid = accountid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
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
	
	@Override
	public String toString() {
		return "AccountDTO [accountid=" + accountid + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", address=" + address + ", phone=" + phone + ", birth=" + birth + ", admin=" + admin + ", filename="
				+ filename + ", location=" + location + ", url=" + url + "]";
	}
	
	
}
