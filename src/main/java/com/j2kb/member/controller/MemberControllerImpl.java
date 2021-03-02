package com.j2kb.member.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	
	//url뒤에 쿼리스트링으로 검색 값 날려주면 됨
	// GET /api/users/find?memberId=검색할 값
	@RequestMapping(method = RequestMethod.GET, path="/api/users/find")
	public boolean findById(@RequestParam("memberId") String memberId){
		return memberService.findById(memberId);
	}

	//https://aejeong.com/entry/Spring-boot-JWT-RefreshToken-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0
	//JWT Token 구현한 블로그

	
}
