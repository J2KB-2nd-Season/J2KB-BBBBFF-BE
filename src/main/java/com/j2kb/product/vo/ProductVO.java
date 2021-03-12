package com.j2kb.product.vo;

public class ProductVO {
	
	private int prodNum;
	private String prodName;
	private String prodPrice;
	private int prodStock;
	private String prodImage; //image url
	private String prodDetail; 
	private int categoryNum; // 1: business card 2: sticker
	
	public ProductVO() {

	}

	
	public ProductVO(int prodNum, String prodName, String prodPrice, int prodStock, String prodImage, String prodDetail,
			int categoryNum) {
		super();
		this.prodNum = prodNum;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodStock = prodStock;
		this.prodImage = prodImage;
		this.prodDetail = prodDetail;
		this.categoryNum = categoryNum;
	}



	public int getProdNum() {
		return prodNum;
	}

	public void setProdNum(int prodNum) {
		this.prodNum = prodNum;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(String prodPrice) {
		this.prodPrice = prodPrice;
	}

	public int getProdStock() {
		return prodStock;
	}

	public void setProdStock(int prodStock) {
		this.prodStock = prodStock;
	}

	public String getProdImage() {
		return prodImage;
	}

	public void setProdImage(String prodImage) {
		this.prodImage = prodImage;
	}

	public String getProdDetail() {
		return prodDetail;
	}

	public void setProdDetail(String prodDetail) {
		this.prodDetail = prodDetail;
	}

	public int getCategoryNum() {
		return categoryNum;
	}

	public void setCategoryNum(int categoryNum) {
		this.categoryNum = categoryNum;
	}


	@Override
	public String toString() {
		return "ProductVO [prodNum=" + prodNum + ", prodName=" + prodName + ", prodPrice=" + prodPrice + ", prodStock="
				+ prodStock + ", prodImage=" + prodImage + ", prodDetail=" + prodDetail + ", categoryNum=" + categoryNum
				+ "]";
	}
	
	
	
	
}
