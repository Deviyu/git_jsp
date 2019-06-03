package kr.or.ddit.servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.util.CalendarUtil;
import kr.or.ddit.util.PartUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class FileUpload
 */
@WebServlet("/fileUpload")
@MultipartConfig(maxFileSize=1024*1024*3, maxRequestSize=1024*1024*15)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory
			.getLogger(FileUploadServlet.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//userId, profile 파라미터를 확인
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String profile = request.getParameter("profile");
		String contentType = request.getContentType();
		logger.debug("userId : {}", userId);
		logger.debug("profile : {}", profile);
		logger.debug("contentType : {}",contentType);
		
		Part profile_part = request.getPart("profile");
		logger.debug("profile_part.getName() : {}",profile_part.getName());
		logger.debug("profile_part.getContentType() : {}", profile_part.getContentType());
		Collection<String> headerNames = profile_part.getHeaderNames();
		for(String header : headerNames) {
			logger.debug("{} : {}", header, profile_part.getHeader(header));
		}
		//파일 디스크에 쓰기
		if(profile_part.getSize() != 0) {
			String contentDisposition = profile_part.getHeader("content-disposition"); 
			String fileName = PartUtil.getFileName(contentDisposition);
			String extentionName = PartUtil.getExtention(fileName);
			
			CalendarUtil calUtil = new CalendarUtil();
			String year = calUtil.getYear();
			String month = calUtil.getMonth();
			
			//연도에 해당하는 폴더가 있는지, 연도안에 월에 해당하는 폴더가 있는지

			File yyyyFolder = new File("d:\\upload\\"+year);
			if(!yyyyFolder.exists()) {
				yyyyFolder.mkdir();
			}
			//월에 해당하는 폴더가 있는지 확인
			File mmFolder = new File("d:/upload/2019/"+month);
			if(!mmFolder.exists()) {
				mmFolder.mkdir();
			}
			
			File uploadFolder = new File("d:/upload"+ File.separator 
										+ calUtil.getDatePath());
			if(uploadFolder.exists()) {
				profile_part.write(uploadFolder+ File.separator + UUID.randomUUID().toString() + extentionName);
				profile_part.delete();
			} 
			
		}
	}

}
