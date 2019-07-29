package com.dbteam.serviceIml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbteam.beans.User;
import com.dbteam.service.UserService;

@Service
public class UserServiceIml implements UserService{
	
	//���� (������ �Ժ���°汾ʱ��ɾ��) 
	
	@Autowired
	UserService userService;
	
	public List<User> getUser(String userName) {
		
		return userService.getUser(userName);
	}

	public void saveUser(String userName) {
		
		 userService.saveUser(userName);
		
	}
	

}
