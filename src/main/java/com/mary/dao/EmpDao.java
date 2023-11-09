package com.mary.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.mary.common.DBConnPool;
import com.mary.common.DBConnection;
import com.mary.dto.EmpDto;

/**
 * 데이터 베이스에 접근 해서
 * 데이터 입력, 출력, 삭제, 조회 작업을 처리하는 객체
 * 
 * Dao(Developer application of) -> mapper
 */

public class EmpDao extends DBConnPool{
	
	/** 
	 * 생성자를 이용하여 Connection 객체를 생성후 멤버변수 con에 저장
	 * con에 저장하지 않으면 NullPointException이 발생
	 */
	
//	public EmpDao(ServletContext application) { //생성자
//		super(application);
//	}
	
	/**
	 * 데이터베이스로부터 사원의 목록을 조회하여 반환합니다.
	 * 조회된 데이터를 반환하기 위해서 리스트에 담아줍니다
	 * 왜 반환하지? 페이지에 출력하려고...
	 */
	
	public List<EmpDto> getList() { //EMP 테이블이 가지고 있는 데이터를 조회해서 List를 출력하는 객체 생성
		List<EmpDto> list = new ArrayList<>();
		
		try {
			stmt = con.createStatement();
			String sql = "select * from employee";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				// System.out.println();
				// 콘솔에 출력하던 데이터를 화면에 출력하기 위해서,
				// 리스트에 저장 후 반환
				EmpDto dto = new EmpDto();
				dto.setEmp_id(rs.getString(1));
				dto.setEmp_name(rs.getString(2));
				dto.setEmp_no(rs.getString(3));
				
				list.add(dto);
			}
			
			//자원반납
			close(); //DBConnPool의 close()메서드 사용
			
		} catch (SQLException e) {
			System.out.println("SQLException 예외사항 발생");
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
//		EmpDao empDao = new EmpDao();
//		empDao.getList();
	}
}









