<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃 프로세스</title>
</head>
<body>
<%
	//세션 무효화 (별로 추천하는 방법은 아님)
	session.invalidate();
	
	//페이지 이동
	response.sendRedirect("loginForm.jsp");
%>
</body>
</html>