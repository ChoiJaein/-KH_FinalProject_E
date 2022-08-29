package com.myweb.home.member.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myweb.home.member.model.MemberDAO;
import com.myweb.home.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject MemberDAO dao;
	
	@Override
	public void register(MemberVO vo) throws Exception {
		dao.register(vo);
	}
	
}
