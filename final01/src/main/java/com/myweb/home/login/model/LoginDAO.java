package com.myweb.home.login.model;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myweb.home.login.vo.LoginVO;


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
    	//AccountDTO result = session.selectOne("loginMapper.find_id", email);
		//return result;
		System.out.println("==> session으로 find_id() 기능 처리");
		return session.selectOne("loginMapper.find_id", email);
	}

	/*
	public LoginVO find_id(LoginVO loginvo) {
		logger.info("find_id({})", loginvo);
		System.out.println("==>  find_id() 기능 처리");
		return session.selectOne("loginMapper.find_id", loginvo);
	}
	}
*/
	

	/*public List<AccountDTO> find_pw(Map<String, String> map) {
		logger.info("find_pw({},{})", map);
			List<AccountDTO> result = session.selectList("loginMapper.find_pw", map);
		return result;
		

public int update_pw(AccountDTO account) throws Exception{
	return session.update("loginMapper.update_pw", account);
}
}*/
	
	
	public AccountDTO find_pw(AccountDTO accountDTO) {
		logger.info("find_pw({})", accountDTO);
		return session.selectOne("loginMapper.find_pw", accountDTO);
		
	}
	
}


