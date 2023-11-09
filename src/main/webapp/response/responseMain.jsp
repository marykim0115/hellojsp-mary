<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>내장객체 - response</h2>

<%
	//1. 만약, loginErr = 1 이면 ==> 아이디/비밀번호를 확인해주세요
	String msg = "" ;
	if ("1".equals(request.getParameter("loginError"))){
		msg = "아이디/비밀번호를 확인해주세요";
	}
	out.print(msg);
	//forward를 사용할 경우, request 요청정보가 공유된다
	
	//2. id 입력칸에 사용자가 입력한 아이디를 출력
	String id="mary";
	if(request.getParameter("id")!=null){
		id = request.getParameter("id");
	}
	
	
	out.print(request.getParameter("loginError"));
	out.print(request.getParameter("id"));
%>

	<form action="responseLogin.jsp" method="post">
		아이디 : <input type="text" name="id" value="mary">
		패스워드 : <input type="password" name="pw" value="1234">
		<input type="submit" value="로그인">
	
	</form>

	<h2>응답헤더 확인하기</h2>
	<form action="responseHeader.jsp" method="get">
	<input type="submit" value="응답헤더">
	
	</form>
</body>
</html>