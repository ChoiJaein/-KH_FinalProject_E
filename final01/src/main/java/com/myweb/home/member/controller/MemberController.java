package com.myweb.home.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.home.login.model.AccountDTO;
import com.myweb.home.member.service.MemberService;
import com.myweb.home.member.vo.MemberVO;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService service;
	
	// 회원 가입
	@GetMapping(value="/register")
	public String register(Model model) {
		logger.info("get register");
		return "login/register";
	}
	
	@PostMapping(value="/register")	
	public String register(MemberVO vo, RedirectAttributes ra) {
		logger.info("post register");
		
		int result = service.idOverlap(vo);
		
		if(result == 1) {
			ra.addFlashAttribute("result", "registerFalse");
			return "login/register";
		} else if(result == 0) {
			service.register(vo);
			ra.addFlashAttribute("result", "registerOK");
		}
		return "login/login";
	}
	
	// 아이디 중복 확인
	@PostMapping(value="/idOverlap", produces="application/json; charset=utf-8")
	@ResponseBody
	public String idOverlap(MemberVO vo) {
		logger.info("idOverlap(MemberVO={})", vo);
		
		int result = service.idOverlap(vo);
		
		JSONObject json = new JSONObject();
		
		if(result == 1) {
			json.put("code", "fail");
		} else {
			json.put("code", "success");
		}
		
		return json.toJSONString();
	}
	
	// 회원정보 수정
	@GetMapping(value="/myinfo/modify")
	public String userModify(HttpServletRequest request, Model model, AccountDTO accountDto) {
		logger.info("get modify(HttpServletRequest={}, model={}, accountDto={})", request, model, accountDto);
		
		HttpSession session = request.getSession();
		accountDto = (AccountDTO) session.getAttribute("loginData");
		
		String accountid = accountDto.getaccountid();
		MemberVO data = service.getAll(accountid);
		model.addAttribute("data", data);
		
		return "login/userModify";
	}
	
	@PostMapping(value="/myinfo/modify")
	public String userModify(Model model, @ModelAttribute MemberVO vo) {
		logger.info("post userModify(Model={}, MemberVO={})", model, vo);
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
	public String signout(HttpServletRequest request, Model model, AccountDTO accountDto) {
		logger.info("get signout(HttpServletRequest={}, model={}, accountDto={})", request, model, accountDto);
		
		HttpSession session = request.getSession();
		accountDto = (AccountDTO) session.getAttribute("loginData");
		
		String accountid = accountDto.getaccountid();
		MemberVO data = service.getAll(accountid);
		model.addAttribute("data", data);
		
		return "/login/signout";
	}
	
	@PostMapping(value="/myinfo/signout")
	public String signout(Model model, @ModelAttribute MemberVO vo, HttpSession session) {
		logger.info("post signout");
		
		boolean result = service.signout(vo);
		
		if(result) {
			model.addAttribute("msg", "탈퇴가 완료되었습니다.");
			session.invalidate();
			model.addAttribute("url", "/home");
			return "alert";
		} else {
			model.addAttribute("msg", "탈퇴를 실패하였습니다. 다시 시도해주세요.");
			model.addAttribute("url", "/home/myinfo/signout");
			return "alert";
		}
		
	}

	
}
