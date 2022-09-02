package com.myweb.home.member.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myweb.home.member.service.MemberService;
import com.myweb.home.member.vo.MemberVO;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService service;
	
	@GetMapping(value="/register")
	public String register(Model model) {
		logger.info("get register");
		return "login/register";
	}
	
	@PostMapping(value="/register")	
	public String register(MemberVO vo) {
		logger.info("post register");
		service.register(vo);
		return "redirect:/";
	}

	// 아이디 중복확인 처리
	@PostMapping(value="/idOverlap")
	public void idOverlap(HttpServletResponse response, @RequestParam("accountid") String accountid) throws IOException {
		service.idOverlap(accountid, response);
	}
}
