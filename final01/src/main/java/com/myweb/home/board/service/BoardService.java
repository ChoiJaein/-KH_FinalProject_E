package com.myweb.home.board.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.home.board.model.BoardDAO;
import com.myweb.home.board.model.BoardDTO;
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

}
