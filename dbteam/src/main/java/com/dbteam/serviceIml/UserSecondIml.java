package com.dbteam.serviceIml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dbteam.beans.UserSecond;
import com.dbteam.mapper.UserSecondMapper;
import com.dbteam.service.UserSecondService;

//管理员接口层

public class UserSecondIml  implements UserSecondService{
	
	
	
	@Autowired
	UserSecondMapper userSecondMapper;
	
	
	//添加管理员信息
	public Boolean addUser(UserSecond userSecond) {
		return userSecondMapper.addUser(userSecond);
	}
	
	
	//查找用户信息 ID形式
	@Override
	public Boolean selectName(int id) {
		
		return userSecondMapper.selectName(id);
	}
	
	
	//查出该用户所有信息
	public UserSecond selectAll(String userWeChatName) {
		return userSecondMapper.selectAll(userWeChatName);
	}
	
	//全部管理员数据
	public List<UserSecond> allSecondUser() {
		
		return userSecondMapper.allSecondUser();
	}


	//删除管理员操做
	@Override
	public Boolean deleteSecondUser(int id) {
		
		return userSecondMapper.deleteSecondUser(id);
	}


	//修改管理员
	@Override
	public Boolean updateSecondUser(UserSecond userSecond) {
		return userSecondMapper.updateSecondUser(userSecond);
	}


	//按名称查找管理员(真实姓名)
	@Override
	public int selectUserGrade(String userWeChatName) {
		// TODO Auto-generated method stub
		return userSecondMapper.selectUserGrade(userWeChatName);
	}


	//更新 和上面那个差不多
	@Override
	public Boolean updateUserInformation(int id) {
		// TODO Auto-generated method stub
		return userSecondMapper.updateUserInformation(id);
	}



	@Override
	public UserSecond selectUserName(String userName) {
		// TODO Auto-generated method stub
		return userSecondMapper.selectUserName(userName);
	}
	
	
}
