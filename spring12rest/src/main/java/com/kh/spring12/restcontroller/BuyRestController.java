package com.kh.spring12.restcontroller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring12.dao.BuyDao;
import com.kh.spring12.dto.BuyDetailDto;
import com.kh.spring12.dto.BuyDto;
import com.kh.spring12.error.TargetNotFoundException;
import com.kh.spring12.service.KakaoPayService;
import com.kh.spring12.service.TokenService;
import com.kh.spring12.vo.BuyTotalVO;
import com.kh.spring12.vo.ClaimVO;
import com.kh.spring12.vo.kakaopay.KakaoPayCancelResponseVO;
import com.kh.spring12.vo.kakaopay.KakaoPayCancelVO;
import com.kh.spring12.vo.kakaopay.KakaoPayOrderResponseVO;
import com.kh.spring12.vo.kakaopay.KakaoPayOrderVO;

@CrossOrigin
@RestController
@RequestMapping("/api/buy")
public class BuyRestController {

	@Autowired
	private BuyDao buyDao;
	@Autowired
	private TokenService tokenService;
	@Autowired
	private KakaoPayService kakaoPayService;

	@GetMapping("/")
	public List<BuyTotalVO> list(@RequestHeader("Authorization") String bearerToken) {
		ClaimVO claimVO = tokenService.parseBearerToken(bearerToken);
//		return buyDao.listTotalManual(cliamVO.getUserId());
		return buyDao.listTotalAuto(claimVO.getUserId());
	}

	@GetMapping("/{buyNo}") // 바람직한 방식(PK 사용)
	public KakaoPayOrderResponseVO order(@PathVariable long buyNo, @RequestHeader("Authorization") String bearerToken)
			throws URISyntaxException {
		ClaimVO claimVO = tokenService.parseBearerToken(bearerToken);
		BuyDto buyDto = buyDao.selectOne(buyNo);

		// 요청자와 구매자가 다르면 차단
		if (claimVO.getUserId().equals(buyDto.getBuyOwner()) == false)
			throw new TargetNotFoundException();

		return kakaoPayService.order(KakaoPayOrderVO.builder().tid(buyDto.getBuyTid()).build());
	}

//	@GetMapping("/buyTid/{buyTid}")
//	public KakaoPayOrderResponseVO order(@PathVariable String buyTid) throws URISyntaxException {
//		return kakaoPayService.order(KakaoPayOrderVO.builder()
//															.tid(buyTid)
//													.build());
//	}

//	DeleteMapping을 결제취소로 활용
	@DeleteMapping("/{buyNo}") // 전체취소
	public void cancelAll(@PathVariable long buyNo) throws URISyntaxException {
		// 상세조회
		BuyDto buyDto = buyDao.selectOne(buyNo);
		if (buyDto == null) // 결제내역이 없다면
			throw new TargetNotFoundException();
		if (buyDto.getBuyRemain() == 0) // 이미 다 취소되었다면
			throw new TargetNotFoundException();

		// 카카오페이 취소요청
		KakaoPayCancelResponseVO response = kakaoPayService
				.cancel(KakaoPayCancelVO.builder().tid(buyDto.getBuyTid()).cancelAmount(buyDto.getBuyRemain()).build());

		// Database 변경 (잔여금액을 0으로, 세부항목을 N으로)
		buyDao.updateBuy(buyNo, 0L);
		buyDao.cancelAll(buyNo);
	}

	@DeleteMapping("/buyDetail/{buyDetailNo}") // 부분취소
	public void cancelPart(@PathVariable long buyDetailNo) throws URISyntaxException {
		// 상세내역 조회
		BuyDetailDto buyDetailDto = buyDao.selectDetailOne(buyDetailNo);
		if (buyDetailDto == null)
			throw new TargetNotFoundException();

		// TID를 알아내기 위해 BuyDao를 구할 것
		BuyDto buyDto = buyDao.selectOne(buyDetailDto.getBuyDetailOrigin());

		// 카카오페이 취소 처리
		KakaoPayCancelResponseVO response = kakaoPayService.cancel(KakaoPayCancelVO.builder().tid(buyDto.getBuyTid())
				// .cancelAmount(buyDetailDto.getBuyDetailPrice() *
				// buyDetailDto.getBuyDetailQty())
				.cancelAmount(buyDetailDto.getTotalPrice()).build());

		// 항목 취소 처리
		buyDao.cancelDetail(buyDetailNo);

		// response에 있는 취소 가능 금액으로 buy_remain를 변경
		buyDao.updateBuy(buyDto.getBuyNo(), response.getCancelAvailableAmount().getTotal());
	}

}
