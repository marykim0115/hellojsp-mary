<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="">
	<div class='loginbox'>
        <div id='login'>
            <input type="text" name="userid" id="userpw" placeholder='ID를 입력해주세요.' 
            				required="required" value="<%=userId%>"><br>
            				
            <input type="password" name="userpw" id="userpw" placeholder='PW를 입력해주세요.' required="required"><br>
            <input type="checkbox" name="save_check" value="Y">아이디 저장하기<br>
        </div>
        <div id='button'>
        <input type="submit" value="로그인">
        </div>
    </div>
    <div id='info'>
        <a href="">회원가입</a>
        <a href="">ID찾기</a>
        <a href="">PW찾기</a>
    </div> 
</form>

</body>
</html>