package kr.or.ddit.lprod.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.paging.model.PageVO;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LprodDaoTest {
	private static final Logger logger = LoggerFactory
			.getLogger(LprodDaoTest.class);
	
	ILprodDao dao;
	@Before
	public void setup() {
		dao = new LprodDaoImpl();
	}
	
	@Test
	public void lprodPagingListTest() {
		/***Given***/
		PageVO pageVO = new PageVO(1, 5);
		/***When***/
		List<LprodVO> lprodList = dao.lprodPagingList(pageVO);
		/***Then***/
		assertNotNull(lprodList);
		assertEquals(5, lprodList.size());
		logger.debug("lprodList : {}", lprodList);
	}
	
	@Test
	public void lprodsCntTest() {
		/***Given***/
		
		/***When***/
		int result = dao.lprodsCnt();
		/***Then***/
		assertEquals(9, result);
	}

}
