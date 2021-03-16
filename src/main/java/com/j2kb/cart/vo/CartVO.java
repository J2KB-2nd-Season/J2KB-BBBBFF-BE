package com.j2kb.cart.vo;

public class CartVO {
	
	private int cartNum;
	private int cartQuan;
	private int prodNum;
	private String memberId;
	private String cartDate;
	
	public CartVO() {

	}
	
	
	public CartVO(int cartNum, int cartQuan, int prodNum, String memberId, String cartDate) {
		super();
		this.cartNum = cartNum;
		this.cartQuan = cartQuan;
		this.prodNum = prodNum;
		this.memberId = memberId;
		this.cartDate = cartDate;
	}


	public int getCartNum() {
		return cartNum;
	}
	public void setCartNum(int cartNum) {
		this.cartNum = cartNum;
	}
	public int getCartQuan() {
		return cartQuan;
	}
	public void setCartQuan(int cartQuan) {
		this.cartQuan = cartQuan;
	}
	public int getProdNum() {
		return prodNum;
	}
	public void setProdNum(int prodNum) {
		this.prodNum = prodNum;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getCartDate() {
		return cartDate;
	}
	public void setCartDate(String cartDate) {
		this.cartDate = cartDate;
	}


	@Override
	public String toString() {
		return "CartVO [cartNum=" + cartNum + ", cartQuan=" + cartQuan + ", prodNum=" + prodNum + ", memberId="
				+ memberId + ", cartDate=" + cartDate + "]";
	}
	
	
}
