package com.mary.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mary.common.DBConnPool;
import com.mary.dto.BoardDto;

// DBConnPool : 톰캣에서 제공해주는 기능을 사용하여 커넥션풀이라는 공간에 커넥션 객체를 미리 생성해놓고 사용하는 객체
// 그래스 DBConnPool은 main메서드 사용 불가능, 서버가 실행되어야 사용이 가능
// 만약 main메서드를 이용해서 테스트를 하고 싶다면 상속받는 객체를 DBConnection으로 변경해야함
public class BoardDao extends DBConnPool{
	
	
//	public int insertBoard(BoardDto dto) {
//	
//	}
	
	/**
	 * deleteBoard()메서드 : 
	 * @param num
	 * @return int
	 */
	public int deleteBoard(String num) {
		int res = 0;
		String sql = "delete from board where num = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("BoardDao에서 SQLException 예외 발생");
			e.printStackTrace();
		}
		return res;
	}
	
	/**
	 * visitcountUp() 메서드 : 게시글의 조회수를 1 증가 시켜줍니다
	 * insert, update, delete의 반환 타입은 int(몇건이 처리 되었는지 반환)
	 * 반환타입은 int로 설정
	 */
	public int visitcountUp(String num) {
		int res = 0;
		String sql = "update board "
				+ "set visitcount = visitcount+1 "
				+ "where num=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("BoardDao에서 SQLException 예외 발생");
			e.printStackTrace();
		}
		return res;	
	}
	
	/**
	 * getOne 메서드 : 한 건의 게시글을 조회후 반납
	 * 
	 * @param num
	 * @return BoardDto
	 */
	public BoardDto getOne(String num) {
		BoardDto dto = null;
		String sql = "select * \r\n"
				+ "from board\r\n"
				+ "where num = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new BoardDto();
				dto.setContent("content");
				dto.setId("id");
				dto.setNum("num");
				dto.setPostdate("postdate");
				dto.setTitle("title");
				dto.setVisitcount("visitcount");
			}
			
		} catch (SQLException e) {
			System.out.println("BoardDao에서 SQLException 예외 발생");
			e.printStackTrace();
		}
		return dto;
	}
	
	/**
	 * getList() 메서드 : 게시글 목록 반환
	 * @return List<BoardDto>
	 */
	public List<BoardDto> getList() {
		List<BoardDto> list = new ArrayList<>();
		String sql = "select * from board";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDto dto = new BoardDto();
				dto.setContent(rs.getString("content"));
				dto.setId(rs.getString("id"));
				dto.setNum(rs.getString("num"));
				dto.setPostdate(rs.getString("postDate"));
				dto.setTitle(rs.getString("title"));
				dto.setVisitcount(rs.getString("visitcount"));
				
				System.out.println("id : "+ rs.getString("id"));
				list.add(dto);
			}
			System.out.println("================"+list);
			return list;
			
		} catch (SQLException e) {
			System.out.println("BoardDao에서 SQLException 예외 발생");
			e.printStackTrace();
		}
		return list;
	}
}
