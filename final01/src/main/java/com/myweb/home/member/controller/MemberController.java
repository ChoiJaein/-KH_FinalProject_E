package com.myweb.home.member.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.home.login.model.AccountDTO;
import com.myweb.home.member.service.MemberService;
import com.myweb.home.member.vo.MemberVO;
import com.myweb.home.upload.model.AttachImageVO;
import com.myweb.home.upload.model.PhotoUploadDTO;
import com.myweb.home.upload.service.PhotoUploadService;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService service;
	
	@Autowired PhotoUploadService photoUploadService;
	
	// 회원 가입
	@GetMapping(value="/register")
	public String register(Model model) {
		logger.info("get register");
		return "login/register";
	}
	
	@PostMapping(value="/register")	
	public String register(MemberVO vo, RedirectAttributes ra) {
		logger.info("post register");
		
		int result = service.idOverlap(vo);
		
		if(result == 1) {
			ra.addFlashAttribute("result", "registerFalse");
			return "login/register";
		} else if(result == 0) {
			service.register(vo);
			ra.addFlashAttribute("result", "registerOK");
		}
		return "login/login";
	}
	
	// 아이디 중복 확인
	@PostMapping(value="/idOverlap", produces="application/json; charset=utf-8")
	@ResponseBody
	public String idOverlap(MemberVO vo) {
		logger.info("idOverlap(MemberVO={})", vo);
		
		int result = service.idOverlap(vo);
		
		JSONObject json = new JSONObject();
		
		if(result == 1) {
			json.put("code", "fail");
		} else {
			json.put("code", "success");
		}
		
		return json.toJSONString();
	}
	
	// 회원정보 수정
	@GetMapping(value="/myinfo/modify")
	public String userModify(HttpServletRequest request, Model model, AccountDTO accountDto) {
		logger.info("get modify(HttpServletRequest={}, model={}, accountDto={})", request, model, accountDto);
		HttpSession session = request.getSession();
		accountDto = (AccountDTO) session.getAttribute("loginData");
		
		String accountid = accountDto.getaccountid();
		MemberVO data = service.getAll(accountid);
		logger.info("service.getAll(MemberVO={})", data);
		
		model.addAttribute("data", data);
		return "login/userModify";
	}
	
//	@PostMapping(value="/myinfo/modify")
//	public String userModify(HttpServletRequest request, Model model
//			, AccountDTO accountDto, @ModelAttribute MemberVO vo) {
//		logger.info("post userModify(Model={}, accountDto={}, MemberVO={})", model, accountDto, vo);
//
//		boolean result = service.userModify(vo);
//		
//		if(result) {
//			model.addAttribute("msg", "수정이 완료되었습니다.");
//			model.addAttribute("url", "/home");
//			return "alert";
//		} else {
//			model.addAttribute("msg", "수정을 실패하였습니다. 다시 시도해주세요.");
//			model.addAttribute("url", "/home/myinfo/modify");
//			return "alert";
//		}
//	}
	
			// 파일 저장
	/* 첨부 파일 업로드 */
	@PostMapping(value="uploadAjaxAction", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AttachImageVO>> uploadAjaxActionPOST(MultipartFile[] uploadFile) {
		
		logger.info("uploadAjaxActionPOST..........");
		String uploadFolder = "/Users/jaein/git/KH_FinalProject_E/final01/src/main/webapp/resources/img/member";
		
		/* 날짜 폴더 경로 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();
		
		String str = sdf.format(date);
		
		String datePath = str.replace("-", File.separator);
		
		/* 폴더 생성 */
		File uploadPath = new File(uploadFolder, datePath);
		
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		
		/* 이미저 정보 담는 객체 */
		List<AttachImageVO> list = new ArrayList<>();
		
		// 향상된 for
		for(MultipartFile multipartFile : uploadFile) {
			
			/* 이미지 정보 객체 */
			AttachImageVO vo = new AttachImageVO();
			
			/* 파일 이름 */
			String uploadFileName = multipartFile.getOriginalFilename();
			vo.setFileName(uploadFileName);
			vo.setUploadPath(datePath);
			
			/* uuid 적용 파일 이름 */
			String uuid = UUID.randomUUID().toString();
			vo.setUuid(uuid);
			
			uploadFileName = uuid + "_" + uploadFileName;
			
			/* 파일 위치, 파일 이름을 합친 File 객체 */
			File saveFile = new File(uploadPath, uploadFileName);
			
			/* 파일 저장 */
			try {
				
				multipartFile.transferTo(saveFile);
				
				// 여기 원래 썸네일 관련 내용들이 우루루 들어감
				/* 썸네일 생성(ImageIO) */
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			} 
			
			list.add(vo);
			
		}	//for
		
		ResponseEntity<List<AttachImageVO>> result = new ResponseEntity<List<AttachImageVO>>(list, HttpStatus.OK);
		System.out.println(result);
		return result;
		
		
//			// 향상된 for
//			for(MultipartFile multipartFile : uploadFile) {
//				logger.info("-----------------------------------------------");
//				logger.info("파일 이름 : " + multipartFile.getOriginalFilename());
//				logger.info("파일 타입 : " + multipartFile.getContentType());
//				logger.info("파일 크기 : " + multipartFile.getSize());			
//			}
//			
//			//기본 for
//			for(int i = 0; i < uploadFile.length; i++) {
//				logger.info("-----------------------------------------------");
//				logger.info("파일 이름 : " + uploadFile[i].getOriginalFilename());
//				logger.info("파일 타입 : " + uploadFile[i].getContentType());
//				logger.info("파일 크기 : " + uploadFile[i].getSize());			
//			}
		
	}
	
	
	@ResponseBody
	@PostMapping(value="/myinfo/modify", produces = "application/text; charset=utf8")
	public String userModify(HttpServletRequest request, Model model
			, AccountDTO accountDto, @ModelAttribute MemberVO vo) {
		logger.info("post userModify(Model={}, accountDto={}, MemberVO={})", model, accountDto, vo);
		// 파일업로드 관련 메소드. 일단 주석처리.
//		HttpSession session = request.getSession();
//		accountDto = (AccountDTO) session.getAttribute("loginData");
//		
//		String accountid = accountDto.getaccountid();
//		logger.info("photoUploadService.getDatas 실행 직전(accountid={})", accountid);
//		List<PhotoUploadDTO> fileDatas = photoUploadService.getDatas(accountid);
//		
//		model.addAttribute("fileDatas", fileDatas);

		
		boolean result = service.userModify(vo);
		
		if(result) {
			model.addAttribute("msg", "수정이 완료되었습니다.");
			model.addAttribute("url", "/home");
			return "alert";
		} else {
			model.addAttribute("msg", "수정을 실패하였습니다. 다시 시도해주세요.");
			model.addAttribute("url", "/home/myinfo/modify");
			return "alert";
		}
	}
	
	
	// 회원 탈퇴
	@GetMapping(value="/myinfo/signout")
	public String signout(HttpServletRequest request, Model model, AccountDTO accountDto) {
		logger.info("get signout(HttpServletRequest={}, model={}, accountDto={})", request, model, accountDto);
		
		HttpSession session = request.getSession();
		accountDto = (AccountDTO) session.getAttribute("loginData");
		
		String accountid = accountDto.getaccountid();
		MemberVO data = service.getAll(accountid);
		model.addAttribute("data", data);
		
		return "/login/signout";
	}
	
	@PostMapping(value="/myinfo/signout")
	public String signout(Model model, @ModelAttribute MemberVO vo, HttpSession session) {
		logger.info("post signout");
		
		boolean result = service.signout(vo);
		
		if(result) {
			model.addAttribute("msg", "탈퇴가 완료되었습니다.");
			session.invalidate();
			model.addAttribute("url", "/home");
			return "alert";
		} else {
			model.addAttribute("msg", "탈퇴를 실패하였습니다. 다시 시도해주세요.");
			model.addAttribute("url", "/home/myinfo/signout");
			return "alert";
		}
		
	}

	
}
