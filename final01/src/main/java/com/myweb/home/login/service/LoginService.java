package com.myweb.home.login.service;


import java.io.PrintWriter;
import java.util.List;
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
public class LoginService<accountDTO> {

	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);
	
	@Autowired
	 private LoginDAO dao;
	 
	 public boolean getLogin(HttpSession session, LoginVO loginVo) {
		 
		logger.info("getLogin({},{}",session, loginVo);
		 AccountDTO data = new AccountDTO();
		 data.setaccountid(loginVo.getAccountid());
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
			
	


	//public  boolean find_pw(HttpSession session, LoginVO loginVo){
		
		public AccountDTO find_pw(HttpSession session, Map<String, String> map) {
			//map: 아이디, 이메일
			logger.info("find_id({},{})",map);
			AccountDTO data = new AccountDTO();
			data.setaccountid(data.getaccountid());
			data.setEmail(data.getEmail());
				
			
			if(data != null) {//가입되지 않은 정보
				session.setAttribute("passwordData", data);
				return data;
			} else {
				return null;
			}
	}
		/*
		logger.info("find_pw({},{})",session ,loginVo);
		 AccountDTO data = new AccountDTO();
		
		 data.setAccountId(loginVo.getAccountId());
		 data.setEmail(loginVo.getEmail());
		 
		 data = dao.selectLogin(data);
		 
		 if(data != null) {
			 session.setAttribute("passwordData", data);
			 System.out.println("data2222");	
			 return true;
		 } else {
			 return false;
		     
		 }
	
	}*/
		
}



	

	

