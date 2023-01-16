package com.ahn.spring.ex.mybatis.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahn.spring.ex.mybatis.dao.ReviewDAO;
import com.ahn.spring.ex.mybatis.model.Review;

@Service
public class ReviewBO {
	
	@Autowired
	public ReviewDAO reviewDao;
	
	// 파라미터로 전달 받은 id 데이터 조회
	public Review getReview(int id) {
		Review review = reviewDao.selectReview(id);
		return review;
	}
	
	public int addReview(
			int storeId
			, String menu
			, String userName
			, double point
			, String review) {
		return reviewDao.insertReview(storeId, menu, userName, point, review);
	}
	
	public int addReviewByObject(Review review) {
		return reviewDao.insertReviewByObject(review);
	}
}
