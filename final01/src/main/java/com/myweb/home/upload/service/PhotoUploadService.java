package com.myweb.home.upload.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.myweb.home.upload.model.PhotoUploadDAO;
import com.myweb.home.upload.model.PhotoUploadDTO;

@Service
public class PhotoUploadService {
	
	private static final Logger logger = LoggerFactory.getLogger(PhotoUploadService.class);
	
	@Autowired
	private PhotoUploadDAO dao;
	
	// ajax로 파일 서버에 전송하는 구문. 일단 주석처리.
//	@Transactional
//	public int upload(MultipartFile file, PhotoUploadDTO data) throws Exception {
//		logger.info("upload(MultipartFile={}, PhotoUploadDTO={})", file, data);
//		
//		File folder = new File(data.getLocation());
//		if(!folder.exists()) {
//			folder.mkdirs();
//		}
//		
//		UUID uuid = UUID.nameUUIDFromBytes(file.getBytes());
//
//		data.setFilename(file.getOriginalFilename());
//		data.setUuidname(uuid.toString());
//		data.setFilesize((int)file.getSize());
//		data.setFiletype(file.getContentType());
//		
//		// 사진 업로드 순서대로 파일아이디 설정
//		int seq = dao.getFileIdSeq();
//		data.setFileid(seq);
//		
//		boolean result = dao.insertData(data);
//		if(result) {
//			try {
//				file.transferTo(new File(data.getLocation() + File.separatorChar + data.getUuidname()));
//				return 1;
//			} catch (IOException e) {
//				throw new Exception("서버에 사진 업로드를 실패하였습니다.");
//			}
//		} else {
//			// 업로드 실패
//			return 0;
//		}
//	}
//
//	public List<PhotoUploadDTO> getDatas(String accountid) {
//		logger.info("getDatas(accountid={}", accountid);
//		List<PhotoUploadDTO> datas = dao.selectDatas(accountid);
//		return datas;
//	}

}
