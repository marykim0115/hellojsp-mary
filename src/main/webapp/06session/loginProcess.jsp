<%@page import="com.mary.dto.MemberDto"%>
<%@page import="com.mary.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 프로세스</title>
</head>
<body>
<h2>로그인 프로세스</h2>
<%
	/**	1. 사용자의 요청 파라미터 수집(id,pw)
		2. DB에 등록된 사용자인지 확인
			- user 테이블 생성
			- 사용자 정보 등록
	*/
	String id = request.getParameter("user_id"); //loginForm.jsp 화면에서 <input name="user_id">에 입력한 값 => 변수 id에 넣음
	String pass = request.getParameter("user_pw");//loginForm.jsp 화면에서 <input name="user_pw">에 입력한 값 => 변수 pass에 넣음
	
	MemberDao dao = new MemberDao();
	MemberDto dto = dao.login(id, pass); //로그인
	dao.close();//dao 열었으면 자원해제까지 해줘야함
	
	//id,pass가 일치하는 사용자 정보를 반환
	if(dto !=null){
		//로그인 성공 -> 메인페이지로 이동
		//로그인한 정보를 세션에 저장
		session.setAttribute("memberDto", dto); //내가 저장하고 싶은 값만 저장할수도 있음
		session.setAttribute("userId", id);
		response.sendRedirect("main.jsp");
		
	} else{
		//로그인 실패 -> 로그인 페이지로 이동후 메세지 출력
		request.getRequestDispatcher("loginForm.jsp?isError=1").forward(request, response);
	}
%>

</body>
</html>