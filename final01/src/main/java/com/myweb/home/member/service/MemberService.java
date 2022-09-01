package com.myweb.home.member.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.myweb.home.member.model.MemberDAO;
import com.myweb.home.member.vo.MemberVO;

@Service
public class MemberService {
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

	
	@Autowired
	private MemberDAO dao;
	
	public void register(MemberVO vo) {
		
		dao.register(vo);
	}

	public void idOverlap(String accountid, HttpServletResponse response) throws IOException {
		MemberVO vo = new MemberVO();
		vo = dao.idOverlap(accountid);
		if(vo == null) {
			//dao에서 select이 되지 않아야 true
			//id가 없어야 true(사용 가능)
			response.getWriter().print("1");
		} else {
			//id가 있으면 false(중복으로 사용 불가능)
			response.getWriter().print("0");
		}
	}
}
