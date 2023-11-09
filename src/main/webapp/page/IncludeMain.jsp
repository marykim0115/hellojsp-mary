<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 다른 JSP파일을 포함 -->
<%@ include file="IncludeFile.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> include 지시어 </h1>
	오늘날짜 : <%= today %>
	
	<hr>
	선언부(클래스 내부에 생성)<br>
		-메서드 작성이 가능<br>
		-<%! %> : 이 형식으로 작성
	<hr>
	스크립틀릿(메서드 내부에 생성)<br>
		-메서드 작성이 불가능<br>
		-자바 코드<br>
		<!-- <% %> => 이 형식으로 작성 -->
	<hr>
	표현식<br>
		-실행 결과 하나의 값을 출력<br>
		-상수, 변수, 연산자, 수식<br>
		-<%= 10+20 %><br>
		-<%= "오늘 날짜는" + today %>
	
	
	<%@ include file = "IncludeFooter.jsp" %>
</body>
</html>