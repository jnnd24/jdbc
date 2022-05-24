package com.javaex.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**********************************************
 * 
 * Dao(Data Access Object
 *
 **********************************************/

public class AuthorDao {
	
	
	//필드
	
	
	//생성자
	
	
	//메소드gs
	
	
	
	
	//메소드일반
	//--작가등록 메소드--
	public int authorInsert(String authorName, String authorDesc) {
		int count = 0;
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

		    // 3. SQL문 준비 / 바인딩 / 실행
			//SQL문 준비
			String query = "";
			query +=" insert into author ";
			query +=" values (seq_author_id.nextval, ?, ?) ";
			
			//바인딩
			pstmt = conn.prepareStatement(query); 	// 문자열 쿼리로 만들기
			pstmt.setString(1, authorName);				// ? 중 1번째 -- > 순서 중요
			pstmt.setString(2, authorDesc);			// ? 중 2번째 -- > 순서 중요
			
			//실행
			count = pstmt.executeUpdate();		
			
			
		    
		    // 4.결과처리
			System.out.println(count + "개 등록");

		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
		        if (pstmt != null) {
		            pstmt.close();
		        }
		        if (conn != null) {
		            conn.close();
		        }
		    } catch (SQLException e) {
		        System.out.println("error:" + e);
		    }

		}
		return count;
		
		
		
		
		
	}//authorInsert
	
	//--작가삭제 메소드--
	public int authorDelete(int authorId) {
		int count = 0;
				
				
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

		    // 3. SQL문 준비 / 바인딩 / 실행
			//SQL문 준비
			String query = "";
			query += " delete from author ";
			query += " where author_id = ? ";
			System.out.println(query);
			
			//바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, authorId);
			
			//실행
			count = pstmt.executeUpdate();
		    
		    // 4.결과처리
			System.out.println(count + "건 삭제되었습니다.");

		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
		        if (pstmt != null) {
		            pstmt.close();
		        }
		        if (conn != null) {
		            conn.close();
		        }
		    } catch (SQLException e) {
		        System.out.println("error:" + e);
		    }

		}
		return count;
	}
	
	//--작가업데이트 메소드--
	public int authorUpdate(int authorId, String authorName, String authorDesc) {
		int count = 0;
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//ResultSet rs = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			

		    // 3. SQL문 준비 / 바인딩 / 실행
			//sql문 준비
			String query = "";
			query += " update author ";
			query += " set author_name = ?, ";
			query += "     author_desc = ? ";
			query += " where author_id = ? ";
			System.out.println(query);
			
			
			//바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, authorName);
			pstmt.setString(2, authorDesc);
			pstmt.setInt(3, authorId);
			
			//실행
			count = pstmt.executeUpdate(); // 진행안되면 커밋 확인하기
		    
		    // 4.결과처리
			System.out.println(count + "건 수정되었습니다.");
			

		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
		        /*
		    	if (rs != null) {
		            rs.close();
		        }                
		        */
		        if (pstmt != null) {
		            pstmt.close();
		        }
		        if (conn != null) {
		            conn.close();
		        }
		    } catch (SQLException e) {
		        System.out.println("error:" + e);
		    }

		}
		return count;
		
		
	}
	
	//--작가테이블 셀렉트 메소드--
	public List<AuthorVo> authorSelect() {
		//리스트준비
		
		//리스트로 만들기
		List<AuthorVo> authorList = new ArrayList<AuthorVo>();
		
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

		    // 3. SQL문 준비 / 바인딩 / 실행
			//SQL문 준비
			String query = "";
			query += " select  author_id ";
			query += "         ,author_name ";
			query += "         ,author_desc ";
			query += " from author ";
			System.out.println(query);
			
			//바인딩
			pstmt = conn.prepareStatement(query);
			
			//실행
			rs = pstmt.executeQuery();
			
		    
		    // 4.결과처리
			
			//반복문으로 Vo만들고 list에 추가하기
			while(rs.next()) {
				int authorId = rs.getInt("author_id");
				String authorName = rs.getString("author_name");
				String authorDesc = rs.getString("author_desc");
				/*
				int authorId = rs.getInt(1); // 숫자로 뽑기도 가능
				String authorName = rs.getString(2);
				String authorDesc = rs.getString(3);
				*/
				//System.out.println(authorId + ", " + authorName + ", " + authorDesc);
				
				AuthorVo authorVo = new AuthorVo(authorId, authorName, authorDesc);
				
				authorList.add(authorVo);
			}
			
			

		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
		        if (rs != null) {
		            rs.close();
		        }                
		        if (pstmt != null) {
		            pstmt.close();
		        }
		        if (conn != null) {
		            conn.close();
		        }
		    } catch (SQLException e) {
		        System.out.println("error:" + e);
		    }

		}
		return authorList;
	}
	
	
	

}
