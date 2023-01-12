package com.ahn.spring.ex.database.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahn.spring.ex.database.dao.UsedGoodsDAO;
import com.ahn.spring.ex.database.model.UsedGoods;

@Service
public class UsedGoodsBo {
	
	@Autowired
	private UsedGoodsDAO usedGoodsDAO;
	
	// used_goods 테이블을 전체 데이터 조회기능
	public List<UsedGoods> getUsedGoodsList() {
		List<UsedGoods> usedGoodsList = usedGoodsDAO.selectUsedGoodsList();
		return usedGoodsList;
	}
}
