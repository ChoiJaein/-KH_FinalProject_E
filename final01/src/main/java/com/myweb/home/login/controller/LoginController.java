package com.myweb.home.login.controller;


import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.MidiMessage;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.aspectj.weaver.patterns.ParserException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.myweb.home.login.model.AccountDTO;
import com.myweb.home.login.service.LoginService;
import com.myweb.home.login.vo.LoginVO;

import oracle.jdbc.driver.Message;





@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService service;
	
	@GetMapping(value="/login")
	public String login(Model model) {
		return "login/login";
		
	}
	
	

	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(LoginVO loginVo,Model model
			, HttpServletRequest request
			, HttpSession session) {
	
		logger.info("login({},{})",loginVo.getAccountid(), loginVo.getPassword());
		boolean result = service.getLogin(session,loginVo);
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("login");
		
		   if(result) {
			   //성공
			  
			   return "redirect:/";
		   } else {
			   //실패
			   return"login/login";
		   }
	       }

	//권한 없음 
	@RequestMapping(value="/accessDenied")
	public String accessDeniedPage() throws Exception {
		return "/login/accessDenied";
	}
	
	
	//로그아웃
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
	
    //아이디,비밀번호 찾기 폼으로 이동
	@RequestMapping(value = "/login/findIdPw",method=RequestMethod.GET)
	public String findIdPw() throws Exception {
		return "/login/findIdPw";
	}
	
	@GetMapping(value = "/login/find_id")
	public String find_id(Model model) {
		return "/login/find_id";
	}
	
	//아이디 찾기 성공
		@RequestMapping(value = "/login/find_id", method =RequestMethod.POST)
		public String find_id( @RequestParam("email")String email
				, HttpServletResponse response
				, HttpSession session) throws Exception {
			
			logger.info("find_id({})",email);
			
			
			boolean result = service.find_id(response,session,email);
			
			if(result) {
				//성공 
				System.out.println("성공");
				return "/login/find_id";
			} else {
				//실패
				System.out.println("실패");
				return"login/login";
			}
		}

	
	//비밀번호 찾기 성공
	@RequestMapping(value = "/login/find_pw", method =RequestMethod.POST)
	public String find_pw(@ModelAttribute AccountDTO accountDTO,
			HttpServletResponse response,HttpSession session) throws Exception{
		service.find_pw(response,session, accountDTO);
		
		return "/login/find_pw";
    }
	
	//카카오 로그인
	@RequestMapping( value="/login/kakao", method=RequestMethod.GET)
	public String kakoLogin() {
	     UriComponents kakaoAuthUri = UriComponentsBuilder.newInstance()  
	                .scheme("https").host("kauth.kakao.com").path("/oauth/authorize")
	                .queryParam("client_id", "103069249c78ae6f9b28735131305b03") //RestAPI
	                .queryParam("redirect_uri", "http://localhost/home/login/kakao/auth_code")
	                .queryParam("response_type", "code").build();

	RestTemplate rest = new RestTemplate();

	//302 리다이렉트 응답에 대한 핸들링을 하지 않게 만들기 위해 적용
	CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
	
	//HTTP 요청 정보를 만들어 주는 팩토리
	HttpComponentsClientHttpRequestFactory factory  = new HttpComponentsClientHttpRequestFactory();
	
	factory.setHttpClient(httpClient);
	rest.setRequestFactory(factory);
    
	//Get 요청 후 응답 정보를 저장
	ResponseEntity<String> restResponse = rest.getForEntity(kakaoAuthUri.toUriString(),String.class);
	return "redirect:" + restResponse.getHeaders().getLocation();
	}
	
	//카카오가 서버에게 보내는 인가코드 처리하기 위한 메서드
	@RequestMapping(value="/login/kakao/auth_code", method=RequestMethod.GET)
	public String KakaoAuthCode(HttpSession session
		,String code, String state, String error
		, @RequestParam(name="error_description", required=false) String errorDescription) throws org.json.simple.parser.ParseException{
		String tokenType= null, accessToken = null, refreshToken = null;
		long expiresIn = -1, refreshTokenExpiresIn = -1;
		
		if(error == null) {
			MultiValueMap<String, String> param = new LinkedMultiValueMap<String, String>();
			param.add("grant_type", "authorization_code");
			param.add("client_id", "103069249c78ae6f9b28735131305b03");
			param.add("redirect_uri", "http://localhost/home/login/kakao/auth_code");
			param.add("code", code);
			
			UriComponents KaKaoAuthUri = UriComponentsBuilder.newInstance()
					.scheme("https").host("kauth.kakao.com").path("/oauth/token").build();
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=utf-8");
			
			
			
			HttpEntity<MultiValueMap<String,String>> entity= new HttpEntity<MultiValueMap<String,String>>(param,headers);
			
			RestTemplate rest= new RestTemplate(); 
			rest.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
			
			//POST 요청을 보내고 응답 결과를 받는다.(대부분 응답 결과가 JSON 형식이지만 아닐 수도 있음)
			ResponseEntity<String> restResponse = rest.postForEntity(KaKaoAuthUri.toUriString(),entity,String.class);
		    
			//응답 결과가 JSON 인  경우 JSONParser 로 파싱할 수 있다.
			JSONParser jsonParser =  new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(restResponse.getBody());

			 tokenType = jsonObject.get("token_type").toString();
			 accessToken = jsonObject.get("access_token").toString();
			 expiresIn = Long.valueOf(jsonObject.get("expires_in").toString());
			 refreshToken = jsonObject.get("refresh_token").toString();
			 refreshTokenExpiresIn = Long.valueOf(jsonObject.get("refresh_token_expires_in").toString());
				
		
		
		return "redirect:/login";
	}
		return "error/kakao_auth_error";
		
}
}