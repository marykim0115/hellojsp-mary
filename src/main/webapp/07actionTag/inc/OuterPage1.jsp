<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>외부파일 1</title>
</head>
<body>
<h2>외부파일1</h2>
	<ul>
		<li>page영역 속성 : <%=pageContext.getAttribute("attrPage") %></li>
		<li>request영역 속성 : <%=pageContext.getAttribute("attrRequest") %></li>
	</ul>
</body>
</html>