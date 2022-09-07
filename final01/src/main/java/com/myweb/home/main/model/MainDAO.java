package com.myweb.home.main.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class MainDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(MainDAO.class);
	
	@Autowired
	private SqlSession session;
	
	private String mapper = "mainMapper.%s";
	
	public List<MainDTO> selectAll() {
		String mapperId = String.format(mapper, "selectDatas");
		List<MainDTO> res = session.selectList(mapperId);
		
		logger.info("selectAll()");
		
		return res;
		
	}

}
