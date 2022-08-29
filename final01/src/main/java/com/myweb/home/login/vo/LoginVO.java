package com.myweb.home.login.vo;

public class LoginVO {

	private String accountId;
	private String password;
	
	
	
	
	public String getAccountId() {
		return accountId;
	}




	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	@Override
	public String toString() {
		return "LoginVO [accountId=" + accountId + ", password=" + password + "]";
	}
	
	
	
	
}
