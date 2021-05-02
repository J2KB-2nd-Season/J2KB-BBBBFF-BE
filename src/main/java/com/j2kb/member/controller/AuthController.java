package com.j2kb.member.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.j2kb.member.dao.MemberDAO;
import com.j2kb.member.service.AuthService;
import com.j2kb.member.service.MemberService;
import com.j2kb.member.vo.MemberVO;

@RestController
@RequestMapping("/api/users")
public class AuthController {
	
	@Autowired
	AuthService authService;
	
	@Autowired
	MemberDAO memberDAO;
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(method = RequestMethod.GET, path="/auth")
	@ResponseBody
	public Map<String, Object> authCheck(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		String member_id="";

		member_id = authService.getMemberIdFromCookie(request);
	
		MemberVO vo = memberDAO.findById(member_id);
		
		HttpSession session = request.getSession();
		Boolean isAdmin = (vo == null || session == null) ? false : authService.checkIsAdmin(vo);
		Boolean isAuth = (vo==null || session == null) ? false : authService.checkIsAuth(vo, request);
		String email = (vo == null || session == null) ? "" : vo.getMember_email();
		String name = (vo==null || session == null) ? "" : vo.getMember_name();
		int role = (vo==null || session == null) ? -1 : memberService.getMemberRole(vo);
		

		result.put("isAdmin",isAdmin);
		result.put("isAuth",isAuth);
		result.put("email",email);
		result.put("name",name);
		result.put("role",role);
		
		return result;
	}
}
