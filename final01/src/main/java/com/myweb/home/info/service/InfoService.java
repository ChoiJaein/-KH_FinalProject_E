package com.myweb.home.info.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.home.info.model.InfoDAO;
import com.myweb.home.info.model.InfoDTO;
import com.myweb.home.main.model.MainDAO;
import com.myweb.home.main.model.MainDTO;


@Service
public class InfoService {
	
	private static final Logger logger = LoggerFactory.getLogger(InfoDAO.class);
	
	@Autowired
	private InfoDAO dao;
	
	@Autowired
	private MainDAO mDao;
	

	public InfoDTO getUserInfo(String id) {
		InfoDTO data = dao.selectProfile(id);
		
		return data;	
	}
	
	public InfoDTO getUserPurchase(String id) {
		InfoDTO data = dao.selectPurchase(id);
		
		return data;
		
	}
	
	public List<MainDTO> getPurchaseList(String id) {
		
		logger.info("getShoppingDetail(id= {})", id);
		
		List<MainDTO> datas = mDao.selectBuyList(id);
		
		return datas;
	}
	
	
	
	
}
