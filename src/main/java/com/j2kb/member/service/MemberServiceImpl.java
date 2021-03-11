package com.j2kb.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.j2kb.member.dao.MemberDAO;
import com.j2kb.member.vo.MemberVO;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

@Service
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
		memberDAO.insertNewMember(member);
	}
	
	@Override
	public List<MemberVO> getMemberList() {
		return memberDAO.selectAllMemberList();
	}
	
	@Override
	public boolean findById(String memberId) {
		
		if(memberDAO.findById(memberId) != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String findByEmail(String memberEmail) {
		MemberVO member = memberDAO.findByEmail(memberEmail);
		if(memberDAO.findByEmail(memberEmail) != null) {
			return member.getMember_id();
		}
		else {
			return null;
		}
	}
	
	
	@Override
	public boolean isValidateEmail(String memberEmail) {
		
		if(memberDAO.findByEmail(memberEmail) != null) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public String findPassword(String member_id, String member_email) {
		MemberVO memberVO = memberDAO.findById(member_id);
		String newPassword = "";
		try {
			if(memberVO.getMember_email().equals(member_email))
			{
				memberVO.setMember_pw(makeRandomPassword(12));
				memberDAO.changePassword(memberVO);
				newPassword = memberVO.getMember_pw();
			}		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return newPassword;
	}

	public String makeRandomPassword(int randomNumberLength) {
		char[] characters = {
				'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
				'j', 'k', 'l', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1',
				'2', '3', '4', '5', '6', '7', '8', '9', 'A',
				'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P'};
		
		StringBuilder sb = new StringBuilder("");
		Random rn = new Random();
		int length = characters.length;
		
		for(int i=0; i<randomNumberLength; i++) sb.append(characters[rn.nextInt(length)]);
		return sb.toString();
		}

	@Override
	public boolean isValidatePw(String memberId, String memberPw) {
		String validatePw = memberDAO.findById(memberId).getMember_pw();
		if(validatePw.equals(memberPw)) return true;
		else return false;
	}

	@Override
	public int getMemberRole(MemberVO vo) {
		String grade = vo.getGrade();
		return Integer.parseInt(grade);
	}

}
