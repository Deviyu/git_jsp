package kr.or.ddit.lprod.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.paging.model.PageVO;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LprodServiceTest {
	private static final Logger logger = LoggerFactory
			.getLogger(LprodServiceTest.class);
	
	ILprodService service;
	@Before
	public void setup() {
		service = new LprodServiceImpl();
	}
	
	@Test
	public void lprodPagingListTest() {
		/***Given***/
		PageVO pageVO = new PageVO(1, 5);
		/***When***/
		Map<String, Object> resultMap = service.lprodPagingList(pageVO);
		List<LprodVO> pagingList = (List<LprodVO>) resultMap.get("pagingList");
		int paginationSize = (int) resultMap.get("paginationSize");
		/***Then***/
		assertEquals(2, paginationSize);
		assertNotNull(pagingList);
		assertEquals(5, pagingList.size());
		logger.debug("paginationSize : {}",paginationSize);
		logger.debug("pagingList : {}", pagingList);
	}
}
