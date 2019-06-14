package kr.or.ddit.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import kr.or.ddit.user.model.UserVO;

public class SessionAttributeListener implements HttpSessionAttributeListener{
	private Map<String, UserVO> sessionUserMap = new HashMap<String, UserVO>();
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		if("USER_INFO".equals(event.getName())){ // 속성명이 USER_INFO일 때
			sessionUserMap.put(event.getSession().getId(), (UserVO)event.getValue());
			event.getSession().getServletContext().setAttribute("sessionUserMap", sessionUserMap);
		}
			
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		if("USER_INFO".equals(event.getName())){ // 속성명이 USER_INFO일 때
			sessionUserMap.remove(event.getSession().getId());
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		if("USER_INFO".equals(event.getName())){ // 속성명이 USER_INFO일 때
			sessionUserMap.put(event.getSession().getId(), (UserVO)event.getValue());
//			event.getSession().getServletContext().setAttribute("sessionUserMap", sessionUserMap);
		}
	}

}
