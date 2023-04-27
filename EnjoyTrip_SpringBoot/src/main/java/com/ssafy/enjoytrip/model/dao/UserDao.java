package com.ssafy.enjoytrip.model.dao;

import java.sql.SQLException;

import com.ssafy.enjoytrip.dto.User;

public interface UserDao {
    User selectUser(User user) throws SQLException;
    void insertUser(User user) throws SQLException;
    void deleteUser(User user) throws SQLException;
    void updateUser(User user) throws SQLException;
	int selectUserById(String id) throws SQLException;
	User selectUserPw(User user) throws SQLException;
}