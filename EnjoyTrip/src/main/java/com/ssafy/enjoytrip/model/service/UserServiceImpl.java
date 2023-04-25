package com.ssafy.enjoytrip.model.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.ssafy.enjoytrip.dto.User;
import com.ssafy.enjoytrip.model.dao.UserDao;
import com.ssafy.enjoytrip.model.dao.UserDaoImpl;

@Service
public class UserServiceImpl implements UserService {

    private UserDao dao;
    public UserServiceImpl(UserDao dao) {
		this.dao = dao;
	}
    
	@Override
    public User login(User user) throws Exception {
        return dao.selectUser(user);
    }
	@Override
	public void signUpUser(User user) throws Exception {
		dao.insertUser(user);
	}
	@Override
	public void deleteUser(User user) throws Exception {
		dao.deleteUser(user);
		
	}
	@Override
	public void editUser(User user) throws Exception {
		dao.updateUser(user);
	}
	@Override
	public int idCheck(String id) throws Exception {
		return dao.selectUserById(id);
	}
	@Override
	public User findPw(User user) throws SQLException {
		return dao.selectUserPw(user);
	}

}