package kr.or.ddit.lprod.service;

import java.util.Map;

import kr.or.ddit.paging.model.PageVO;

public interface ILprodService {
	/**
	 * Method : lprodPagingList
	 * 작성자 : jakeh
	 * 변경이력 : 2019-05-27 처음 생성
	 * @param Map
	 * @return Map<String, Object>
	 * Method 설명 : 특정 페이지에 해당하는 Lprod 정보를 반환하는 메서드
	 */
	Map<String, Object> lprodPagingList (PageVO pageVO);
	
}
