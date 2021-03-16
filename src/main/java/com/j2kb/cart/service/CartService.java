package com.j2kb.cart.service;

import java.util.List;
import java.util.Map;

import com.j2kb.cart.vo.CartVO;

public interface CartService {

	public void addToCart(CartVO cartVO);

	public List<Map<String, Object>> getCartList(String memberId);


	
}
