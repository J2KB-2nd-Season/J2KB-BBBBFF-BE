package com.j2kb.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.j2kb.member.dao.MemberDAO;
import com.j2kb.member.vo.MemberVO;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

@Component
@Log
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public void addMember(MemberVO member) {
		member.setMember_id(member.getMember_id());
		member.setMember_pw(member.getMember_pw());
		member.setMember_name(member.getMember_name());
		member.setMember_adrs(member.getMember_adrs());
		member.setMember_email(member.getMember_email());
		member.setMember_phone(member.getMember_phone());
		member.setGrade(member.getGrade());
		log.info("memberVO: "+member);
		memberDAO.insertNewMember(member);
	}

	@Override
	public void isValidatePassword(String memberId, String inputPw) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public List<MemberVO> getMemberList() {
		return memberDAO.selectAllMemberList();
	}

	
}
