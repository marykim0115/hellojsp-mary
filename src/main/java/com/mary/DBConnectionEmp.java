package com.mary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionEmp {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
		String id = "TEST";
		String pw = "1234";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		/* 	1. 드라이버 로딩
		 * 		DB에 접근하기 위해 필요한 라이브러리가 있는지 확인
		 * 	2. Connection 객체를 생성(가져옴) -> get 메서드로 얻어옴
		 * 
		 */
		
		
		try {
			//	1. 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//	2. 커넥션 생성
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:ORCL", 
					"TEST", 
					"1234");
			
			//	3. 쿼리문장 준비
			String sql = "SELECT EMP_ID, EMP_NAME, EMP_NO FROM EMPLOYEE";
			
			//	4. 쿼리 문장 실행
			stmt = con.createStatement();
			
			// 😊 stmt.executeQuery(sql)
			// 		select 문장을 실행 할 경우 ResultSet을 반환 합니다.
			// 😊 stmt.executeUpdate(sql)
			// 		update, insert, delete 의 경우 int 타입을 반환 합니다.
			// 		-> 실행결과 몇건이 처리되었는지
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				// 숫자를 입력시 1부터
				// 숫자또는 결과집합의 컬럼명
				System.out.print(rs.getString("emp_id")+" ");
				System.out.print(rs.getString("emp_name")+" ");
				System.out.println(rs.getString("emp_no"));
//				System.out.print(rs.getString(1)+" ");
//				System.out.print(rs.getString(2)+" ");
//				System.out.println(rs.getString(3));
//				// error -> 스트링타입으로 입력시 이름으로 찾으므로 오류 발생
//				//System.out.println(rs.getString("1")); 
			}
						
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩실패-라이브러리가 등록되었는지 확인해주세요");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Connection 객체 생성 실패");
			e.printStackTrace();
		} finally {
			try {
				if(rs !=null) rs.close();
				if(stmt !=null) stmt.close();
				if(con!=null) con.close();
			} catch (Exception e) {
				System.out.println("자원 해제중 예외사항이 발생 하였습니다");
				e.printStackTrace();
			}
		}
	}
}
