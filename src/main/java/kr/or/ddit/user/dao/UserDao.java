package kr.or.ddit.user.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.user.model.UserVO;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDao implements IUserDao{
	private static final Logger logger = LoggerFactory
			.getLogger(UserDao.class);
	
	public static void main(String[] args) {
		/***Given***/
		IUserDao userDao = new UserDao();
		
		/***When***/
		UserVO userVO = userDao.getUser("brown");
		
		/***Then***/
		logger.debug("userVO : {}", userVO);
	}

	/**
	* Method : userList
	* 작성자 : PC07
	* 변경이력 : 2019-05-24 처음 생성
	* @return List<UserVO>
	* Method 설명 : 사용자 전체 조회
	*/
	@Override
	public List<UserVO> userList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<UserVO> userList = sqlSession.selectList("user.userList");
		return userList;
	}
	
	/**
	* Method : getUser
	* 작성자 : PC07
	* 변경이력 : 2019-05-24 처음 생성
	* @param userId
	* @return UserVO
	* Method 설명 : 사용자 정보 조회
	*/
	@Override
	public UserVO getUser(String userId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserVO userVO = sqlSession.selectOne("user.getUser", userId);
		return userVO;
	}
}
