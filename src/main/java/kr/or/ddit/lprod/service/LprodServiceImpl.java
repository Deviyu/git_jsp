package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.paging.model.PageVO;

public class LprodServiceImpl implements ILprodService {

	ILprodDao dao;
	
	public LprodServiceImpl() {
		dao = new LprodDaoImpl();
	}
	
	/**
	 * Method : lprodPagingList
	 * 작성자 : jakeh
	 * 변경이력 : 2019-05-27 처음 생성
	 * @param Map
	 * @return Map<String, Object>
	 * Method 설명 : 특정 페이지에 해당하는 Lprod 정보를 반환하는 메서드
	 */
	@Override
	public Map<String, Object> lprodPagingList(PageVO pageVO) {
		Map<String, Object> resultMap = new HashMap<>();
		List<LprodVO> pagingList = dao.lprodPagingList(pageVO);
		int lprodsCnt = dao.lprodsCnt();
		int paginationSize = (int)(Math.ceil((double)lprodsCnt/pageVO.getPageSize()));
		resultMap.put("pagingList", pagingList);
		resultMap.put("paginationSize", paginationSize);
		return resultMap;
	}

}
