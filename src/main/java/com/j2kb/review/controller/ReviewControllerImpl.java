package com.j2kb.review.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.j2kb.review.service.ReviewService;
import com.j2kb.review.vo.ReviewVO;

@RestController
@RequestMapping("/api/product")
public class ReviewControllerImpl implements ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	private static final Logger logger = LoggerFactory.getLogger(ReviewControllerImpl.class);

	@Override
	@RequestMapping(method = RequestMethod.POST, path = "/writeReview")
	public void writeReview(ReviewVO ReviewVO) {
		reviewService.writeReview(ReviewVO);
		
		
	}

}
