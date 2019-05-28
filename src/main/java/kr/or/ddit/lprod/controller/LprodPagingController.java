package kr.or.ddit.lprod.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.paging.model.PageVO;

/**
 * Servlet implementation class LprodPagingController
 */
@WebServlet("/lprodPagingList")
public class LprodPagingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private ILprodService lprodService;
	
	@Override
	public void init() throws ServletException {
		lprodService = new LprodServiceImpl();
	}
	
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		int pageSize = request.getParameter("page") == null ? 5 : Integer.parseInt(request.getParameter("pageSize"));
		PageVO pageVO = new PageVO(page, pageSize);
		
		Map<String, Object> resultMap = lprodService.lprodPagingList(pageVO);
		List<LprodVO> pagingList = (List<LprodVO>) resultMap.get("pagingList");
		int paginationSize = (int) resultMap.get("paginationSize");
		
		request.setAttribute("pageVO", pageVO);
		request.setAttribute("pagingList", pagingList);
		request.setAttribute("paginationSize", paginationSize);
		
		request.getRequestDispatcher("/lprod/lprodPagingList.jsp").forward(request, response);
	}

}
