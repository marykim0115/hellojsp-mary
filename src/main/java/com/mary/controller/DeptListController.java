package com.mary.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mary.dao.DeptDao;
import com.mary.dto.DeptDto;

/** URL매핑 정보:해당 URL이 실행되면 톰캣이 이 페이지를 실행함
 * -요청 메서드에 따라서 실행되는 메서드가 결정됨
 * 
 * 주소표시줄, 링크 -> get방식 -> doGet()메서드 호출
 * 
 * Controller : 
 * <Controller의 역할>
 * - 사용자의 요청 정보를 수집(requset를 이용해서)
 * - (사용자의 요청을 처리하는) 비지니스로직 호출
 * - view페이지로 페이지 전환
 */
@WebServlet("/DeptList")
public class DeptListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeptListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//DB에 접근해서 리스트를 조회
		DeptDao dao = new DeptDao(request.getServletContext());
		List<DeptDto> list = dao.getList();
		
		request.setAttribute("list", list);
		//화면전환 : Controller에서 화면을 구성하는 태그를 작성하는 것은 매우 번거롭기 때문에
		//JSP파일을 이용해서 화면을 작성 후 페이지 전환하는것
		request.getRequestDispatcher("deptList.jsp")
				.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
