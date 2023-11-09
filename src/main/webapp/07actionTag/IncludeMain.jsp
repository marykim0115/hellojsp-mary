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
	pageContext.setAttribute("attrPage", "attrPage");
	request.setAttribute("attrRequest", "attrRequest");
%>

<%-- <jsp:include> : 외부파일을 현재 파일에 포함 시킴 --%>
<h2>지시어와 액션태그 동작 방식 비교</h2>
<h3>지시어 방식</h3>
	<%@ include file="inc/OuterPage1.jsp" %>
<hr>
<h3>액션태그 방식</h3>
	<jsp:include page="inc/OuterPage2.jsp"></jsp:include>
</body>
</html>