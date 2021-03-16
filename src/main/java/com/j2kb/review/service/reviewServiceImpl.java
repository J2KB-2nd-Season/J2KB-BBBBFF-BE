package com.j2kb.review.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j2kb.review.dao.ReviewDao;
import com.j2kb.review.vo.ReviewVO;

@Service
public class ReviewServiceImpl implements ReviewService{
	@Autowired
	private ReviewDao reviewDao;

	@Override
	public void writeReview(ReviewVO ReviewVO) {
		reviewDao.writeReview(ReviewVO);
		
	}

}
