package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVO;
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

	/**
	 * Method : userPagingList
	 * 작성자 : jakeh
	 * 변경이력 : 2019-05-27 처음 생성
	 * @param page
	 * @param pageList
	 * @return 
	 * Method 설명 : 특정 페이지의 사용자 정보 조회
	 */
	@Override
	public Map<String, Object> userPagingList(PageVO pageVO) {
		//1. List<UserVO>, int를 필드로 하는 VO를 만들거나
		//2. List<Object> resultList를 만들거나 -- 비추천
		
		//3. HashMap<String, Object> resultMap을 만들거나
		//	resultMap.put("pagingList", pagingList);
		//	resultMap.put("usersCnt", usersCnt);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("pagingList", dao.userPagingList(pageVO));
		
		//usersCnt -> paginationSize로 변경
		int usersCnt = dao.usersCnt();
		int pageSize = pageVO.getPageSize();
		int paginationSize = (int)(Math.ceil((double)usersCnt/pageSize));
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
	}
	
	/**
	 * Method : insertUser
	 * 작성자 : jakeh
	 * 변경이력 : 2019-05-30 처음 생성
	 * @param userVO
	 * @return
	 * Method 설명 : 사용자 등록 메서드
	 */
	@Override
	public int insertUser(UserVO userVO) {
		return dao.insertUser(userVO);
	}
	
	/**
	 * Method : updateUser
	 * 작성자 : jakeh
	 * 변경이력 : 2019-05-31 처음 생성
	 * @param userVO
	 * @return
	 * Method 설명 : 사용자 삭제 메서드
	 */
	@Override
	public int deleteUser(String userId) {
		return dao.deleteUser(userId);
	}

	/**
	 * Method : updateUser
	 * 작성자 : jakeh
	 * 변경이력 : 2019-05-31 처음 생성
	 * @param userVO
	 * @return
	 * Method 설명 : 사용자 수정 메서드
	 */
	@Override
	public int updateUser(UserVO userVO) {
		return dao.updateUser(userVO);
	}
	
}
