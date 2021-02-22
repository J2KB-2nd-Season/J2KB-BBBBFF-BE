package com.j2kb.member.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.j2kb.member.vo.MemberVO;

public interface MemberController {

	public String getRequestApi();

	public String addMember(MemberVO memberVO) throws Exception;
	
	public List<MemberVO> getMemberList();

}
