package com.j2kb.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.j2kb.member.service.MemberService;
import com.j2kb.member.vo.MemberVO;

@RestController
public class MemberControllerImpl implements MemberController {
	
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

}
