package com.j2kb.member;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.j2kb.AppConfig;
import com.j2kb.member.dao.MemberDAO;
import com.j2kb.member.vo.MemberVO;

public class findbyIdTest {
	ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	MemberDAO dao = ac.getBean(MemberDAO.class);
	List<MemberVO> memlistForTest = null;
	
	@Test
	public void test1_findByIdTest() {
		System.out.println("[TEST START]findByIdTest");
		String member_id = "admin";
		MemberVO mem = dao.findById(member_id);
		System.out.println(mem.toString());
		Assert.assertEquals(mem.getMember_id(), member_id);
	}
}
