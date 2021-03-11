package com.j2kb.cart.vo;

public class CartVO {
	
	private String cartNum;
	private String cartQuan;
	private String prodNum;
	private String memberId;
	
	public CartVO() {
		
	}

	public CartVO(String cartNum, String cartQuan, String prodNum, String memberId) {
		super();
		this.cartNum = cartNum;
		this.cartQuan = cartQuan;
		this.prodNum = prodNum;
		this.memberId = memberId;
	}

	public String getCartNum() {
		return cartNum;
	}

	public void setCartNum(String cartNum) {
		this.cartNum = cartNum;
	}

	public String getCartQuan() {
		return cartQuan;
	}

	public void setCartQuan(String cartQuan) {
		this.cartQuan = cartQuan;
	}

	public String getProdNum() {
		return prodNum;
	}

	public void setProdNum(String prodNum) {
		this.prodNum = prodNum;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "CartVO [cartNum=" + cartNum + ", cartQuan=" + cartQuan + ", prodNum=" + prodNum + ", memberId="
				+ memberId + "]";
	}
	
	
	
}
