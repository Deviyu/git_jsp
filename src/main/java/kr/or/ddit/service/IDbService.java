package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.model.DbVO;

public interface IDbService {
	DbVO getDb(String uri);
	
	List<DbVO> getDbList();
}
