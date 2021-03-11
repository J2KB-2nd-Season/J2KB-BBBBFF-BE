package com.j2kb.member.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
@RequestMapping("/api/users")
public class MemberControllerImpl implements MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberControllerImpl.class);
	
	@Autowired
	private MemberService memberService;
	private LoginController loginController;

	@RequestMapping(method = RequestMethod.POST, path = "/join")
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
	
	@RequestMapping(method=RequestMethod.POST, path="/find/id")
	public String findByEmail(@RequestBody Map<String,String> param) {
		String memberEmail = param.get("member_email");
		return memberService.findByEmail(memberEmail);
	}

	@RequestMapping(method = RequestMethod.POST, path="/validate/email")
	public boolean isValidateEmail(@RequestBody Map<String,String> param){
		String memberEmail = param.get("member_email");
		return memberService.isValidateEmail(memberEmail);
	}
	
	@RequestMapping(method = RequestMethod.GET, path="/validate/id")
	public boolean isValidateId(@RequestParam("memberId") String memberId){
		return memberService.findById(memberId);
	}
	
	@RequestMapping(method = RequestMethod.POST, path="/find/password")
	public String changeToRandomPassword(@RequestBody Map<String,String> param) {
		String memberId = param.get("member_id");
		String memberEmail = param.get("member_email");
		return memberService.findPassword(memberId, memberEmail);
	}
	
}
