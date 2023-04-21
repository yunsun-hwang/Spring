package com.ssafy.exam.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.ssafy.exam.model.User;

@Repository
public class UserDaoImpl implements UserDao{
	private DataSource dataSource;
	public UserDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public User selectLogin(User user) throws SQLException {
		try(
				Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"select user_id, user_name, user_password from members where user_id = ? and user_password = ?"
			);
		){
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				User userInfo = new User();
				userInfo.setId(rs.getString("user_id"));
				userInfo.setPassword(rs.getString("user_password"));
				userInfo.setName(rs.getString("user_name"));
				return userInfo;
			}
		}
		
		return null;
	}
}
