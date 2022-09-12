package com.myweb.home.board.model;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myweb.home.board.vo.BoardVO;

@Repository
public class BoardDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAO.class);

	@Autowired
	private SqlSession session;
	
	private String mapper = "boardMapper.%s";
	
	public int getNextSeq() {
		logger.info("getNextSeq()");
		String mapperId = String.format(mapper, "getNextSeq");
		int seq = session.selectOne(mapperId);
		return seq;
	}

	public boolean insertData(BoardDTO data) {
		logger.info("insertData(data={})", data);
		String mapperId = String.format(mapper, "insertData");
		int res = session.insert(mapperId, data);
		return res == 1 ? true : false;
	}

}
