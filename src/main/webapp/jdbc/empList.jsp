<%@page import="com.mary.dto.EmpDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- controller를 통해 이 페이지가 보이게 됨
	 여기 페이지에서는 데이터에 접근해서 사원 목록을 조회해서 화면에 출력되게 하면 됨 
 -->
<h2>Controller를 이용해서 사원목록을 출력 해봅시다</h2>

<%
	//request.getAttribute()의 반환타입이 Object 타입이므로 
	//(List<EmpDto>)로 형변환후 사용 가능함
	List<EmpDto> list = (List<EmpDto>)request.getAttribute("list");
%>
<table border="1">
	<tr>
		<td>사번</td>
		<td>사원명</td>
		<td>주민번호</td>
	</tr>
	
	<%for(EmpDto dto:list) { %>
	<tr>
		<td><%=dto.getEmp_id() %></td>
		<td><%=dto.getEmp_name() %></td>
		<td><%=dto.getEmp_no() %></td>
	</tr>
	<% } %>
</table>

</body>
</html>