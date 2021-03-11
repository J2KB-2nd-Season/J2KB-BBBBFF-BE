package com.j2kb.member.dao;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.j2kb.member.controller.MemberControllerImpl;
import com.j2kb.member.vo.MemberVO;

@Component
public class MemberDAOImpl implements MemberDAO {
	private static SqlSessionFactory sqlMapper=null;
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	public static SqlSessionFactory getInstance() {
		if(sqlMapper==null) {
			try {
				String resource = "SqlMapConfig.xml";
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
	public void insertNewMember(MemberVO memberVO) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.insert("mapper.member.insertNewMember",memberVO);
		session.commit();
		session.close();
	}

	@Override
	public List<MemberVO> selectAllMemberList() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<MemberVO> memlist = null;
		memlist = session.selectList("mapper.member.selectAllMemberList");
		return memlist;
	}

	@Override
	public void deleteMember(String member_id) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.insert("mapper.member.deleteMember", member_id);
		session.commit();
		session.close();
	}

	@Override
	public MemberVO findById(String member_id) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<MemberVO> memlist = null;
		memlist = session.selectList("mapper.member.findById", member_id);
		if(memlist.size() >= 1) {
			return memlist.get(0);
		}else {
			return null;
		}
	}
	
	@Override
	public MemberVO findByEmail(String member_email) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<MemberVO> memlist = null;
		memlist = session.selectList("mapper.member.findByEmail", member_email);
		if(memlist.size() >= 1) {
			return memlist.get(0);
		}else {
			return null;
		}
	}
	
	@Override
	public void changePassword(MemberVO memberVO) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.update("mapper.member.changePassword", memberVO);
		session.commit();
		session.close();
	}
}
