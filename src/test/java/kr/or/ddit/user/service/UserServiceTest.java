package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import kr.or.ddit.user.model.UserVO;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceTest {
	private static final Logger logger = LoggerFactory
			.getLogger(UserServiceTest.class);
	
	
	private IUserService userService;
	
	@Before
	public void setup() {
		userService = new UserService();
	}
	
	/**
	* Method : userListTest
	* 작성자 : PC07
	* 변경이력 : 2019-05-24 처음 생성
	* Method 설명 : 전체 사용자 조회 기능 테스트
	*/
	@Test
	public void userListTest() {
		/***Given***/
		/***When***/
		List<UserVO> userList = userService.userList();
		/***Then***/
		assertEquals("brown", userList.get(0).getUserId());
		assertEquals(105, userList.size());
		logger.debug("userList : {}", userList); 
	}
	
	/**
	* Method : getUserTest
	* 작성자 : PC07
	* 변경이력 : 2019-05-24 처음 생성
	* Method 설명 : 특정 사용자 정보조회 기능 테스트
	*/
	@Test
	public void getUserTest() {
		/***Given***/
		String userId = "cony";
		/***When***/
		UserVO userVO = userService.getUser(userId);
		/***Then***/
		assertEquals("cony", userVO.getUserId());
		assertEquals("토끼", userVO.getAlias());
		assertEquals("코니", userVO.getName());
		logger.debug("userVO : {}", userVO); 
	}
}
