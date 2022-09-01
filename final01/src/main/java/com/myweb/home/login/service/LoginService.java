package com.myweb.home.login.service;


import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.home.login.model.AccountDTO;
import com.myweb.home.login.model.LoginDAO;
import com.myweb.home.login.vo.LoginVO;

@Service
public class LoginService {

	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);
	
	@Autowired
	 private LoginDAO dao;
	 
	 public boolean getLogin(HttpSession session, LoginVO loginVo) {
		 
		logger.info("getLogin({},{}",session, loginVo);
		 AccountDTO data = new AccountDTO();
		 data.setAccountId(loginVo.getAccountId());
		 data.setPassword(loginVo.getPassword());
		 
		 data = dao.selectLogin(data);
		 
		 if(data != null) {
			 session.setAttribute("loginData", data);
			 return true;
			
		 } else {
			 return false;
		     
		 }
		 
	 }
	

	public boolean find_id(HttpSession session, String email) {
		logger.info("find_id({})", email);
		 AccountDTO data = new AccountDTO();
		 data.setEmail(email);
		
		 
		 data = dao.find_id(email);
		 if(data == null) {
			 
			 return false;
			
		 } else {
			 session.setAttribute("emailData", data);
			 return true;
		 }
	} 
			
		     
		
	}


	

	

