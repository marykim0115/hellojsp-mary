<%@page import="com.mary.util.JSFunction"%>
<%@page import="com.mary.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	if(request.getParameter("num")!=null){
		String num = request.getParameter("num").toString();
		BoardDao dao = new BoardDao();
		if(dao.deleteBoard(num) != 1){
			JSFunction.alertBack("존재하지 않는 게시글 입니다", out);
		}
		JSFunction.alertLocation("삭제 되었습니다", "/boardList", out);
	}else {
		JSFunction.alertBack("게시물 번호(null)를 확인할수 없습니다", out);
	}
%>

</body>
</html>