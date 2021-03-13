package com.j2kb.cart.dao;

import java.util.List;
import java.util.Map;
import com.j2kb.cart.vo.CartVO;


public interface CartDAO {

	public int selectNextCartNum();
	public void insertNewCart(CartVO cartVO);
	public List<CartVO> selectCartList(String memberId);
	public List<Map<String, Object>> selectProductList(String memberId);
	public List<Map<String, Object>> selectCartSumList(String memberId);
	public int selectCount(CartVO cartVO);
	public int selectCurrentCartNum(CartVO cartVO);
	public void updateCartQuan(CartVO cartVO);

}
