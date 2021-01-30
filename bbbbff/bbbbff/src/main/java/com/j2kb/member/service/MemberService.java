package com.j2kb.member.service;

import com.j2kb.member.vo.MemberVO;

public interface MemberService {
	//회원가입 서비스단 메서드
	public void addMember(MemberVO member) throws Exception;
	public void isValidatePassword(String memberId, String inputPw);
}
