package kr.or.ddit.user.service;

import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.user.model.UserVO;

public class UserService implements IUserService{

	/**
	* Method : userList
	* 작성자 : PC07
	* 변경이력 : 2019-05-23 처음 생성
	* @return List<UserVO> userList
	* Method 설명 : 사용자 전체 리스트 조회
	*/
	@Override
	public List<UserVO> userList() {
		
		List<UserVO> userList = new ArrayList<>();
    	//Brown, Sally, James, Moon, Cony
    	userList.add(new UserVO("브라운", "brown", "곰"));
    	userList.add(new UserVO("샐리", "sally", "병아리"));
    	userList.add(new UserVO("코니", "cony", "토끼"));
    	userList.add(new UserVO("제임스", "james", "사람"));
    	userList.add(new UserVO("문", "moon", "달"));
		
		return userList;
	}
	
}
