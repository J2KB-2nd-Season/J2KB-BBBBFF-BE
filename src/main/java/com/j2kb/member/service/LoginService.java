package com.j2kb.member.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j2kb.member.dao.MemberDAO;
import com.j2kb.member.vo.MemberVO;

@Service
public class LoginService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public int userLoginService(String id, String pw, HttpSession httpSession,
			HttpServletRequest request, HttpServletResponse response) {
		int result;
		MemberVO vo = memberDAO.findById(id);
		if(vo == null) {
			result = -1; // no member with such id
			return result;
		}
		
		if(isValidateLogin(vo.getMember_id(),pw)) {
			Cookie[] cookies = request.getCookies();
			Cookie userCookie = null;
			if(cookies != null) {
				for(Cookie cookie : cookies) {
					if(cookie.getValue().equals(id)) {
						result = 1;
						return result; // cookie already exists
					}
				}
			}
			userCookie = new Cookie("member_id", id);
			response.addCookie(userCookie);
			userCookie.setMaxAge(60*60);
			result = 0;
		}
		else return -1;
		
		return result;
	}
	
	public boolean isValidateLogin(String originPw, String pw) {
		if((memberDAO.findById(originPw).getMember_pw()).equals(pw)) return true;
		else return false;
	}
}
