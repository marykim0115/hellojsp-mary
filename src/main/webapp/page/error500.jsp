<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page 지시어</title>
</head>
<body>
<%
	try{
		//변수 선언
		int age = 
			Integer.parseInt(request.getParameter("age"));

		out.print("나이 : " + age);
		
	}catch(Exception e){
		out.print("실행 중 예외가 발생 하였습니다");
	}

%>
<hr>
</body>
</html>