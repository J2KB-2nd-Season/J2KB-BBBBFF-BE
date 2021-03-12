package com.j2kb.cart.service;

import java.util.List;

import com.j2kb.cart.vo.CartVO;

public interface CartService {

	public void addToCart(CartVO cartVO);

	public List<CartVO> getCartList(String memberId);

	
}
