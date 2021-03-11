package com.j2kb.member.service;

import java.util.List;

import com.j2kb.member.vo.MemberVO;

public interface MemberService {
	public void addMember(MemberVO member);
	public List<MemberVO> getMemberList();
	public boolean findById(String memberId);
	public boolean isValidatePw(String memberId, String memberPw);
	public int getMemberRole(MemberVO vo);
	public String findPassword(String memberId, String email);
	public String findByEmail(String memberEmail);
	public boolean isValidateEmail(String memberEmail);
}
