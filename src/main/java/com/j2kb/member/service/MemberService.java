package com.j2kb.member.service;

import java.util.List;

import com.j2kb.member.vo.MemberVO;

public interface MemberService {
	public void addMember(MemberVO member);
	public void isValidatePassword(String memberId, String inputPw);
	public List<MemberVO> getMemberList();
}
