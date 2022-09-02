package com.myweb.home.login.model;



import java.util.List;
import java.util.Map;

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
		logger.info("selectLogin({},{})",data);
		AccountDTO result = session.selectOne("loginMapper.selectLogin",data);
		return result;
	}



	public AccountDTO find_id(String email) {
		logger.info("find_id({})", email);
    	AccountDTO result = session.selectOne("loginMapper.find_id", email);
		return result;
	}

	

	public List<AccountDTO> find_pw(Map<String, String> map) {
		logger.info("find_pw({},{})", map);
		System.out.println("ssss111");
		List<AccountDTO> result = session.selectList("loginMapper.find_pw", map);
		return result;
	}

	


}
