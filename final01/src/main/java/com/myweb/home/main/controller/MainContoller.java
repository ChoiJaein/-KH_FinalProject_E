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

@Controller
@RequestMapping(value="/main")
public class MainContoller {
	
	private static final Logger logger = LoggerFactory.getLogger(MainContoller.class);
	
	@Autowired
	private MainService service;
	
	@GetMapping
		public String list() {
		return "board/boardList_category";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET) 
		public String getCateList(Model model, 
				@RequestParam(value="type") int category) {
		
		MainDTO data = new MainDTO();
		data.setCateId(category);
		
		List cData = service.getCate(data);
		
		model.addAttribute("cData", cData);
		
		
		return "redirect:/main/list?type=" + data.getCateId();
		
	}
	

}
