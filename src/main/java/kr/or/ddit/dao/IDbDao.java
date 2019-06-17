package kr.or.ddit.dao;

import java.util.List;

import kr.or.ddit.model.DbVO;

public interface IDbDao {
	DbVO getDb(String uri);
	
	List<DbVO> getDbList();
}
