package com.myweb.home.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myweb.home.board.model.BoardDTO;
import com.myweb.home.board.model.Criteria;
import com.myweb.home.board.model.PageMaker;
import com.myweb.home.board.model.ReviewDTO;
import com.myweb.home.board.model.SearchCriteria;
import com.myweb.home.board.service.BoardService;
import com.myweb.home.login.controller.LoginController;
import com.myweb.home.login.model.AccountDTO;


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
	
		
		
		@RequestMapping(value="/board/boardDetail", method = RequestMethod.GET)
		  public void boardDetail(@RequestParam(value="bId",defaultValue="0") int bId ,Model model) throws Exception {
			
			 logger.info("boardDetail");
			 List<ReviewDTO> review = service.ReviewList(bId);
			 model.addAttribute("review", review); 
			
		 }
		
		//리뷰 등록
		@RequestMapping(value="/board/boardDetail", method = RequestMethod.POST)
		public String insertReview(Model model,
				ReviewDTO data, HttpSession session,HttpServletRequest request) throws Exception{
			    logger.info("data({})", data);
			   
			     String bid =request.getParameter("bid");
				 String content = request.getParameter("content");
				 
				 AccountDTO account = (AccountDTO)session.getAttribute("loginData");
				 
				 try {
					 data.setAccountId(account.getAccountid());
					 data.setbId(Integer.parseInt(bid));
					 data.setContent(content);
				 
				 
				 
				 }catch(Exception e) {
					 
				 }
				 service.insertReview(data);
				 
			 return "redirect:/board/boardDetail?id=" + data.getbId();
				
		}
 
		
	
		

}
