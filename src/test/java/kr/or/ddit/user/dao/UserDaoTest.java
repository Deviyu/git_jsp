package kr.or.ddit.user.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import kr.or.ddit.user.model.UserVO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDaoTest {
	private static final Logger logger = LoggerFactory
			.getLogger(UserDaoTest.class);
	
	private IUserDao userDao;
	// JUnit 실행 순서
	
	//@BeforeClass가 적용된 메서드가 1회 실행
	
	//----@Test가 적용된 모든 메서드에 대해 반복적용
	//@Before가 적용된 메서드 실행
	//@Test가 적용된 메서드 실행
	//@After가 적용된 메서드 실행
	
	//@AfterClass가 적용된 메서드가 1회 실행
	
	
	@BeforeClass
	public static void beforeClass() {
		logger.debug("beforeClass()");
	}
	
	@Before
	public void setup() {
		logger.debug("setup()");
		userDao = new UserDao();
	}
	
	@After
	public void teardown() {
		logger.debug("teardown()");
	}
	
	@AfterClass
	public static void afterClass() {
		logger.debug("afterClass()");
	}
	
	/**
	* Method : userListTest
	* 작성자 : PC07
	* 변경이력 : 2019-05-24 처음 생성
	* Method 설명 : 사용자 전체조회 테스트
	*/
	@Test
	public void userListTest() {
		/***Given***/
		
		/***When***/
		List<UserVO> userList = userDao.userList();
		/***Then***/
		assertEquals("brown", userList.get(0).getUserId());
		assertEquals(105, userList.size());
		logger.debug("userList : {}", userList);
	}
	
	/**
	* Method : getUserTest
	* 작성자 : PC07
	* 변경이력 : 2019-05-24 처음 생성
	* Method 설명 : 사용자 정보 조회 테스트
	*/
	@Test
	public void getUserTest(){
		/***Given***/
		String userId = "cony";
		/***When***/
		UserVO userVO = userDao.getUser(userId);
		/***Then***/
		assertEquals("cony1234", userVO.getPass());
		assertEquals("코니", userVO.getName());
		assertEquals("코니", userVO.getName());
		logger.debug("userVO : {}", userVO);
	}
	
	//사용자 페이징 리스트 조회
	// 고려사항
	//	- 몇 번째 페이지 조회인지?
	//	- 페이징 몇 건씩 데이터를 보여줄건지? : Query 실행 Parameter에 연관
	//	- 정렬 순서는? -> Parameter화 시킬 수 있다.
	//		--> 일단은 사용자 아이디 순으로 정렬한다.
	
}
