package com.abu.ws.service;

import com.abu.ws.dao.UserDAO;
import com.abu.ws.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	UserDAO userDAO;

	public boolean isExist(String username) {
		User user = getByName(username);
		return null != user;
	}

	public User getByName(String username) {
		return userDAO.findByUsername(username);
	}

	public User get(String username, String password) {
		return userDAO.getByUsernameAndPassword(username, password);
	}

	public void add(User user) {
		userDAO.save(user);
	}
}
