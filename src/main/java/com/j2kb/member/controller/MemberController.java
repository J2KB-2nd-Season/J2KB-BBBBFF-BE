package com.j2kb.member.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.j2kb.member.vo.MemberVO;

public interface MemberController {

	public String getRequestApi();

	public Boolean addMember(MemberVO memberVO) throws Exception;
	
	public List<MemberVO> getMemberList();
	
	public boolean findById(String memberId);

}
