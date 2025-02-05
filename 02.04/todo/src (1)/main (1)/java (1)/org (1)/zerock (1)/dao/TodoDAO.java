package org.zerock.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.zerock.dto.TodoAddDTO;

import lombok.Cleanup;

public enum TodoDAO {

	INSTANCE;

	// bad code
	public String makeConnection() throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		@Cleanup
		Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/webdb", "webdbuser", "webdbuser");
		@Cleanup
		PreparedStatement pstmt = conn.prepareStatement("select now()"); // 문자열 ; 없도록 주의

		@Cleanup
		ResultSet resultSet = pstmt.executeQuery();

		resultSet.next();

		return resultSet.getString(1);
	}

	public void insert(TodoAddDTO todoDTO) throws Exception {

		// 마지막 ; 주의
		// 값을 제외한 순수한 SQL문 :v1 :v2
		String sql = "insert into tbl_todo (title,writer) values (?,?)";

		Class.forName("org.mariadb.jdbc.Driver");
		@Cleanup
		Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/webdb", "webdbuser", "webdbuser");
		@Cleanup
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, todoDTO.getTitle());
		pstmt.setString(2, todoDTO.getWriter());
		
		//DML - insert, update, delete 결과가 몇 개의 행이 영향을 받았는지 
		int count = pstmt.executeUpdate();
		
		if(count != 1) {
			throw new Exception("INSERT PROBLEM NOT 1");
		}
		
		//finally
		//pstmt.close()
		//conn.close()
		
	}

}
