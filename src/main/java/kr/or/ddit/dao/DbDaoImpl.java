package kr.or.ddit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.model.DbVO;
import kr.or.ddit.mybatis.MyBatisUtil;

public class DbDaoImpl implements IDbDao{

	@Override
	public DbVO getDb(String uri) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		DbVO dbVO = sqlSession.selectOne("db.getDb", uri);
		sqlSession.close();
		return dbVO;
	}

	@Override
	public List<DbVO> getDbList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<DbVO> dbList = sqlSession.selectList("db.getDbList");
		sqlSession.close();
		return dbList;
	}
}
