<%@page import="com.mary.dto.BoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board 페이지(서블릿을 통한 로그인/로그아웃 연습)</title>
</head>
<body>
	<!-- 자바스크립트로 로그인/로그아웃 클릭 이벤트 처리 -->
	<script type="text/javascript">
	window.onload = function(){
		//로그아웃 버튼 클릭 이벤트 처리
		let logoutBtn = document.querySelector("#logoutBtn");
		if(logoutBtn != null){ //로그인 여부 체크 : 버튼이 있을때도, 없을때도 있어서 null 체크해주기
			logoutBtn.onclick = function(){ //해당 버튼에 onclick 이벤트가 발생하면 실행될 function() 작성
				loginForm.action = "/logout"; // 로그아웃 페이지로 이동(LogoutController 서블릿으로 요청함)
				loginForm.submit();
			}
		}
		//로그인 버튼 클릭 이벤트 처리
		loginBtn.addEventListener("click", function(){
			loginForm.action = "loginForm.jsp"; //loginForm.jsp 페이지로 이동
			loginForm.submit();
		});
	}
	</script>
	
<!-- 로그인 여부를 체크
	로그인 했을때 = 세션에 userId가 저장되어 있으면 : 로그아웃 버튼을 출력
					없으면 (userId==null) : 로그인 버튼을 출력
 -->
<form name="loginForm">
<%
	Object userId = session.getAttribute("userId"); //getAttribute()의 반환타입은 Object이므로 형변환이 필요합니다
	if(userId != null && !userId.equals("")){ //nullpointException을 방지하기 위해 null체크 
		//out.print(session.getAttribute("userId").toString() + "님 환영합니다.");
%>
	<%=userId %>님 환영합니다.<br>
	<!-- 로그인한 사용자 : 로그아웃 버튼 출력 -> 세션을 만료 시키고 로그인 페이지로 이동 -->
	<button id="logoutBtn">로그아웃</button>
<% } else { //로그인하지 않은 사용자 : 로그인 버튼 출력 -> 로그인 페이지로 이동
%>
	<button id="loginBtn">로그인</button>
<% }%>
</form>

<h2>게시판</h2>
<%=request.getAttribute("list") %>

<table border="1">
	<tr>
		<th>일련번호</th>
		<th>제목</th>
		<th>내용</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
	<%
	if(request.getAttribute("list") !=null ){
		List<BoardDto> list = (List<BoardDto>)request.getAttribute("list");
		for(BoardDto dto : list){
			%>
	<tr>
		<td><%=dto.getNum() %></td>
		<td><%=dto.getTitle() %></td>
		<td><%=dto.getContent() %></td>
		<td><%=dto.getId() %></td>
		<td><%=dto.getPostdate() %></td>
		<td><%=dto.getVisitcount() %></td>
	</tr>
			
		<%}
	}%>
	
</table>


</body>
</html>