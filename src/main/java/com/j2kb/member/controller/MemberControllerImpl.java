package com.j2kb.member.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.j2kb.common.SecurityConstants;
import com.j2kb.member.service.MemberService;
import com.j2kb.member.vo.MemberVO;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


@RestController
public class MemberControllerImpl implements MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberControllerImpl.class);
	
	@Autowired
	private MemberService memberService;

	@RequestMapping(method = RequestMethod.POST, path = "/api/users/join")
	public Boolean addMember(@RequestBody MemberVO memberVO) throws Exception {
		memberService.addMember(memberVO);
		return true;
		
	}

	@RequestMapping(method = RequestMethod.GET, path = "/getRequestApi")
	public String getRequestApi() {
		return "getRequestApi";
	}
	
	@RequestMapping(method=RequestMethod.GET, path = "/getMemberList")
	public List<MemberVO> getMemberList() {
		List<MemberVO> list= memberService.getMemberList();
		return list;
	}
	
	/** 이메일을 입력받고, 해당 이메일이 있다면 해당 이메일의 id를 리턴해주는 메소드 **/
	//POST http://localhost:8081/member/api/users/find/id
	/*
	 * {
    		"member_email" : "admin@j2kb.dev"
		}
	 * 
	 */
	@RequestMapping(method=RequestMethod.POST, path="/api/users/find/id")
	public String findByEmail(@RequestBody Map<String,String> param) {
		String memberEmail = param.get("member_email");
		return memberService.findByEmail(memberEmail);
	}
	
	/** 이메일 중복확인때 쓰는 메소드 **/
	//  POST http://localhost:8081/member/api/users/validate/email로 설정하시고
	/* json데이터 형식으로
	 * {
    		"member_email" : "admin@j2kb.dev"
		}
	 	이렇게 날려주시면 됩니다.
	 */ 
	@RequestMapping(method = RequestMethod.POST, path="/api/users/validate/email")
	public boolean isValidateEmail(@RequestBody Map<String,String> param){
		String memberEmail = param.get("member_email");
		return memberService.isValidateEmail(memberEmail);
	}
	
	/** 아이디 중복확인때 쓰는 메소드 **/
	// url뒤에 쿼리스트링으로 검색 값(아이디, 이메일 아님) 날려주면 됨
	// GET /api/users/validate/id?memberId=검색할 아이디
	// 아이디 중복조회가 get인지 post인지 헷갈려서 일단 이 메소드는 get으로 남겨두었으니
	// 프론트단에서 post로 중복조회 요청시 그대로 바꾸겠습니다!
	@RequestMapping(method = RequestMethod.GET, path="/api/users/validate/id")
	public boolean isValidateId(@RequestParam("memberId") String memberId){
		return memberService.findById(memberId);
	}
	
	
	
}
