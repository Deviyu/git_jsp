package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVO;

public class UserService implements IUserService{
	IUserDao dao;
	
	public UserService() {
		dao = new UserDao();
	}
	
	
	/**
	* Method : userList
	* 작성자 : PC07
	* 변경이력 : 2019-05-23 처음 생성
	* 			 2019-05-24 Dao와 연결
	* @return List<UserVO> userList
	* Method 설명 : 사용자 전체 리스트 조회
	*/
	@Override
	public List<UserVO> userList() {
    	List<UserVO> userList = null;
		
    	userList = dao.userList();
    			
		return userList;
	}


	/**
	* Method : getUser
	* 작성자 : PC07
	* 변경이력 : 2019-05-24 처음 생성
	* @param userId
	* @return
	* Method 설명 : 특정 사용자 정보 조회
	*/
	@Override
	public UserVO getUser(String userId) {
		UserVO userVO = null;
		
		userVO = dao.getUser(userId);
		
		return userVO;
	}
	
}
