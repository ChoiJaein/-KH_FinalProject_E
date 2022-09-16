package com.myweb.home.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.home.board.model.BoardDAO;
import com.myweb.home.board.model.BoardVO;
import com.myweb.home.board.model.Criteria;
import com.myweb.home.board.model.SearchCriteria;


@Service
public class BoardService {

	@Autowired
	private BoardDAO dao;
	
	

	
	public int listCount() throws Exception {
		return dao.listCount();
	}
 
	public List<BoardVO> listSearch(SearchCriteria scri) throws Exception {
		return dao.listSearch(scri);
	}
	
	public int countSearch(SearchCriteria scri)throws Exception {
		return dao.countSearch(scri);
	}
}
