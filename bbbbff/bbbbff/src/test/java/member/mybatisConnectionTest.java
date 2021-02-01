package member;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.j2kb.AutoAppConfig;
import com.j2kb.member.dao.MemberDAO;
import com.j2kb.member.vo.MemberVO;

public class mybatisConnectionTest {
	ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
	List<MemberVO> memlistForTest = null;
	MemberDAO memberDao = ac.getBean(MemberDAO.class);
	
	@Test
	public void printList() {
		System.out.println("[TEST START]memberDao.selectAllMemberList()");
		memlistForTest = memberDao.selectAllMemberList();
		for(MemberVO mem : memlistForTest) {
			System.out.println(mem.toString());
		}
		System.out.println("[RESULT] DB의 MEMBERS의 모든 멤버가 출력되었다면 정상 동작입니다. ");
	}
}
