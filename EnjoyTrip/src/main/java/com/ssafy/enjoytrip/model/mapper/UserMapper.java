package com.ssafy.enjoytrip.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.dto.User;

@Mapper
public interface UserMapper {
    User selectUser(User user) throws SQLException;
    void insertUser(User user) throws SQLException;
    void deleteUser(User user) throws SQLException;
    void updateUser(User user) throws SQLException;
	int selectUserById(String id) throws SQLException;
	User selectUserPw(User user) throws SQLException;
}