package com.myweb.home.member.vo;

public class MemberVO {

	private String accountid;
	private String password;
	private String name;
	private String email;
	private String phone;
	private String address;
	
	public MemberVO() {
		
	}
	
	public MemberVO(String accountid, String password, String name, String email, String phone, String address) {
		super();
		this.accountid = accountid;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

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
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "MemberVO [accountid=" + accountid + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", address=" + address + ", phone=" + phone + "]";
	}
	
}
