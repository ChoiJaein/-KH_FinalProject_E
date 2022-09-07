package com.myweb.home.main.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.myweb.home.main.model.MainDAO;
import com.myweb.home.main.model.MainDTO;

public class MainService {
	
	private static final Logger logger = LoggerFactory.getLogger(MainDAO.class);
	
	@Autowired
	private MainDAO dao;
	
	public List<MainDTO> getAll() {
		logger.info("getAll()");
		
		List<MainDTO> datas = dao.selectAll();
		return datas;
	}
}
