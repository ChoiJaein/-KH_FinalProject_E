package com.myweb.home.login.model;



import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class LoginDAO {

	private static final Logger logger = LoggerFactory.getLogger(LoginDAO.class);
	
	@Autowired
	private SqlSession session;

	public AccountDTO selectLogin(AccountDTO data) {
		logger.info("selectLogin({},{}",data);
		AccountDTO result = session.selectOne("loginMapper.selectLogin",data);
		return result;
	}



}
