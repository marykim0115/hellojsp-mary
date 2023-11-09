package com.mary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionInsert {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
		String id = "TEST";
		String pw = "1234";
		
		Connection conn = null;
		
		try {
			// 1. 드라이버 로딩(드라이브가 있는지 확인)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. 드라이버가 있으면 -> 커넥션 생성
			conn = DriverManager.getConnection(url, id, pw);
			// 3. 쿼리 생성 
			// String sql = "insert into job values (?,?)";
			 String sql = "delete job where job_code = ?";
			
			// 4. pstmt 객체 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 5. 인파라미터 세팅(쿼리상에 ?로 작성된 부분의 값을 변경)
//			pstmt.setString(1, "97"); //첫번째 물음표의 값을 99로 바꿔줘
//			pstmt.setString(2, "사원");//두번째 물음표의 값을 값99로 바꿔줘
			pstmt.setString(1, "97");
				
			// 6. 쿼리 실행
			int res = pstmt.executeUpdate();
			System.out.println(res + "건 삭제 되었습니다");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩실패-라이브러리가 등록되었는지 확인해주세요");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
