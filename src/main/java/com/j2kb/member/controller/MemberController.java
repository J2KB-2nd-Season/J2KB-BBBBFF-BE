package com.j2kb.member.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;

import com.j2kb.member.vo.MemberVO;

public interface MemberController {
	public String getRequestApi();
	public Boolean addMember(MemberVO memberVO) throws Exception;
	public List<MemberVO> getMemberList();
	public boolean isValidateEmail(Map<String,String> param);
	public boolean isValidateId(String memberId);
	public String changeToRandomPassword(Map<String,String> param);	
	public String findByEmail(Map<String,String> param);
}
