package com.j2kb.member.dao;

import java.util.List;

import com.j2kb.member.vo.MemberVO;

public interface MemberDAO {
	public void insertNewMember(MemberVO memberVO) throws Exception;
	public List<MemberVO> selectAllMemberList();
}
