package com.myweb.home.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.myweb.home.board.model.BoardDTO;
import com.myweb.home.board.model.Criteria;
import com.myweb.home.board.model.PageMaker;
import com.myweb.home.board.model.SearchCriteria;
import com.myweb.home.board.service.BoardService;
import com.myweb.home.board.vo.BoardVO;
import com.myweb.home.login.model.AccountDTO;
import com.myweb.home.notice.controller.NoticeController;
import com.myweb.home.upload.model.PhotoUploadDTO;
import com.myweb.home.upload.service.PhotoUploadService;
import com.myweb.home.upload.vo.PhotoUploadVO;


@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService service;
	
	@GetMapping(value="/board/add")
	public String add(Model model) {
		logger.info("add()");
		List<CategoryDTO> categoryDatas = service.getCategory();
		model.addAttribute("categoryDatas", categoryDatas);
		return "board/boardUpload";
	}
	
	@PostMapping(value="/board/add")
	public String add(@SessionAttribute("loginData") AccountDTO accountDto
			, @ModelAttribute BoardVO boardVo, Model model) {
		logger.info("add(boardVo={})", boardVo);
		
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	
		@Autowired
		private BoardService service;
		
		@Autowired
		private PhotoUploadService photoUploadService;
		
		//상품 검색
		@RequestMapping(value = "/board/boardList_search", method = RequestMethod.GET)
		public void listPage(@ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception {
		 
		 List<BoardDTO> list = service.listSearch(scri);
		 model.addAttribute("list", list);
		 PageMaker pageMaker = new PageMaker();
		 pageMaker.setCri(scri);
		 pageMaker.setTotalCount(service.listCount());
		 //pageMaker.setTotalCount(service.countSearch(scri));
		 model.addAttribute("pageMaker", pageMaker);
		}
	
		@RequestMapping(value = "/board/detail", method = RequestMethod.GET) 
		public String BoardDetailView(Model model
				, HttpSession session
				, @RequestParam int id) {
			
			logger.info("BoardDetailView(model= {})", model);
			
			
			BoardDTO data = service.getData(id);
			
		if(data != null) {
			service.incViewCnt(session, data); // 조회수 체크 세션
			model.addAttribute("data", data); // 게시글 상세 데이터
			return "board/boardDetail";
		} else {
				model.addAttribute("msg", "해당 데이터가 존재하지 않습니다.");
				model.addAttribute("url", "/home");
				return "alert"; 
			 }	
		
		}
		
		@GetMapping(value="board/add")
		public String add(Model model) {
			List datas = service.getAll();
			model.addAttribute("cData", datas); //카테고리 정보
			return "board/boardUpload";
		}
		
		@PostMapping(value="board/add")
		public String add(HttpServletRequest request
				, @SessionAttribute("loginData") AccountDTO accDto
				, @ModelAttribute BoardVO boardVo
				, @RequestParam("photoUpload") MultipartFile[] files) {

			BoardDTO data = new BoardDTO();
			data.setbTitle(boardVo.getbTitle());
			data.setbContent(boardVo.getbContent());
			data.setbId(boardVo.getbId());
			data.setCateId(boardVo.getCateId());
			data.setDealMethod(boardVo.getDealMethod());
			data.setpCondition(boardVo.getpCondition());
			data.setPrice(boardVo.getPrice());
			data.setAccountId(accDto.getAccountid());
			
			int id = service.add(data);
			
			for(MultipartFile file: files) {
				String location = request.getServletContext().getRealPath("/resources/board/upload");
				String url = "/static/board/upload";
				PhotoUploadDTO fileData = new PhotoUploadDTO(id, location, url);
				
				try {
					int fileResult = photoUploadService.upload(file, fileData);
					if(fileResult == -1) {
						request.setAttribute("error", "파일 업로드 수량을 초과하였습니다.");
						return "board/boardUpload";
					}
				} catch(Exception e) {
					request.setAttribute("error", "파일 업로드 작업중 예상치 못한 에러가 발생하였습니다.");
					return "board/boardUpload";
				}
				
			}
			
			if(id != -1) {
				return "redirect:/board/detail?id=" + id;			
			} else {
				request.setAttribute("error", "게시글 저장 실패!");
				return "board/add";
			}
		}
		
		@GetMapping(value="board/modify")
		public String modify(Model model,
				@SessionAttribute("loginData") AccountDTO accDto,
				@RequestParam int id
				) {
			
			List datas = service.getAll();
			model.addAttribute("cData", datas); //카테고리 정보
			
			logger.info("modify(model= {}, AccountDTO={}, int={})", model, accDto, id);
			
			BoardDTO data= service.getData(id);
			List<PhotoUploadDTO> fileDatas = photoUploadService.getDatas(id);
			
	
			if(data != null) {
				if(data.getAccountId().equals(accDto.getAccountid()) || accDto.getAdmin().equals("Y") ) {
					model.addAttribute("data", data);
					model.addAttribute("fileDatas", fileDatas);
					return "board/boardModify";
				} else {
					model.addAttribute("msg", "해당 작업을 수행할 권한이 없습니다.");
					model.addAttribute("url", "/home");
					return "alert";
				}
			} else {
				model.addAttribute("msg", "해당 데이터가 존재하지 않습니다.");
				model.addAttribute("url", "/home");
				return "alert";
			}
		}
		
		@PostMapping(value="board/modify")
		public String modify(Model model, HttpServletRequest request
				, @SessionAttribute("loginData") AccountDTO accDto
				, @ModelAttribute BoardVO boardVo
				, @RequestParam("photoUpload") MultipartFile[] files)
		 {
			logger.info("modify(model= {}, AccountDTO={}, boardVo={})", model, accDto, boardVo);
			
			BoardDTO data = service.getData(boardVo.getbId());
			List<PhotoUploadDTO> fileDatas = photoUploadService.getDatas(boardVo.getbId());
			
			for(MultipartFile file: files) {
				PhotoUploadDTO fileData = new PhotoUploadDTO();
				
				try {
					int fileResult = photoUploadService.update(file, fileData);
					if(fileResult == -1) {
						request.setAttribute("error", "파일 업로드 수량을 초과하였습니다.");
						return "board/boardUpload";
					}
				} catch(Exception e) {
					request.setAttribute("error", "파일 업로드 작업중 예상치 못한 에러가 발생하였습니다.");
					return "board/boardUpload";
				}
			}
			
			if(data != null) {
				if(data.getAccountId().equals(accDto.getAccountid()) || accDto.getAdmin().equals("Y")) {
					data.setbTitle(boardVo.getbTitle());
					data.setbContent(boardVo.getbContent());
					data.setCateId(boardVo.getCateId());
					data.setDealMethod(boardVo.getDealMethod());
					data.setpCondition(boardVo.getpCondition());
					data.setPrice(boardVo.getPrice());
					
					boolean result = service.BoardModify(data);
					
					if(result) {
						return "redirect:/board/detail?id=" + data.getbId();
					} else {
						return modify(model, accDto, boardVo.getbId());
					}
				} else {
					model.addAttribute("msg", "해당 작업을 수행할 권한이 없습니다.");
					model.addAttribute("url", "/home");
					return "alert";
				}
			} else {
				model.addAttribute("msg", "해당 데이터가 존재하지 않습니다.");
				model.addAttribute("url", "/home");
				return "alert";
			}
			
		}
		
		
	}
	
	
//	@GetMapping(value="/board/modify")
//	public String modify(Model model
//			, @SessionAttribute("loginData") AccountDTO accountDto
//			, @RequestParam int bid) {
//		logger.info("modify(accountDto={}, bid={})", accountDto, bid);
//		
//		BoardDTO data = service.getData(bid);
//		
//		
//	}
	
	
	
	
	
	//상품 검색
	@RequestMapping(value = "/board/boardList_search", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception {
	 
	 List<BoardVO> list = service.listSearch(scri);
	 model.addAttribute("list", list);
	 PageMaker pageMaker = new PageMaker();
	 pageMaker.setCri(scri);
	 pageMaker.setTotalCount(service.listCount());
	 //pageMaker.setTotalCount(service.countSearch(scri));
	 model.addAttribute("pageMaker", pageMaker);
	}
	
	
	
	    
}
