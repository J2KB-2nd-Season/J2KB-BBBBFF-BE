package com.j2kb.member;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.j2kb.AppConfig;
import com.j2kb.member.dao.MemberDAO;
import com.j2kb.member.vo.MemberVO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class memberJoinTest {
	
	ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	MemberDAO dao = ac.getBean(MemberDAO.class);
	List<MemberVO> memlistForTest = null;
	
	@Test
	public void test1_insertNewMemberTest() {
		System.out.println("[TEST START]insertNewMemberTest");
		MemberVO vo = new MemberVO("testId03", "testPw", "testName", "testAdrs",
				"testEmail", "testPhone", "0");
		dao.insertNewMember(vo);
		printList();
	}
	
	@Test
	public void test2_deleteMemberTest() {
		System.out.println("[TEST START]deleteMemberTest");
		String member_id = "testId03";
		dao.deleteMember(member_id);
		printList();
	}
	
	public void printList() {
		System.out.println("[TEST START]memberDao.selectAllMemberList()");
		memlistForTest = dao.selectAllMemberList();
		for(MemberVO mem : memlistForTest) {
			System.out.println(mem.toString());
		}
		System.out.println("[RESULT] DB의 MEMBERS의 모든 멤버가 출력되었다면 정상 동작입니다. ");
	}
}
