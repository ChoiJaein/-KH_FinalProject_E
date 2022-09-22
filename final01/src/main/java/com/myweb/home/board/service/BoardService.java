package com.myweb.home.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.home.board.controller.BoardController;
import com.myweb.home.board.model.BoardDAO;
import com.myweb.home.board.model.BoardDTO;
import com.myweb.home.board.model.Criteria;
import com.myweb.home.board.model.ReviewDTO;
import com.myweb.home.board.model.SearchCriteria;


@Service
public class BoardService {

	 private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
	
	@Autowired
	private BoardDAO dao;
	
	

	
	public int listCount() throws Exception {
		return dao.listCount();
	}
 
	public List<BoardDTO> listSearch(SearchCriteria scri) throws Exception {
		return dao.listSearch(scri);
	}
	
	public int countSearch(SearchCriteria scri)throws Exception {
		return dao.countSearch(scri);
	}

	public void insertReview(ReviewDTO data) throws Exception{
		 logger.info("data({})",data);
		dao.insertReview(data);
	}

	public List<ReviewDTO> ReviewList(int bId) throws Exception{
		 logger.info("data({})",bId);
		return dao.ReviewList(bId);
	}
	
}
