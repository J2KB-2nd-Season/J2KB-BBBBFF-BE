package com.j2kb.member.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.j2kb.member.service.LoginService;
import com.j2kb.member.vo.MemberVO;

@RestController
@RequestMapping("/api/users")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(method = RequestMethod.POST, path = "/login")
	@ResponseBody
	public Map<String, Object> userLoginPass(@RequestBody Map<String, String> param, 
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> result = new HashMap<String, Object>();
		String memberId = param.get("member_id");
		String memberPw = param.get("member_pw");

		HttpSession httpSession = request.getSession();
		int status = loginService.userLoginService(memberId, memberPw, httpSession, request, response);

		result.put("member_id", memberId);
		result.put("status", status);

		return result;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/logout")
	public Map<String, Object> userLogout(HttpSession session, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		Boolean logoutSuccess;
		session.invalidate();
		logoutSuccess = loginService.userLogoutService(session, request);
		result.put("logoutOk", logoutSuccess);
		return result;
	}

}
