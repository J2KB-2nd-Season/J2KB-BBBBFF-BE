package com.j2kb.member.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.j2kb.member.vo.MemberVO;

@Service
public class AuthService {

	public String getMemberIdFromCookie(HttpServletRequest request) {
		String member_id = "";
		String nullString = "";
		
		Cookie[] cookies = request.getCookies();
		String memberKey = "member_id";
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				System.out.println("Cookie Name:"+cookie.getName());
				if(cookie.getName().equals(memberKey)) {
					member_id = cookie.getValue();
				}
			}
		} else return nullString;
		
		if(member_id.equals(nullString)) return nullString;
		else return member_id;
	}
	
	public String getMemberVoFromSession(HttpSession session) {
		return (String)session.getAttribute("name");
	}
	
	public Boolean checkIsAdmin(MemberVO vo) {
		Boolean isAdmin = false;
		String gradeAdmin = "0";		
		if(vo.getGrade().equals(gradeAdmin)) isAdmin=true;	
		return isAdmin;
	}
	
	public Boolean checkIsAuth(MemberVO vo, HttpServletRequest request) {
		Boolean isAuth = false;
		String member_id = vo.getMember_id();
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getValue().equals(member_id)) {
					isAuth = true;
				}
			}
		}
		return isAuth;
	}
}
