package com.ssafy.enjoytrip.model.service;

import java.sql.SQLException;

import com.ssafy.enjoytrip.dto.User;

public interface UserService {
    User login(User user) throws Exception;
    void signUpUser(User user) throws Exception;
    void deleteUser(User user) throws Exception;
    void editUser(User user) throws Exception;
	User idCheck(String id) throws Exception;
	User findPw(User user) throws SQLException;
	User getUser(String userId) throws SQLException;
}