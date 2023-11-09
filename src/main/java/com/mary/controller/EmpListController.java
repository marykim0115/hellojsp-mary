package com.mary.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mary.dao.EmpDao;
import com.mary.dto.EmpDto;

@WebServlet("/empList")
public class EmpListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, 
						HttpServletResponse response) 
					throws ServletException, IOException {
		
		//사원 리스트 조회
		//EmpDao dao = new EmpDao(getServletContext());
		//Dao의 부모객체가 Pool로 바뀌며 매개변수로 application 을 받지 않아도 되게 됨. 
		EmpDao dao = new EmpDao(); //생성자 새로 만듦
		List<EmpDto> list = dao.getList();
		
		//리스트를 request 영역에 저장
		request.setAttribute("list", list);
		
		//view페이지 전환하기(request 이용해서)
		request.getRequestDispatcher("/jdbc/empList.jsp")
				.forward(request, response);
	}

	

}
