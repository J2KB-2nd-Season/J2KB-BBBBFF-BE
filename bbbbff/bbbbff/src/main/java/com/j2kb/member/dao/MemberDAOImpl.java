package com.j2kb.member.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import com.j2kb.member.vo.MemberVO;

@Component
public class MemberDAOImpl implements MemberDAO {

	// 참조 : 자바 웹을 다루는 기술 23.3.2 마이바티스를 이용한 회원 정보 조회 실습
	private static SqlSessionFactory sqlMapper=null;
	public static SqlSessionFactory getInstance() {
		if(sqlMapper==null) {
			try {
				String resource = "mybatis/SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;
	}
	
	@Override
	public void insertNewMember(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.insert("mapper.member.insertNewMember");
	}

	@Override
	public List<MemberVO> selectAllMemberList() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<MemberVO> memlist = null;
		memlist = session.selectList("mapper.member.selectAllMemberList");
		return memlist;
	}
	
}
