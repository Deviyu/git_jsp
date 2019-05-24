package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.model.UserVO;

public interface IUserService {
	
	/**
	* Method : userList
	* 작성자 : PC07
	* 변경이력 : 2019-05-23 처음 생성
	* @return List<UserVO> userList
	* Method 설명 : 사용자 전체 리스트 조회
	*/
	List<UserVO> userList();
	
	/**
	* Method : getUser
	* 작성자 : PC07
	* 변경이력 : 2019-05-24 처음 생성
	* @param userId
	* @return
	* Method 설명 : 특정 사용자 정보 조회
	*/
	UserVO getUser(String userId);
}
