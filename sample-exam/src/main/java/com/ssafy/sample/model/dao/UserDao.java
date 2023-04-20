package com.ssafy.sample.model.dao;

import java.sql.SQLException;

import com.ssafy.sample.model.User;

public interface UserDao {

	User selectLogin(User user) throws SQLException;
	
}
