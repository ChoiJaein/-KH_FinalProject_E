package com.myweb.home.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.myweb.home.board.model.BoardDTO;
import com.myweb.home.board.model.CategoryDTO;
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
	
	@GetMapping(value="/board/add")
	public String add(Model model) {
		logger.info("add()");
		List<CategoryDTO> categoryDatas = service.getCategory();
		model.addAttribute("categoryDatas", categoryDatas);
		return "board/boardUpload";
	}
	
	@PostMapping(value="/board/add")
	public String add(@SessionAttribute("loginData") AccountDTO accountDto
			, @ModelAttribute BoardVO boardVo, Model model) {
		logger.info("add(boardVo={})", boardVo);
		
		BoardDTO data = new BoardDTO();
		data.setBtitle(boardVo.getBtitle());
		data.setBcontent(boardVo.getBcontent());
		data.setAccountid(accountDto.getaccountid());
		data.setCategoryid(boardVo.getCategoryid());
		data.setDealmethod(boardVo.getDealmethod());
		data.setPrice(boardVo.getPrice());
		data.setPcondition(boardVo.getPcondition());
		data.setBuystatus(boardVo.getBuystatus());
		
		int bid = service.add(data);
		if(bid != -1) {
			return "redirect:/board/detail?bid=" + bid;
		} else {
			return "board/boardUpload";
		}
		
	}
	
	
//	@GetMapping(value="/board/modify")
//	public String modify(Model model
//			, @SessionAttribute("loginData") AccountDTO accountDto
//			, @RequestParam int bid) {
//		logger.info("modify(accountDto={}, bid={})", accountDto, bid);
//		
//		BoardDTO data = service.getData(bid);
//		
//		
//	}
	
	
	
	
	
	//상품 검색
	@RequestMapping(value = "/board/boardList_search", method = RequestMethod.GET)
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
