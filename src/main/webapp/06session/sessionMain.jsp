<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>세션 설정</h2>

<h2>Session 설정 확인</h2>

<%
	//session.setMaxInactiveInterval(300); //유지시간 설정(초단위)
	
	//long타입의 날짜의 포맷을 내가 원하는 형식으로 변경하여 출력 될수 있게 바꾸기
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); //날짜 표시 형식을 지정
	
	String creatTime = sdf.format(new Date(session.getCreationTime()));
	String lastTime = sdf.format(new Date(session.getLastAccessedTime()));
	
%>

<ul>
	<li>세션 유지 시간 : <%=session.getMaxInactiveInterval() %></li>
	<li>세션 아이디 : <%=session.getId() %></li>
	<li>최초 요청 시간 : <%=session.getCreationTime() + "/" + creatTime%></li>
	<li>마지막 요청 시간 : <%=session.getLastAccessedTime() + "/" + lastTime %></li>
</ul>

</body>
</html>