package kr.or.ddit.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import kr.or.ddit.model.DbVO;

import org.junit.Before;
import org.junit.Test;

public class DbDaoImplTest {
	
	IDbDao dao;
	
	@Before
	public void setup() {
		dao = new DbDaoImpl();
	}
	
	@Test
	public void getDbListTest() {
		/***Given***/
		
		/***When***/
		List<DbVO> dbList = dao.getDbList();
		/***Then***/
		assertNotNull(dbList);
		assertEquals(2, dbList.size());
	}

}
