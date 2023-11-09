package com.mary.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/** Connection 객체의 단점
 * 클라이언트의 요청이 있을때마다, 웹서버가 Connection 객체를 생성하고 
 * 네트워크 통신과 DB 연결/해제를 반복하면 시스템 성능에 큰 영향을 끼친다.
 
 ** 해결법 : Connection Pool
 * Connection 객체를 미리 생성해 풀(pool)에 넣어놓고,
 * 요청이 있을 때, 이미 생성된 Connection 객체를 가져다 사용하는 기법
  
 ** JNDI(Java Naming and Directory Interface)
 * 자바 소프트웨어에서 객체나 데이터를 전체 경로를 몰라도 
 * ‘이름’만으로 찾아 쓸 수 있는 디렉터리 서비스
 * 대부분의 WAS는 커넥션 풀을 비롯한 여러 자원을 JNDI 서비스로 제공
 */
public class DBConnPool {
	public Connection con; 
	public Statement stmt; 
	public PreparedStatement pstmt;
	public ResultSet rs; 
	
	public DBConnPool() {
		try {
			//JNDI를 통해 커넥션풀 얻어오기
			Context initContext = new InitialContext(); //NamingException이 발생할수 있음
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			
			//커넥션풀을 통해 연결 객체를 멤버변수 con에 담아줍니다(자원해제 close()을 한번에 하기 위해 담는것)
			con = ds.getConnection(); //SQLException이 발생할수 있음
			System.out.println("JNDI를 통해 커넥션풀에서 커넥션을 얻어오기");
		} catch (NamingException e) {
			System.out.println("========= DBCConnPoll에서 NamingException 발생");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("========= DBCConnPoll에서 SQLException 발생");
			e.printStackTrace();
		}	
	}
	
	/**
	 * 연결해제(자원반납)
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
