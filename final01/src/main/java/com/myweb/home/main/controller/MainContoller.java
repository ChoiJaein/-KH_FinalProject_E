package com.myweb.home.main.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myweb.home.main.model.MainDAO;
import com.myweb.home.main.service.MainService;
import com.myweb.home.notice.service.NoticeService;

@Controller
@RequestMapping(value="/main")
public class MainContoller {
	
	private static final Logger logger = LoggerFactory.getLogger(MainDAO.class);
	
	@Autowired
	private MainService service;
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String getNoticeList(Model model) {
		
		List ndata = noticeService.getAll();
		
		model.addAttribute("ndata", ndata);
		
		return "notice/testmain"; //
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String getList(Model model) {
		
		List data = service.getAll();
		
		model.addAttribute("data", data);
		
		return "notice/testmain"; //
	}
	
	
	

}
