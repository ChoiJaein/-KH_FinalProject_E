package com.myweb.home.login.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myweb.home.login.vo.LoginVO;
import com.myweb.home.login.model.AccountDTO;
import com.myweb.home.login.service.LoginService;





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
	
    //아이디,비밀번호 찾기 폼으로 이동
	@RequestMapping(value = "/login/findIdPwForm", method =RequestMethod.GET)
	public String findIdPwForm() throws Exception {
		return "/login/findIdPwForm";
	}

	/*
	//아이디찾기
	@RequestMapping(value = "/login/findIdPwForm", method =RequestMethod.POST)
		public ModelAndView findId(HttpServletRequest request, @RequestParam String mem_email)throws IOException  {
				
				ModelAndView mav = new ModelAndView(); 
				
				//이메일로 memberDTO값 전체 가져오기. 아이디 찾기는 이메일(unique)를 통해서만 이루어진다. 
				AccountDTO accountDTO= LoginService.findId(mem_email);
				
				if(accountDTO == null) {//해당 이메일이 없을 경우(가입되지 않은 회원일 경우)
					mav.addObject("findId", null);
					mav.setViewName("jsonView"); //findId에 null을 담아 페이지로 이동(페이지에서 '등록되지 않은 이메일~' div 경고창 뜬다)
				}else {
					//이메일 확인 후, 해당 이메일로 메일 발송
					String findId= memberDTO.getMem_id();
					
					String sender = "brighthannah12@gmail.com";
					String recipient = mem_email;
					String title = "▣ 아나바다 마켓 :: 아이디를 확인하세요 ▣";
					String content = System.getProperty("line.separator")
									+ System.getProperty("line.separator")
				                    + "안녕하세요. 아나바다 마켓 아이디 찾기 서비스 확인 메일입니다."
				                    + System.getProperty("line.separator")
				                    + System.getProperty("line.separator")
				                    + "고객님의 아이디는 '" +findId+ "'입니다. "
				                    + System.getProperty("line.separator")
				                    + System.getProperty("line.separator")
				                    + "이용해주셔서 감사합니다."; 
					try {
			            MimeMessage message = mailSender.createMimeMessage();
			            MimeMessageHelper messageHelper = new MimeMessageHelper(message,true, "UTF-8");
		//	            																↑멀티파트 형식으로 보낸다
		
			            messageHelper.setFrom(sender); // 보내는사람. 생략하면 정상작동을 안함
			            messageHelper.setTo(recipient); // 받는사람 이메일
			            messageHelper.setSubject(title); // 메일제목. (생략가능)
			            messageHelper.setText(content); // 메일 내용
			            
			            mailSender.send(message);
			        } catch (Exception e) {
			            System.out.println(e);
			        }
					
			        mav.addObject("findId", findId);
			        mav.setViewName("jsonView");
				}
		        return mav;
		        */
		}
