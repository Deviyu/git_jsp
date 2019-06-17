package kr.or.ddit.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import kr.or.ddit.model.DbVO;

import org.junit.Before;
import org.junit.Test;

public class DbServiceImplTest {
	
	private IDbService service;
	
	@Before
	public void setup() {
		service = new DbServiceImpl();
	}
	
	@Test
	public void getDbListTest() {
		/***Given***/
		
		/***When***/
		List<DbVO> dbList = service.getDbList();
		/***Then***/
		assertNotNull(dbList);
		assertEquals(2, dbList.size());
	}

}
