package com.mary.dao;

import java.sql.SQLException;

import com.mary.common.DBConnPool;
import com.mary.dto.MemberDto;

public class MemberDao extends DBConnPool{

	//로그인 메서드 
	public MemberDto login(String id, String pass) {
		MemberDto memberDto = new MemberDto();
		String sql = "select * \r\n"
				+ "from    member\r\n"
				+ "where   id = ? \r\n"
				+ "and     pass = ?";
		
		try {
		//입력받은 사용자 정보를 DB로부터 조회
			pstmt = con.prepareStatement(sql);
			
			//파라미터 세팅
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			
			//쿼리 실행
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//로그인 성공
				memberDto.setId(rs.getString(1));
				memberDto.setName(rs.getString(2));
				memberDto.setRegidate(rs.getString(4));

				return memberDto; //사용자 정보를 MemberDto객체에 담아서 반환
			} else {//로그인 실패
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null; //return값이 맞지 않아서 오류가 남. catch문에 return값 넣어주면 일단 해결됨
		}
	}
}
