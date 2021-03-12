package com.j2kb.cart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import com.j2kb.cart.vo.CartVO;

public interface CartController {

	public ResponseEntity<String> addToCart(CartVO cartVO);
	public Map<String, List> getCartList2(String memberId);
	public List<Map<String, Object>> getCartList(String memberId);
}
