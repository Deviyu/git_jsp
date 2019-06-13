<%@tag import="kr.or.ddit.prod.model.ProdVO"%>
<%@tag import="java.util.List"%>
<%@tag import="kr.or.ddit.prod.service.IProdService"%>
<%@tag import="kr.or.ddit.prod.service.ProdServiceImpl"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@attribute name="code" type="java.lang.String" required="true"%>

<% 
	String lprod_id = (String)jspContext.getAttribute("code");
	IProdService service = new ProdServiceImpl();
	
	List<ProdVO> prodList = service.getProdListByLprod(lprod_id);
	jspContext.setAttribute("prodList", prodList);
%> 
	<select>
		<c:forEach items="${prodList }" var="prod">
			<option value="${prod.prod_id }">${prod.prod_name }</option>
		</c:forEach>
	</select>