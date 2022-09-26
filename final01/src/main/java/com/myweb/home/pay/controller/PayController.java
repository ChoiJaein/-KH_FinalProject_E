package com.myweb.home.pay.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.home.board.service.BoardService;
import com.myweb.home.member.vo.MemberVO;
import com.myweb.home.upload.service.PhotoUploadService;

@Controller
public class PayController {
	
	private static final Logger logger = LoggerFactory.getLogger(PayController.class);

	@Autowired
	private BoardService service;
	
	@Autowired PhotoUploadService photoUploadService;
	
	// 회원 가입
	@GetMapping(value="/payment/pay")
	public String register(Model model) {
		logger.info("get register");
		return "payment/pay";
	}
	
	@PostMapping(value="/payment/pay")	
	public String register(MemberVO vo, RedirectAttributes ra) {
		logger.info("post register");
		
		return "home";
	}
	
	
}
