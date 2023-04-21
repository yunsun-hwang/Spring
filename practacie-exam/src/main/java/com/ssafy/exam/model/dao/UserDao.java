package com.ssafy.exam.model.dao;

import java.sql.SQLException;

import com.ssafy.exam.model.User;

public interface UserDao {

	User selectLogin(User user) throws SQLException;

}
