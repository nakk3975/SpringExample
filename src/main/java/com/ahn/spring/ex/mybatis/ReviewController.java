package com.ahn.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ahn.spring.ex.mybatis.bo.ReviewBO;
import com.ahn.spring.ex.mybatis.model.Review;

@Controller
@RequestMapping("/mybatis")
public class ReviewController {
	
	@Autowired
	public ReviewBO reviewBo;
	
	// id가 3인 데이터 조회
	@ResponseBody
	@RequestMapping("/ex01")
	public Review review(
			@RequestParam("id") int id
// 기본 사용법	@RequestParam(value="id", required = false) int id
// 기본값 설정	@RequestParam(value="id", defaultValue = "3") int id
			) {
		Review review = reviewBo.getReview(id);
		return review;
	}
	
	@ResponseBody
	@RequestMapping("/ex02")
	public String addReview() {
//		int count = reviewBo.addReview(4, "콤비네이션피자", "김인규", 4.5, "할인도 많이 받고 잘 먹었습니다.");
		Review review = new Review();
		review.setStoreId(2);
		review.setMenu("뿌링클");
		review.setUserName("김인규");
		review.setPoint(4.0);
		review.setReview("역시 뿌링클이 진리입니다!!");
		int count = reviewBo.addReviewByObject(review);
		return "삽입결과 " + count;
	}
	
}
