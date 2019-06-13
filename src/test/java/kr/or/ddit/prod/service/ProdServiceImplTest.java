package kr.or.ddit.prod.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import kr.or.ddit.prod.model.ProdVO;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProdServiceImplTest {
	IProdService prodService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(ProdServiceImplTest.class);
	@Before
	public void setup() {
		prodService = new ProdServiceImpl();
	}
	
	/**
	 * Method : getProdTest
	 * 작성자 : jakeh
	 * 변경이력 : 2019-06-13 처음 생성
	 * Method 설명 : 상품코드를 이용한 상품정보 조회 테스트 메서드
	 */
	@Test
	public void getProdTest() {
		/***Given***/
		String prod_id = "P201000001";
		/***When***/
		ProdVO prodVO = prodService.getProd(prod_id);
		/***Then***/
		assertNotNull(prodVO);
		logger.debug("prodVO : {}", prodVO);
	}
	
	/**
	 * Method : getProdListByLprodTest
	 * 작성자 : jakeh
	 * 변경이력 : 2019-06-13 처음 생성
	 * Method 설명 : 대분류코드를 이용한 상품목록 조회 테스트 메서드
	 */
	@Test
	public void getProdListByLprodTest() {
		/***Given***/
		String lprod_id = "P201";
		/***When***/
		List<ProdVO> prodList = prodService.getProdListByLprod(lprod_id);
		/***Then***/
		assertNotNull(prodList);
		assertEquals(21, prodList.size());
		logger.debug("prodList : {}", prodList);
		
	}
}
