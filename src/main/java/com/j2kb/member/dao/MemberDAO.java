package com.j2kb.member.dao;

import java.util.List;

import com.j2kb.member.vo.MemberVO;

public interface MemberDAO {
	public void insertNewMember(MemberVO memberVO);
	public void deleteMember(String member_id);
	public List<MemberVO> selectAllMemberList();
	public MemberVO findById(String member_id);
}
