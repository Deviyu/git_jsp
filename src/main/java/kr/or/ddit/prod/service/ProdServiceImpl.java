package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.prod.model.ProdVO;

public class ProdServiceImpl implements IProdService{

	IProdDao prodDao;
	
	public ProdServiceImpl() {
		prodDao = new ProdDaoImpl();
	}
	
	/**
	 * Method : getProd
	 * 작성자 : jakeh
	 * 변경이력 : 2019-06-13 처음 생성
	 * @param prod_id
	 * @return
	 * Method 설명 : 특정 Prod 정보 조회 메서드
	 */
	@Override
	public ProdVO getProd(String prod_id) {
		return prodDao.getProd(prod_id);
	}
	
	/**
	 * Method : getProdListByLprod
	 * 작성자 : jakeh
	 * 변경이력 : 2019-06-13 처음 생성
	 * @param lprod_id
	 * @return
	 * Method 설명 : 특정 대분류에 속하는 정보 리스트 조회 메서드
	 */
	@Override
	public List<ProdVO> getProdListByLprod(String lprod_id) {
		return prodDao.getProdListByLprod(lprod_id);
	}
	
}
