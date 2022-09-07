package com.myweb.home.member.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myweb.home.member.vo.MemberVO;


@Repository
public class MemberDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDAO.class);

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int register(MemberVO vo) {
		logger.info("register(vo={})", vo);
		return sqlSession.insert("memberMapper.register", vo);
	}

	public MemberVO idOverlap(String accountid) {
		return sqlSession.selectOne("memberMapper.idOverlap", accountid);
	}

	public boolean userModify(MemberVO vo) {
		logger.info("userModify(vo={})", vo);
		int res = sqlSession.update("memberMapper.userModify", vo);
		return res == 1 ? true : false;
	}
}
