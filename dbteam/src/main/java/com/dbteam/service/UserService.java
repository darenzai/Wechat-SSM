package com.dbteam.service;

import java.util.List;

import com.dbteam.beans.User;
//����
public interface UserService {
	
	List<User> getUser(String userName);
	
	void saveUser(String userName);
}
