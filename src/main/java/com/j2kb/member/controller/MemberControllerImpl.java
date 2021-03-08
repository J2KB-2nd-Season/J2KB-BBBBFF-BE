package com.j2kb.member.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.j2kb.common.SecurityConstants;
import com.j2kb.member.service.MemberService;
import com.j2kb.member.vo.MemberVO;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


@RestController
public class MemberControllerImpl implements MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberControllerImpl.class);
	
	@Autowired
	private MemberService memberService;

	@RequestMapping(method = RequestMethod.POST, path = "/api/users/join")
	public Boolean addMember(@RequestBody MemberVO memberVO) throws Exception {
		memberService.addMember(memberVO);
		return true;
		
	}

	@RequestMapping(method = RequestMethod.GET, path = "/getRequestApi")
	public String getRequestApi() {
		return "getRequestApi";
	}
	
	@RequestMapping(method=RequestMethod.GET, path = "/getMemberList")
	public List<MemberVO> getMemberList() {
		List<MemberVO> list= memberService.getMemberList();
		return list;
	}
	
	/** �̸����� �Է¹ް�, �ش� �̸����� �ִٸ� �ش� �̸����� id�� �������ִ� �޼ҵ� **/
	//POST http://localhost:8081/member/api/users/find/id
	/*
	 * {
    		"member_email" : "admin@j2kb.dev"
		}
	 * 
	 */
	@RequestMapping(method=RequestMethod.POST, path="/api/users/find/id")
	public String findByEmail(@RequestBody Map<String,String> param) {
		String memberEmail = param.get("member_email");
		return memberService.findByEmail(memberEmail);
	}
	
	/** �̸��� �ߺ�Ȯ�ζ� ���� �޼ҵ� **/
	//  POST http://localhost:8081/member/api/users/validate/email�� �����Ͻð�
	/* json������ ��������
	 * {
    		"member_email" : "admin@j2kb.dev"
		}
	 	�̷��� �����ֽø� �˴ϴ�.
	 */ 
	@RequestMapping(method = RequestMethod.POST, path="/api/users/validate/email")
	public boolean isValidateEmail(@RequestBody Map<String,String> param){
		String memberEmail = param.get("member_email");
		return memberService.isValidateEmail(memberEmail);
	}
	
	/** ���̵� �ߺ�Ȯ�ζ� ���� �޼ҵ� **/
	// url�ڿ� ������Ʈ������ �˻� ��(���̵�, �̸��� �ƴ�) �����ָ� ��
	// GET /api/users/validate/id?memberId=�˻��� ���̵�
	// ���̵� �ߺ���ȸ�� get���� post���� �򰥷��� �ϴ� �� �޼ҵ�� get���� ���ܵξ�����
	// ����Ʈ�ܿ��� post�� �ߺ���ȸ ��û�� �״�� �ٲٰڽ��ϴ�!
	@RequestMapping(method = RequestMethod.GET, path="/api/users/validate/id")
	public boolean isValidateId(@RequestParam("memberId") String memberId){
		return memberService.findById(memberId);
	}
	
	
	
}
