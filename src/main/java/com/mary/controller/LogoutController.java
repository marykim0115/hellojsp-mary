package com.mary.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	/** 
	 * 로그아웃 후 loginForm.jsp로 redirect
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session != null) { //session이 비어있지 않은지 확인 후
			session.invalidate(); //세션 무효화
		}
		
		System.out.println("로그아웃 - 세션무효화");
		response.sendRedirect("/06session/servletEx/loginForm.jsp");
		
	}

	

}
