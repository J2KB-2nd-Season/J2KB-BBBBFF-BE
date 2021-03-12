package com.j2kb.cart.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j2kb.cart.dao.CartDAO;
import com.j2kb.cart.vo.CartVO;


@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartDAO cartDAO;
	
	public void addToCart(CartVO cartVO) {
		int cartNum = cartDAO.selectCurrentCartNum();
		cartVO.setCartNum(cartNum);
		cartVO.setCartQuan(cartVO.getCartQuan());
		cartVO.setMemberId(cartVO.getMemberId());
		cartVO.setCartDate(Timestamp.valueOf(LocalDateTime.now()));
		cartVO.setProdNum(cartVO.getProdNum());
		cartDAO.insertNewCart(cartVO);
	}
	
	public List<CartVO> getCartList(String memberId){
		
		return null;
	}
	
}
