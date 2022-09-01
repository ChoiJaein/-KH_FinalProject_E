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
	private SqlSessionTemplate sql;
	
	public int register(MemberVO vo) {
		return sql.insert("memberMapper.register", vo);
	}

	public MemberVO idOverlap(String accountid) {
		return sql.selectOne("memberMapper.idOverlap", accountid);
	}
}
