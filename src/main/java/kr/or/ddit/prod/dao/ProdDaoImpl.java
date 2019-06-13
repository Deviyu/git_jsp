package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.prod.model.ProdVO;

import org.apache.ibatis.session.SqlSession;

public class ProdDaoImpl implements IProdDao {
	
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
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		ProdVO prodVO = sqlSession.selectOne("prod.getProd", prod_id);
		sqlSession.close();
		return prodVO;
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
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<ProdVO> prodList = sqlSession.selectList("prod.getProdListByLprod", lprod_id);
		sqlSession.close();
		return prodList;
	}

}
