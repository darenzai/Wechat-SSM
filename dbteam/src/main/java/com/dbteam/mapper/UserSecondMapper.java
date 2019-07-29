package com.dbteam.mapper;

import java.util.List;

import com.dbteam.beans.UserSecond;

//管理员Mapper层
public interface UserSecondMapper {
	
	
	//添加管理员
	Boolean addUser(UserSecond userSecond);
	
	//查找管理员
	Boolean selectName(int id);
	
	//获得管理员全部数据
	UserSecond selectAll(String userWeChatName);
	
	//获取全部管理员
	List<UserSecond> allSecondUser();
	
	//删除管理员
	Boolean deleteSecondUser(int id);
	
	//修改管理员
	Boolean updateSecondUser( UserSecond userSecond);
	
	//返回管理员等级
	int selectUserGrade(String userWeChatName);
	
	//更新管理员数据
	Boolean updateUserInformation(int id);
	
	//查找管理员
	UserSecond selectUserName(String userName);
	
}
