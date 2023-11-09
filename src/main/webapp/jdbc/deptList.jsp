<%@page import="com.mary.dto.DeptDto"%>
<%@page import="java.util.List"%>
<%@page import="com.mary.dao.DeptDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>부서목록</h2>
<%
//jsp를 단독으로 실행할 경우, null이 출력될수 있다. request로 요청하지만 요청받은 값이 없기때문이다
List<DeptDto> list = (List<DeptDto>)request.getAttribute("list");
out.print(list); 
%>


<%
//	DeptDao dao = new DeptDao(application);
//	List<DeptDao> list = dao.getList();
	//자원해제
//	dao.close();
	
//	for(DeptDto dto : list){
//		out.print(dto.getDept_title() + " ");
//		out.print(dto.getLocal_code() + " ");
//		out.print(dto.getLocation_id() + " ");
//		out.print(dto.getLocal_name() + "<br>");
//	}
%>

</body>
</html>