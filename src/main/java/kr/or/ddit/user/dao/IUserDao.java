package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.user.model.UserVO;

public interface IUserDao {
	/**
	* Method : userList
	* 작성자 : PC07
	* 변경이력 : 2019-05-24 처음 생성
	* @return
	* Method 설명 : 사용자 전체 조회
	*/
	List<UserVO> userList();
	
	/**
	* Method : getUser
	* 작성자 : PC07
	* 변경이력 : 2019-05-24 처음 생성
	* @param userId
	* @return
	* Method 설명 : 사용자 정보 조회
	*/
	UserVO getUser(String userId);
}
