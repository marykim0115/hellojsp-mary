<%@page import="com.mary.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
a:href { text-align: center;  
	text-decoration: none; 
	color: inherit; 
}
</head>
<body>
<h2>로그인 성공</h2>
<%= session.getAttribute("userId") %>님 환영합니다
<hr>
<%
//로그인 시에, 오류 발생하지 않도록 null 처리
if(session.getAttribute("memberDto") !=null){
	MemberDto dto = (MemberDto)session.getAttribute("memberDto");
%>
아이디 : <%=dto.getId() %><br>
이 름 : <%=dto.getName() %><br>
등록일 : <%=dto.getRegidate() %><br>
<%} %>
<br><button><a href="logoutProcess.jsp">로그아웃</a></button>
</body>
</html>