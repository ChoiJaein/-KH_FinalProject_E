package com.myweb.home.upload.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myweb.home.board.model.BoardDAO;

@Repository
public class PhotoUploadDAO {

	private static final Logger logger = LoggerFactory.getLogger(PhotoUploadDAO.class);
	
	@Autowired
	private SqlSession session;
	
//	// 사진 업로드 순서대로 파일 아이디 설정
//	public int getFileIdSeq() {
//		logger.info("getFileIdSeq()");
//		int seq = session.selectOne("photoUploadMapper.getFileIdSeq");
//		return seq;
//	}
//	
//	public boolean insertData(PhotoUploadDTO data) {
//		logger.info("insertData(PhotoUploadDTO={}", data);
//		int res = session.insert("photoUploadMapper.insertData", data);
//		System.out.println(res);
//		return res == 1 ? true : false;
//	}
//
//	public List<PhotoUploadDTO> selectDatas(String accountid) {
//		logger.info("selectDatas(accountid={}", accountid);
//		List<PhotoUploadDTO> res = session.selectList("photoUploadMapper.selectDatas", accountid);
//		return res;
//	}

}
