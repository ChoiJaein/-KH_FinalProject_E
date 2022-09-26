package com.myweb.home.pay.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.home.login.model.AccountDTO;
import com.myweb.home.member.service.MemberService;
import com.myweb.home.member.vo.MemberVO;
import com.myweb.home.upload.model.AttachImageVO;
import com.myweb.home.upload.model.PhotoUploadDTO;
import com.myweb.home.upload.service.PhotoUploadService;

@Controller
public class PayController {
	
	private static final Logger logger = LoggerFactory.getLogger(PayController.class);

	@Autowired
	private MemberService service;
	
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
