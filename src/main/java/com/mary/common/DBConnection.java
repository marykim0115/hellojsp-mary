package com.mary.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

public class DBConnection { 
	public Connection con; //DB연결 객체. con객체에 드라이버 주소를 담아주어야 연결됨. 
	public Statement stmt; //인파라미터가 없는 정적 쿼리문을 실행할 때 사용
	public PreparedStatement pstmt;//인파라미터가 있는 동적 쿼리문을 실행할때 사용
	public ResultSet rs; //select쿼리문의 결과를 저장하는 객체
	
	/**
	 * 생성자 - Connection 객체 생성
	 */
	public DBConnection() {//기본 생성자
		try {
			//	1. 드라이버 로딩
			Class.forName("oracle.jdbc.OracleDriver"); //드라이버가 존재하는지 확인
							//오류가 날수 있는 문장이기 때문에 try/catch문으로 오류 예방
			
			// DB에 연결하기 위해 필요한 정보
			String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
			String id = "TEST";
			String pw = "1234";
			
			con = DriverManager.getConnection(url, id, pw);
						//오류가 날수 있는 문장이기 때문에 try/catch문으로 오류 예방
			
			System.out.println("DB 연결 성공(기본 생성자)");
			
		} catch (ClassNotFoundException e) { //Class.forName("oracle.jdbc.OracleDriver");가 오류일 경우
			System.out.println("드라이버로딩 실패");
			e.printStackTrace();
		} catch (SQLException e) { //con = DriverManager.getConnection(url, id, pw);가 오류일 경우
			System.out.println("connection 객체 생성 실패");
			e.printStackTrace();
		}
	}
	
	public DBConnection(String driver, String url, String id, String pw) { //생성자2
		try {
			//	1. 드라이버 로딩
			Class.forName(driver);
			
			// 2. DB Connection 객체 생성
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("DB 연결 성공(인수 생성자 1)");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버로딩 실패-");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("connection 객체 생성 실패");
			e.printStackTrace();
		}
	}
	
	public DBConnection(ServletContext application) { //생성자3 
		// ServletContext : web.xml에 context parameter를 이용해서 데이터를 기술하고, Servlet에서 공유하면 사용 할수 있음. 
		String driver = application.getInitParameter("driver");
		String url = application.getInitParameter("url");
		String id = application.getInitParameter("id");
		String pw = application.getInitParameter("pw");
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("application 내장객체를 이용한 Connection 생성");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 - 라이브러리 확인");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("application 내장객체를 이용한 Connection 객체 생성 실패");
			e.printStackTrace();
		}
	}
	
	/**
	 * 연결해제(자원반납) : 연결한 순서 반대로 연결해제
	 */
	public void close() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(stmt !=null) stmt.close();
			if(con!=null) con.close();
			System.out.println("자원 반납 성공");		
		} catch (SQLException e) {
			System.out.println("자원 반납 중 예외가 발생 하였습니다");
			e.printStackTrace();
		}
	}
}
