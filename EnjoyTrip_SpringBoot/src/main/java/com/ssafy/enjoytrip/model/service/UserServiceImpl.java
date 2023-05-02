package com.ssafy.enjoytrip.model.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.ssafy.enjoytrip.dto.User;
import com.ssafy.enjoytrip.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	private UserMapper userMapper;
	public UserServiceImpl(UserMapper userMapper) {
		super();
		this.userMapper = userMapper;
	}
	
	@Override
    public User login(User user) throws Exception {
        return userMapper.selectUser(user);
    }
	@Override
	public void signUpUser(User user) throws Exception {
		userMapper.insertUser(user);
	}
	@Override
	public void deleteUser(User user) throws Exception {
		userMapper.deleteUser(user);
	}
	@Override
	public void editUser(User user) throws Exception {
		userMapper.updateUser(user);
	}
	@Override
	public User idCheck(String id) throws Exception {
		return userMapper.selectUserById(id);
	}
	@Override
	public User findPw(User user) throws SQLException {
		return userMapper.selectUserPw(user);
	}

	@Override
	public User getUser(String userId) throws SQLException {
		return userMapper.selectUserById(userId);
	}

}