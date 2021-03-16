package com.j2kb.review.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.j2kb.member.dao.MemberDAOImpl;

public class ReviewDaoImpl implements ReviewDao {

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
}
