package com.dbteam.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;

import com.dbteam.beans.UserSecond;

public interface UserSecondService {
	
	//添加管理员
	Boolean addUser( UserSecond userSecond);
	
	//选择用户名 管理员每次登陆查看更新头像用
	Boolean selectName(int id);
	
	
	UserSecond selectAll(String userWeChatName);
	
	//列出所有管理员列表
	List<UserSecond> allSecondUser();
	
	//删除管理员
	Boolean deleteSecondUser(int id);
	
	//修改管理员基本信息
	Boolean updateSecondUser(UserSecond userSecond);
	
	//用户一开始登陆返回用户等级判断是 管理员还是什么
	int selectUserGrade(String userWeChatName);
	
	
	Boolean updateUserInformation(int id);
	
	
	//按用户名真实名字查找管理员个人信息		
	UserSecond selectUserName( String userName);
	
	
}
