package com.j2kb.member.service;

import java.util.List;

import com.j2kb.member.vo.MemberVO;

public interface MemberService {
	public void addMember(MemberVO member);
	public List<MemberVO> getMemberList();
	public boolean findById(String memberId);
	public boolean findByEmail(String email);
	public String findPassword(String memberId, String email);
}
