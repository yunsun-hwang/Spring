package com.ssafy.enjoytrip.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.ssafy.enjoytrip.dto.User;

@Repository
public class UserDaoImpl implements UserDao {
    
    private DataSource dataSource;
    public UserDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public int selectUserById(String id) throws SQLException {
    	try(
                Connection con = dataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement(
                    "select id, pw, name, email from user where id = ? "
                );
            ){
                pstmt.setString(1, id);
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()) return 1;
                return 0;
            }
	}
    
    @Override
    public User selectUser(User user) throws SQLException {
        try(
            Connection con = dataSource.getConnection();
            PreparedStatement pstmt = con.prepareStatement(
                "select id, pw, name, email from user where id = ? and pw = ? "
            );
        ){
            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getPw());
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                User u = new User();
                u.setId(rs.getString("id"));
                u.setPw(rs.getString("pw"));
                u.setName(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                return u;
            }
            return null;
        }
    }
	@Override
	public void insertUser(User user) throws SQLException {
		try(
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
				"insert into user(id, pw, name, email) values(?, ?, ?, ?) "
			);
		){
			int i = 0;
			pstmt.setString(++i, user.getId());
			pstmt.setString(++i, user.getPw());
			pstmt.setString(++i, user.getName());
			pstmt.setString(++i, user.getEmail());
			pstmt.executeUpdate();
		}
	}
	@Override
	public void deleteUser(User user) throws SQLException {
		try(
				Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
					"delete from user where id = ? "
				);
			){
				pstmt.setString(1, user.getId());
				pstmt.executeUpdate();
			}
	}
	@Override
	public void updateUser(User user) throws SQLException {
		try(
				Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
					"update user set name = ?, pw = ?, email = ? where id = ? "
				);
			){
				int i = 0;
				pstmt.setString(++i, user.getName());
				pstmt.setString(++i, user.getPw());
				pstmt.setString(++i, user.getEmail());
				pstmt.setString(++i, user.getId());
				pstmt.executeUpdate();
			}
	}
	@Override
	public User selectUserPw(User user) throws SQLException {
		try(
                Connection con = dataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement(
                    "select id, pw, name, email from user where id = ? and name = ? and email = ? "
                );
            ){
				int i = 0;
                pstmt.setString(++i, user.getId());
                pstmt.setString(++i, user.getName());
                pstmt.setString(++i, user.getEmail());
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()) {
                    User u = new User();
                    u.setId(rs.getString("id"));
                    u.setPw(rs.getString("pw"));
                    u.setName(rs.getString("name"));
                    u.setEmail(rs.getString("email"));
                    return u;
                }
                return null;
            }
	}

}