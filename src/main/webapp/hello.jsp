<!--페이지 지시어:
	JSP 페이지를 자바(서블릿) 코드로 변환하는데 필요한 정보를 JSP 엔진에 알려주며, 
	주로 스크립트 언어나 인코딩 방식 등을 설정
	
	*페이지 지시어가 없는 경우, 오류가 발생
	
	속성 = 값
	language = "java" => 이런 형식으로 연결
-->

<%@page import="java.util.Date"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<body>

<!--  
	jsp 파일 호출 방법 
	localhost:port number/path/file name
	
	*웰컴 페이지 확인하기!!
	
	*Servlet implementation 
	
	servlet 호출 방법
	localhost:port number/path/URL mapping 주소
-->





<!-- java 코드를 사용하는 방법 -->
<!-- %! : 선언부 
	= : 하나의 값을 출력함
	-->
<%!
	String title = "hello JSP";
%>
<h1> <%= title %></h1>
<hr>
<!-- 내장객체를 이욯한 출력 -->
<h1>
<%
	out.print(title + "학습");
%>
</h1>

<% 
	//자바 코드를 입력하기 위한 스크립트를 열어줍니다
	Date today = new Date(); //외부 클래스를 사용하기 위해서는 page 지시어 import 속성을 이용

	out.print("오늘 날짜 : " + today); //웹 브라우저에 출력하기 위한 내장 객체
									//내장 객체 : 내가 생성하지 않았지만 jsp가 클래스로 변환 되면서 자동으로 생성해주는 객체
									//out : 웹 브라우저에 출력하기 위한 내장 객체
%>
<hr>
오늘날짜 : <%= today %>

</body>
</html>