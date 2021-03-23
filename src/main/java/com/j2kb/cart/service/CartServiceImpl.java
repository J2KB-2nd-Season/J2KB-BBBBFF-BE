package com.j2kb.cart.service;




import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j2kb.cart.dao.CartDAO;
import com.j2kb.cart.vo.CartVO;


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
		
		int count = cartDAO.selectCount(cartVO);
		if(count == 0) {
			int cartNum = cartDAO.selectNextCartNum();
			cartVO.setCartNum(cartNum);
			cartVO.setCartQuan(cartVO.getCartQuan());
			cartVO.setMemberId(cartVO.getMemberId());
			cartVO.setCartDate(now);
			cartVO.setProdNum(cartVO.getProdNum());
			cartDAO.insertNewCart(cartVO);
		}
		else {
			int newQuan =cartVO.getCartQuan();
			cartVO.setCartQuan(newQuan);
			cartVO.setMemberId(cartVO.getMemberId());
			cartVO.setProdNum(cartVO.getProdNum());
			cartVO.setCartDate(now);
			cartDAO.updateCartQuan(cartVO);
		}
	}

	
	@Override
	public List<Map<String,Object>> getCartList(String memberId){
		
		List<Map<String, Object>> productList =  new ArrayList<Map<String, Object>>();
				
		productList = cartDAO.selectProductList(memberId);
		
		return productList;
	}
	
	@Override
	public void deleteCart(HashMap map) {
		cartDAO.deleteCart(map);
	}


	
}
