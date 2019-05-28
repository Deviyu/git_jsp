package kr.or.ddit.lprod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVO;

public class LprodDaoImpl implements ILprodDao {

	/**
	 * Method : lprodPagingList
	 * 작성자 : jakeh
	 * 변경이력 : 2019-05-27 처음 생성
	 * @param pageVO
	 * @return
	 * Method 설명 : 특정 페이지에 해당하는 Lprod 정보를 반환하는 메서드
	 */
	@Override
	public List<LprodVO> lprodPagingList(PageVO pageVO) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<LprodVO> lprodList = sqlSession.selectList("lprod.lprodPagingList", pageVO);
		sqlSession.close();
		return lprodList;
	}
	
	/**
	 * Method : lprodsCnt
	 * 작성자 : jakeh
	 * 변경이력 : 2019-05-27 처음 생성
	 * @return
	 * Method 설명 : LPROD테이블의 전체 레코드 수를 반환하는 메서드
	 */
	@Override
	public int lprodsCnt() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int lprodsCnt = sqlSession.selectOne("lprod.lprodsCnt");
		sqlSession.close();
		return lprodsCnt;
	}

}
