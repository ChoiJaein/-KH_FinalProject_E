package com.myweb.home.info.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myweb.home.main.model.MainDTO;

@Repository
public class InfoDAO {

	
private static final Logger logger = LoggerFactory.getLogger(InfoDAO.class);
	
	@Autowired
	private SqlSession session;
	
	private String mapper = "InfoMapper.%s";
	
	public InfoDTO selectProfile(String id) {
		String mapperId = String.format(mapper, "selectUserDatas");
		InfoDTO res  = session.selectOne(mapperId, id);
		
		logger.info("selectProfile(id= {})", id);
		
		return res;
		
	}
	
	public InfoDTO selectPurchase(String id) {
		String mapperId = String.format(mapper, "selectPurchaseCount");
		InfoDTO res = session.selectOne(mapperId, id);
		return res;
	}
	
	

}
