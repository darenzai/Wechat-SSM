package com.dbteam.mapper;

import java.util.List;

import com.dbteam.beans.User;

public interface UserMapper {
	
	User getUser(String userName);
	
	public void saveUser(String userName);
}
