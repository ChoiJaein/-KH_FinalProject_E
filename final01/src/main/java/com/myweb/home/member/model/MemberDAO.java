package com.myweb.home.member.model;

import com.myweb.home.member.vo.MemberVO;

public interface MemberDAO {

	// 회원가입
	public void register(MemberVO vo) throws Exception;
	
}
