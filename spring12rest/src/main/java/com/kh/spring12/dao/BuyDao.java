package com.kh.spring12.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring12.dto.BuyDetailDto;
import com.kh.spring12.dto.BuyDto;
import com.kh.spring12.vo.BuyTotalVO;

@Repository
public class BuyDao {

	@Autowired
	private SqlSession sqlSession;
	
	public long addBuy(BuyDto buyDto) {
		long buyNo = sqlSession.selectOne("buy.buySequence");
		buyDto.setBuyNo(buyNo);
		sqlSession.insert("buy.addBuy", buyDto);
		return buyNo;
	}
	
	public long addBuyDetail(BuyDetailDto buyDetailDto) {
		long buyDetailNo = sqlSession.selectOne("buy.buyDetailSequence");
		buyDetailDto.setBuyDetailNo(buyDetailNo);
		sqlSession.insert("buy.addBuyDetail", buyDetailDto);
		return buyDetailNo;
	}
	
	public List<BuyDto> listBuy() {
		return sqlSession.selectList("buy.listBuy");
	}
	
	public List<BuyDetailDto> listBuyDetail(long buyDetailOrigin){
		return sqlSession.selectList("buy.listBuyDetail", buyDetailOrigin);
	}
	
	public List<BuyTotalVO> listTotalManual() { //수동으로 만들어서 목록 조회
		List<BuyTotalVO> results = new ArrayList<>(); //결제 대표정보(BuyDto)의 갯수와 같음. 다만, 대표정보와 상세정보가 합쳐짐
 		
		List<BuyDto> list = this.listBuy();
		for(BuyDto buyDto : list) {
			List<BuyDetailDto> details = this.listBuyDetail(buyDto.getBuyNo());
			
			BuyTotalVO vo = new BuyTotalVO();
			vo.setBuyDto(buyDto);
			vo.setBuyList(details);
			
			results.add(vo);
		}
		return results;
	}
	
	public List<BuyTotalVO> listTotalAuto() {
		return sqlSession.selectList("buy.listBuyAuto");
	}
	public List<BuyTotalVO> listTotalAuto(String userId) {
		return sqlSession.selectList("buy.listBuyAuto", userId);
	}
	
	public BuyDto selectOne(long buyNo) {
		return sqlSession.selectOne("buy.findBuy", buyNo);
	}
	
	public BuyDetailDto selectDetailOne(long buyDetailNo) {
		return sqlSession.selectOne("buy.findDetail", buyDetailNo);
	}
//	public boolean cancelAll(long buyNo) {
	public boolean cancelAll(long buyDetailOrigin) {
		return sqlSession.update("buy.cancelAll", buyDetailOrigin) > 0;
	}
	public boolean cancelDetail(long buyDetailNo) {
		return sqlSession.update("buy.cancelPart", buyDetailNo) > 0;
	}
	public boolean updateBuy(long buyNo, long buyRemain) {
		Map<String, Object> params = new HashMap<>();
		params.put("buyNo", buyNo);
		params.put("buyRemain", buyRemain);
		return sqlSession.update("buy.updateBuy", params) > 0;
	}
}
