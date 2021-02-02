package com.j2kb.member.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.j2kb.member.vo.MemberVO;

@RestController
@RequestMapping("/member")
public class MemberControllerImpl {
	
	//두 메소드 모두 rest api 테스트 용으로 작성하였습니다. 
	// 이 주석은 참고용입니다..!확인하시고 지우셔도 됩니다!
	//https://im-recording-of-sw-studies.tistory.com/35?category=885500
	//post방식은 데이터를 body에서 받아오기 때문에 RequsetBody어노테이션을 사용
	@RequestMapping(method= RequestMethod.POST, path="/addMember")
	public MemberVO addMember(@RequestBody MemberVO memberVO) {
		return memberVO;
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/getRequestApi")
	public String getRequestApi() {
		return "getRequestApi";
	}
	
}
