package com.j2kb.cart.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.j2kb.cart.vo.CartVO;
import com.j2kb.product.vo.ProductVO;

public interface CartDAO {

	public int selectCurrentCartNum();
	public void insertNewCart(CartVO cartVO);
	public List<CartVO> selectCartList(String memberId);
	public List<Map<String, Object>> selectProductList(String memberId);
}
