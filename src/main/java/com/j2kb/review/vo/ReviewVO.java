package com.j2kb.review.vo;

public class ReviewVO {
	
	private int reviewNum;
	private String reviewTitle;
	private String reviewContent;
	private String reviewImage;
	private String memberId;
	private int prodNum;
	private int reviewScore;
	
	public ReviewVO() {
		
	}
	
	public ReviewVO(int reviewNum,String reviewTitle, String reviewContent, String reviewImage,
			String memberId,int prodNum, int reviewScore) {
		super();
		this.reviewNum = reviewNum;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.reviewImage = reviewImage;
		this.prodNum = prodNum;
		this.memberId = memberId;
		this.reviewScore = reviewScore;
	}

	public int getReviewNum() {
		return reviewNum;
	}

	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getReviewImage() {
		return reviewImage;
	}

	public void setReviewImage(String reviewImage) {
		this.reviewImage = reviewImage;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getProdNum() {
		return prodNum;
	}

	public void setProdNum(int prodNum) {
		this.prodNum = prodNum;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	
	
	
	
	
	
	

}
