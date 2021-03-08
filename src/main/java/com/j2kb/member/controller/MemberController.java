package com.j2kb.member.controller;

import java.util.List;
import java.util.Map;
import com.j2kb.member.vo.MemberVO;

public interface MemberController {

	public String getRequestApi();

	public Boolean addMember(MemberVO memberVO) throws Exception;
	
	public List<MemberVO> getMemberList();
	
	public boolean findByEmail(Map<String,String> param);
	
	public boolean isValidateId(String memberId);

}
