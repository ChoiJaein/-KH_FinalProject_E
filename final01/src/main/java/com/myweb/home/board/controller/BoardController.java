package com.myweb.home.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.myweb.home.board.model.BoardDTO;
import com.myweb.home.board.service.BoardService;
import com.myweb.home.board.vo.BoardVO;
import com.myweb.home.login.model.AccountDTO;
import com.myweb.home.login.vo.LoginVO;
import com.myweb.home.member.controller.MemberController;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService service;
	
	@GetMapping(value="/add")
	public String add() {
		logger.info("add()");
		return "board/boardUpload";
	}
	
	@PostMapping(value="/add")
	public String add(@SessionAttribute("loginData") AccountDTO accountDto
			, @ModelAttribute BoardVO boardVo) {
		logger.info("add(boardVo={})", boardVo);
		
		BoardDTO data = new BoardDTO();
		data.setBtitle(boardVo.getBtitle());
		data.setBcontent(boardVo.getBcontent());
		data.setAccountid(accountDto.getaccountid());
		
		int bid = service.add(data);
		if(bid != -1) {
			return "redirect:/board/detail?bid=" + bid;
		} else {
			return "board/boardUpload";
		}
		
	}
	
}
