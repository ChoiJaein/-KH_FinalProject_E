package com.myweb.home.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.myweb.home.board.model.BoardDAO;
import com.myweb.home.board.model.BoardVO;
import com.myweb.home.board.model.Criteria;
import com.myweb.home.board.model.SearchCriteria;



public class BoardService {

	@Autowired
	private BoardDAO dao;
	
	
	public BoardVO read(int bid) throws Exception {
		return dao.read(bid);
	}
	
	public void write(BoardVO vo) throws Exception {
		dao.write(vo);
	}
	public List<BoardVO> list() throws Exception {
		return dao.list();
	}
	
	public List<BoardVO> listPage(Criteria cri) throws Exception {
		return dao.listPage(cri);
	}
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
