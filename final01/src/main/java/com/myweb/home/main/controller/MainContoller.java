package com.myweb.home.main.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myweb.home.main.model.MainDTO;
import com.myweb.home.main.service.MainService;
import com.myweb.home.notice.service.NoticeService;

@Controller
@RequestMapping(value="/main")
public class MainContoller {
	
	private static final Logger logger = LoggerFactory.getLogger(MainContoller.class);
	
	@Autowired
	private MainService service;
	
	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value="", method=RequestMethod.GET)
	public String getList(Model model) {
		logger.info("getList(model= {})", model);
		
		List data = service.getAll();
		List nData = noticeService.getAll();
		
		model.addAttribute("nData", nData); // 공지 리스트
		model.addAttribute("data", data); // 품목 리스트
		
		return "main/testmain";  //
		
			
	}
	
	
	@GetMapping
		public String list() {
		return "main/list";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET) 
		public String getCateList(Model model, 
				@RequestParam(value="type") String category) {
		
		MainDTO data = new MainDTO();
		data.setCateName(category);
		
		List cData = service.getCate(data);
		
		model.addAttribute("cData", cData);
		
		
		return "redirect:/main/testlist?type=" + data.getCateName();
		
	}
	

}
