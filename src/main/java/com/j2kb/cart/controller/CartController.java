package com.j2kb.cart.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.j2kb.cart.vo.CartVO;

public interface CartController {

	public ResponseEntity<String> addToCart(CartVO cartVO);
	public List<CartVO> getCartList(String memberId);
}
