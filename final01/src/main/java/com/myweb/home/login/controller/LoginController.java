package com.myweb.home.login.controller;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myweb.home.login.model.AccountDTO;
import com.myweb.home.login.service.LoginService;
import com.myweb.home.login.vo.LoginVO;





@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService service;
	
	@GetMapping(value="/login")
	public String login(Model model) {
		return "login/login";
		
	}
	
	

	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(LoginVO loginVo
			, HttpServletRequest request
			, HttpSession session) {
	
		logger.info("login({},{})",loginVo.getAccountId(), loginVo.getPassword());
		boolean result = service.getLogin(session,loginVo);
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("login");
		
		   if(result) {
			   //성공
			  
			   return "redirect:/";
		   } else {
			   //실패
			  
			   return"login/login";
		   }
	       }

	   

	
	
	//로그아웃
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
	
    //아이디 찾기 폼으로 이동
	@GetMapping(value = "/login/idfindform")
	public String idfindform() throws Exception {
		return "/login/idfindform";
	}
	
	
	
	//아이디 찾기 성공
	@RequestMapping(value = "/login/find_id" , method = RequestMethod.GET)
	public String find_id() throws Exception{
		return "/login/find_id";
	}
	
	//아이디 찾기 성공
	@RequestMapping(value = "/login/find_id", method =RequestMethod.POST)
	
	public String find_id(String email
			, HttpServletRequest request
			, HttpSession session) {
		
		logger.info("find_id({})",email);
		
		
		boolean result = service.find_id(session,email);
		
		if(result) {
			//성공 
			return "/login/find_id";
		} else {
			//실패
			
			return"login/login";
		}
	}
	
	//비밀번호 찾기 폼으로 이동
	@RequestMapping(value = "/login/pwfindform", method =RequestMethod.GET)
	public String pwfindform() throws Exception {
		return "/login/pwfindform";
	}
	
		
		
	
		
}
