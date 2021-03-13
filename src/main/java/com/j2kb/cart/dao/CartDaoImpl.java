package com.j2kb.cart.dao;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.j2kb.cart.vo.CartVO;



@Component
public class CartDAOImpl implements CartDAO{
	
	private static SqlSessionFactory sqlMapper=null;
	private static final Logger logger = LoggerFactory.getLogger(CartDAOImpl.class);
	
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
	public void insertNewCart(CartVO cartVO) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.insert("mapper.cart.insertNewCart",cartVO);
		session.commit();
		session.close();
	}
	
	@Override
	public int selectNextCartNum() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		int cartNum = session.selectOne("mapper.cart.selectNextCartNum");
		return cartNum;
	}
	
	@Override
	public List<CartVO> selectCartList(String memberId){
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<CartVO> cartList = session.selectList("mapper.cart.selectCartList", memberId);
		return cartList;
	}


	@Override
	public List<Map<String, Object>> selectProductList(String memberId) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<Map<String, Object>> productList2 = session.selectList("mapper.cart.selectProductList", memberId);
		return productList2;
	}

	
	@Override
	public int selectCount(CartVO cartVO) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		int count = session.selectOne("mapper.cart.selectCount",cartVO);
		return count;
	}

	@Override
	public int selectCurrentCartNum(CartVO cartVO) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		int cartNum = session.selectOne("mapper.cart.selectCurrentCartNum",cartVO);
		return cartNum;
	}

	@Override
	public void updateCartQuan(CartVO cartVO) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.selectOne("mapper.cart.updatePlusQuan",cartVO);
		session.commit();
		session.close();
		
	}
	
	
}
