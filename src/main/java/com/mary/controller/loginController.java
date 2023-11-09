package com.mary.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mary.dao.BoardDao;
import com.mary.dao.MemberDao;
import com.mary.dto.MemberDto;

@WebServlet("/06session/servletEx/loginProcess")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**Controller의 역학
	 * - 파라미터 수집
	 * - 페이지 전환 (JSP파일로 요청을 위임) 
	  
	 ** doPost() 메서드 역할 : 사용자의 로그인 요청을 처리
	 * 1. 요청 파라미터 수집 (id,pw)
	 * 2. DB로부터 해당 사용자가 있는지 확인
	 *		2-1. 사용자가 존재하면 : 로그인 처리(세션에 사용자 정보를 저장)
	 * 		2-2. 사용자가 존재하지 않으면 : 이전페이지로 넘어가서 오류 메세지를 출력
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//servlet에서 세션을 사용하기 위해 : request로부터 꺼내와야함
		HttpSession session = request.getSession();

		//	1. 요청 파라메터 수집
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		System.out.println("id : " + id); //user_id 값이 내가 생각한대로 들어갔는지 확인
		System.out.println("pw : " + pw); //user_pw 값이 내가 생각한대로 들어갔는지 확인
		
		//	2. MemberDao를 이용하여 사용자정보 인증
		//		id,pw 일치하는 사용자가 있다면 member객체를 반환하고, 아니면 null을 반환 => MemberDao로 반환 받음
		MemberDao dao = new MemberDao();
		MemberDto dto = dao.login(id, pw);
		dao.close();
			
		if(dto !=null){
			//로그인 성공 -> session에 로그인 정보 저장 -> board.jsp로 페이지 전환
			
			//세션의 만료기간이 남아 있고 웹브라우저를 닫을때까지 세션 정보가 서버에 유지
			session.setAttribute("MemberDto", dto); // 3. session영역에 memberDto 저장
			session.setAttribute("userId", dto.getId()); 
			
			//페이지 전환하기전, 게시글 조회후 request에 담아주기
			BoardDao boardDao = new BoardDao();
			request.setAttribute("list", boardDao.getList());
			dao.close();
			
			//sendRedirect롤 이용할 경우, request 영역이 공유가 되지 않기 떄문에 list값을 화면으로 전달할수 없어
			// response.sendRedirect("board.jsp"); => 페이지 전환중, null 반환하는 오류가 계속 뜸
			request.getRequestDispatcher("board.jsp").forward(request, response); // 4. 페이지 전환
		} else{//로그인 실패
			response.sendRedirect("loginForm.jsp?isError=1");
			//request.getRequestDispatcher("loginForm.jsp?isError=1").forward(request, response);
			//두개 중 하나 사용
		}
	}
}
