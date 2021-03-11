package com.j2kb.cart.dao;

import com.j2kb.cart.vo.CartVO;

public interface CartDAO {

	public int selectCurrentCartNum();
	public void insertNewCart(CartVO cartVO);
}
