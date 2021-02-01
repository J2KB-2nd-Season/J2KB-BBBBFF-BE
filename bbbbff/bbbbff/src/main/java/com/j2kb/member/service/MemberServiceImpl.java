package com.j2kb.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.j2kb.member.dao.MemberDAO;
import com.j2kb.member.vo.MemberVO;

@Component
@RequestMapping("/user")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public void addMember(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
		memberDAO.insertNewMember(member);
	}

	@Override
	public void isValidatePassword(String memberId, String inputPw) {
		// TODO Auto-generated method stub
		
	}

	
}
