package com.mary.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.mary.common.DBConnection;
import com.mary.dto.EmpDto;
import com.mary.dto.Job;

public class JobDao extends DBConnection{
	
	/**
	 * Dao(Data Access Object) : 데이터 액세스 객체
	 * 데이터베이스와의 상호작용을 관리하고 데이터베이스에서 데이터를 읽고 쓰는데 사용
	 * 데이터로부터 데이터를 입출력하는 객체
	 * 
	 * Dto(Data Transfer Object): 데이터 전송 객체
	 * 데이터를 전송하거나 전달하기 위해 사용되는 객체
	 * 데이터를 담는 객체
	 * 메서드가 없이 setter,getter만 있음
	 * 
	 */
	
	public JobDao(ServletContext application) {
		super(application);//부모의 생성자 호출
	}
	
	/**
	 * job 테이블의 내용을 조회 후 리스트에 담아서 반환
	 * @return
	 */
	
	//메소드 선언
	public List<Job> getList() {
		List<Job> list = new ArrayList<> ();
		
		try {
			stmt = con.createStatement();
			String sql = "select * from job";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Job job = new Job();
				job.setJobCode(rs.getString(1));
				job.setJobName(rs.getString(2));
				
				list.add(job);
			}
			
			
		} catch (SQLException e) {
			System.out.println("SQLException 예외사항 발생");
			e.printStackTrace();
		}
		return list;
	}
	
}
