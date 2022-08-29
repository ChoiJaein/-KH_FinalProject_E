package com.myweb.home.member.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myweb.home.member.service.MemberService;
import com.myweb.home.member.vo.MemberVO;

@Controller
@RequestMapping("/member")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService service;
	
	// 회원가입 get. 회원가입 폼으로 이동하면 GET메소드
	@GetMapping(value="/register")
	public void getRegister() throws Exception {
		logger.info("get register");
	}
	
	// 회원가입 post. 회원가입 버튼 누르면 POST메소드
	@PostMapping(value="/register")
	public String postRegister(MemberVO vo) throws Exception {
		logger.info("post register");
		
		service.register(vo);
		
		return null;
	}
}
