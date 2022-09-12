package com.myweb.home.member.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	//  !! 경로 수정해야 함 (mainPage or Login) !!
	@PostMapping(value="/register")	
	public String register(MemberVO vo) {
		logger.info("post register");
		service.register(vo);
		return "redirect:/";
	}

	// 아이디 중복확인 처리
	@PostMapping(value="/idOverlap")
	public void idOverlap(HttpServletResponse response, @RequestParam("accountid") String accountid) throws IOException {
		logger.info("idOverlap(response={},accountid={})", response, accountid);
		service.idOverlap(accountid, response);
	}
	
	// 회원정보 수정
	@GetMapping(value="/myinfo/modify")
//	public String userModify(HttpSession session, Model model) {
	public String userModify() {
		logger.info("get userModify");
	//	model.addAttribute("memVO", service.readMember((String)session.getAttribute("accountid")));
		return "login/userModify";
	}
	
	@PostMapping(value="/myinfo/modify")
	public String userModify(Model model, @ModelAttribute MemberVO vo) {
		logger.info("post userModify");
		boolean result = service.userModify(vo);
		
		if(result) {
			model.addAttribute("msg", "수정이 완료되었습니다.");
			model.addAttribute("url", "/home");
			return "alert";
		} else {
			model.addAttribute("msg", "수정을 실패하였습니다. 다시 시도해주세요.");
			model.addAttribute("url", "/home/myinfo/modify");
			return "alert";
		}
	}
	
	// 회원 탈퇴
	@GetMapping(value="/myinfo/signout")
	public String signout() {
		logger.info("get signout");
		return "/login/signout";
	}
	
	@PostMapping(value="/myinfo/signout")
	public String signout(Model model, @ModelAttribute MemberVO vo) {
		logger.info("post signout");
		
		boolean result = service.signout(vo);
		
		if(result) {
			model.addAttribute("msg", "탈퇴가 완료되었습니다.");
			model.addAttribute("url", "/home");
			return "alert";
		} else {
			model.addAttribute("msg", "탈퇴를 실패하였습니다. 다시 시도해주세요.");
			model.addAttribute("url", "/home/myinfo/signout");
			return "alert";
		}
		
	}

	
}
