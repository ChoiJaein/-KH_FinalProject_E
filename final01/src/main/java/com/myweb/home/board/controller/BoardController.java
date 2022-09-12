package com.myweb.home.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myweb.home.board.model.BoardVO;
import com.myweb.home.board.model.Criteria;
import com.myweb.home.board.model.PageMaker;
import com.myweb.home.board.model.SearchCriteria;
import com.myweb.home.board.service.BoardService;


@Controller
public class BoardController {

	/*
	@RequestMapping(value="/boardList_search", method= RequestMethod.GET)
    public void getSearch(Model model, @RequestParam("num") int num) throws Exception {
	*/
	
	
	

		
		@Autowired
		private BoardService service;
		
		@RequestMapping(value="/board/list", method=RequestMethod.GET)
		public void list(Model model) throws Exception{
			
			List<BoardVO> list = service.list();
			
			model.addAttribute("list", list);
			
		}
		
		@RequestMapping(value="/board/read", method=RequestMethod.GET)
		public void read(@RequestParam("bid") int bid,Model model) throws Exception {
			BoardVO  vo = service.read(bid);
			model.addAttribute("read", vo);
		}
		
		@RequestMapping(value="/board/write", method=RequestMethod.GET)
		public void getWrite() throws Exception {
			
		}
		
		@RequestMapping(value="/board/write", method=RequestMethod.POST)
		public String postWrite(BoardVO vo) throws Exception {
			service.write(vo);
			return"redirect:/";
			
		}

		@RequestMapping(value="/board/listPage", method=RequestMethod.GET)
		public void listPage(@ModelAttribute("cri") Criteria cri, Model model) throws Exception{
			List<BoardVO> list = service.listPage(cri);
			model.addAttribute("list", list);
		  
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(service.listCount());
			model.addAttribute("pageMaker",pageMaker);
		
		}
		
		@RequestMapping(value = "/board/listSearch", method = RequestMethod.GET)
		public void listPage(@ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception {
		 
		 List<BoardVO> list = service.listSearch(scri);
		 model.addAttribute("list", list);
		 PageMaker pageMaker = new PageMaker();
		 pageMaker.setCri(scri);
		 pageMaker.setTotalCount(service.listCount());
		 //pageMaker.setTotalCount(service.countSearch(scri));
		 model.addAttribute("pageMaker", pageMaker);
		}
		
	
}
