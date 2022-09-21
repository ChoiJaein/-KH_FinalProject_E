package com.myweb.home.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myweb.home.board.model.BoardDTO;
import com.myweb.home.board.model.Criteria;
import com.myweb.home.board.model.PageMaker;
import com.myweb.home.board.model.SearchCriteria;
import com.myweb.home.board.service.BoardService;
import com.myweb.home.notice.controller.NoticeController;


@Controller
public class BoardController {
		
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	
		@Autowired
		private BoardService service;
		
		//상품 검색
		@RequestMapping(value = "/board/boardList_search", method = RequestMethod.GET)
		public void listPage(@ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception {
		 
		 List<BoardDTO> list = service.listSearch(scri);
		 model.addAttribute("list", list);
		 PageMaker pageMaker = new PageMaker();
		 pageMaker.setCri(scri);
		 pageMaker.setTotalCount(service.listCount());
		 //pageMaker.setTotalCount(service.countSearch(scri));
		 model.addAttribute("pageMaker", pageMaker);
		}
	
		@RequestMapping(value = "/board/detail", method = RequestMethod.GET) 
		public String BoardDetailView(Model model
				, HttpSession session
				, @RequestParam int id) {
			
			logger.info("BoardDetailView(model= {})", model);
			
			
			BoardDTO data = service.getData(id);
			
		if(data != null) {
			service.incViewCnt(session, data); // 조회수 체크 세션
			model.addAttribute("data", data); // 게시글 상세 데이터
			return "board/boardDetail";
		} else {
				model.addAttribute("msg", "해당 데이터가 존재하지 않습니다.");
				model.addAttribute("url", "/home");
				return "alert"; 
			 }	
		
		}
		
		@GetMapping(value="board/add")
		public String add() {
			return "board/boardUpload";
		}
		
		
	
}
