package kr.or.ddit.lprod.dao;

import java.util.List;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.paging.model.PageVO;

public interface ILprodDao {
	
	/**
	 * Method : lprodPagingList
	 * 작성자 : jakeh
	 * 변경이력 : 2019-05-27 처음 생성
	 * @param pageVO
	 * @return
	 * Method 설명 : 특정 페이지에 해당하는 Lprod 정보를 반환하는 메서드
	 */
	List<LprodVO> lprodPagingList (PageVO pageVO);
	
	
	
	/**
	 * Method : lprodsCnt
	 * 작성자 : jakeh
	 * 변경이력 : 2019-05-27 처음 생성
	 * @return
	 * Method 설명 : LPROD테이블의 전체 레코드 수를 반환하는 메서드
	 */
	int lprodsCnt();
}
