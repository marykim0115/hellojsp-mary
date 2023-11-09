<%@page import="com.mary.util.CookieManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>



<head>
<meta charset="UTF-8">
<style>
    div#popup {
        position: absolute; top:100px; left:50px; color:yellow;  
        width:270px; height:100px; background-color:gray;
    }
    div#popup>div {
        position: relative; background-color:#ffffff; top:0px;
        border:1px solid gray; padding:10px; color:black;
    }
</style> 

<title>Insert title here</title>
</head>




<body>

<h2>쿠키를 이용한 팝업창 제어 ver 1.0</h2>

<script> //script : 화면(요소)의 동적인 제어
//window 객체의 onload 이벤트가 발생하면 실행
//html 요소가 모두 생성된 상태에서 실행

window.onload = function() {
	
	document.querySelector("#popup").style.display='none'; //팝업창이 화면에서 숨겨짐
	
	
	
	//버튼에 이벤트 등록
	closeBtn.onclick =  function() {
		//체크박스가 체크되어 있으면 '체크박스가 선택 되었습니다' 메세지 출력되게 
		if (document.querySelector('#inactiveToday').checked){
			alert("체크박스가 선택 되었습니다");
		}
		
		//서버에 요청 방법 
		//1. href : queryString을 이용해서 파라미터를 전달 (get 방식)
		//2. form submit : form 안의 요소들을 요청 페이지에 파라미터를 전달 (post 방식)
		popupForm.submit();
		
		
		
	}
}

</script>



<form action="cookiePopupAction.jsp" name="popupForm">
	<div id="popup" >
	
	
	<% 
	String popupClose = CookieManager.readCookie(request,"popupClose");
	if(!"Y".equals(popupClose)){
		//쿠키에 저장된 popupClose의 값이 "Y"가 아니면,
		//화면에 팝업 생성
		%> 
	
        <h2 align="center">공지사항 팝업입니다.</h2>
        <div align="right">
	    	<input type="checkbox" id="inactiveToday" name="inactiveToday" value="Y" checked="checked"/> 
	            하루 동안 열지 않음
	        <input type="button" value="닫기" id="closeBtn" /> 
        </div>
    </div>
    <% } %> 
</form>
</body>


</html>