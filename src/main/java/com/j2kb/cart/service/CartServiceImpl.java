package com.j2kb.cart.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j2kb.cart.dao.CartDAO;
import com.j2kb.cart.vo.CartVO;
import com.j2kb.product.vo.ProductVO;


@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartDAO cartDAO;
	
	Date d;

	SimpleDateFormat fm;

	@Override
	public void addToCart(CartVO cartVO) {
		d= new Date();
		fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = fm.format(d);
		int cartNum = cartDAO.selectCurrentCartNum();
		cartVO.setCartNum(cartNum);
		cartVO.setCartQuan(cartVO.getCartQuan());
		cartVO.setMemberId(cartVO.getMemberId());
		cartVO.setCartDate(now);
		cartVO.setProdNum(cartVO.getProdNum());
		cartDAO.insertNewCart(cartVO);
	}

	
	@Override
	public List<Map<String,Object>> getCartList(String memberId){
		
		List<Map<String, Object>> productList =  new ArrayList<Map<String, Object>>();
				
		productList = cartDAO.selectProductList(memberId);
		
		return productList;
	}


	@Override
	public List<Map<String, Object>> getSumCartList(String memberId) {
		
		List<Map<String, Object>> cartSumList =  new ArrayList<Map<String, Object>>();
		cartSumList = cartDAO.selectCartSumList(memberId);
		return cartSumList;
	}
	
}
