package com.myweb.home.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.home.board.model.BoardDAO;
import com.myweb.home.board.model.BoardDTO;
import com.myweb.home.board.model.Criteria;
import com.myweb.home.board.model.SearchCriteria;
import com.myweb.home.board.model.CategoryDTO;
import com.myweb.home.board.vo.BoardVO;
 
@Service
public class BoardService {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);

	@Autowired
	private BoardDAO dao;

	public int add(BoardDTO data) {
		logger.info("add(data={})", data);
		int seq = dao.getNextSeq();
		data.setBid(seq);
		
		boolean result = dao.insertData(data);
		
		if(result) {
			return data.getBid();
		}
		return -1;
	}

	
//	public BoardDTO getData(int bid) {
//		logger.info("getData(bid={})", bid);
//		BoardDTO data = dao.selectData(bid);
//		return data;
//	}
	
	// 카테고리 설정을 위해 카테고리 정보 가져오기
	public List<CategoryDTO> getCategory() {
		List<CategoryDTO> datas = dao.searchCategory();
		return datas;
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
