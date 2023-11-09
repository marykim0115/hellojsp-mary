<%@page import="com.mary.util.CookieManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>팝업 쿠키를 생성하는 페이지</h2>

<%
//1. inactiveToday 값을 출력해보기
String chkVal = request.getParameter("inactiveToday");
out.print("inactiveToday : " + chkVal);

//2. 팝업 닫기용(popupClose-key, Y-value) 쿠키 생성
if(chkVal != null && "Y".equals(chkVal)){
	Cookie cookie = new Cookie("popupClose", "off"); //쿠키 생성
	CookieManager.makeCookie(response, "popupClose", "Y", 3600)
//3. cookiePopupMain페이지로 페이지 이동(전환)
}



%>


</body>
</html>