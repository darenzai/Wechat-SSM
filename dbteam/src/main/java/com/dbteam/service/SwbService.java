package com.dbteam.service;

import java.util.List;

import com.dbteam.beans.Swb;
import com.dbteam.beans.imageProduct;
import com.dbteam.serviceIml.SwbServiceIml;

public interface SwbService {
	//列出卫生检查全部信息
	List<Swb> list();
	
	//添加 检查卫生信息
	Boolean add(Swb c);
	
	//删除检查卫生信息
	Boolean delete(int c);
	
	//修改检查卫生信息
	Boolean update(Swb c);
	
	//用宿舍号查找列出这个宿舍的全部卫生信息
	List<Swb> get(int hostelId);
	
	//没用的接口
	List<Swb> listimage();
	
	
	
	
}
