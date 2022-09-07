package com.myweb.home;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myweb.home.main.service.MainService;
import com.myweb.home.notice.service.NoticeService;



@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@Autowired
	private MainService service;
	
	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getList(Model model) {
		logger.info("getList(model= {})", model);
		
		List datas = service.getAll();
		List nDatas = noticeService.getAll();
		
		model.addAttribute("nDatas", nDatas); // 공지 리스트
		model.addAttribute("datas", datas); // 품목 리스트
		
		return "home";		
	}
	
	
	// @GetMapping("/main")
	public String main() {
		
		return "mainpage";
	}
	
	

	
}
