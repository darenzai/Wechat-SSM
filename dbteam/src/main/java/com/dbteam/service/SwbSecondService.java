package com.dbteam.service;

import java.util.List;

import com.dbteam.beans.Swb;

//管理员用户接口层
public interface SwbSecondService {
	
	//得到这个宿舍的成绩
	public Boolean getSecond(int hostelId);
	
	//删除这个宿舍的数据
	public Boolean deleteSecond(int hostelId);
	
	//添加这个宿舍的数据
	public Boolean addSecond(Swb swbSecond);
	
	//列出这个宿舍的所有数据
	public List<Swb> allSwbSecond();
	
	//修改这个宿舍的数据
	public Boolean updateSwbSecond(int hostelId);
}
