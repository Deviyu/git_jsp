package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.prod.model.ProdVO;

public interface IProdDao {
	
	/**
	 * Method : getProd
	 * 작성자 : jakeh
	 * 변경이력 : 2019-06-13 처음 생성
	 * @param prod_id
	 * @return
	 * Method 설명 : 특정 Prod 정보 조회 메서드
	 */
	ProdVO getProd(String prod_id);
	
	/**
	 * Method : getProdListByLprod
	 * 작성자 : jakeh
	 * 변경이력 : 2019-06-13 처음 생성
	 * @param lprod_id
	 * @return
	 * Method 설명 : 특정 대분류에 속하는 정보 리스트 조회 메서드
	 */
	List<ProdVO> getProdListByLprod(String lprod_id);

}
