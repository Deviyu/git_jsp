package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.DbDaoImpl;
import kr.or.ddit.dao.IDbDao;
import kr.or.ddit.model.DbVO;

public class DbServiceImpl implements IDbService{
	
	private IDbDao dao;
	
	public DbServiceImpl() {
		dao = new DbDaoImpl();
	}
	
	@Override
	public DbVO getDb(String uri) {
		return dao.getDb(uri);
	}

	@Override
	public List<DbVO> getDbList() {
		return dao.getDbList();
	}

}
