package com.dbteam.mapper;

import java.util.List;

import com.dbteam.beans.Swb;
import com.dbteam.beans.imageProduct;

//检查数据Mapper层
public interface SwbMapper {
	
	//添加数据
	public Boolean add(Swb swb);
	
	//删除数据
	public Boolean delete(int id);

	//获取数据
	public List<Swb> get(int hostelId);
	
	//修改数据库
	public Boolean update(Swb swb);
	
	//获取全部数据
	public List<Swb> list();
	
	//获取这个宿舍的全部数据
	public List<Swb> getHostelId(int hostel);
	
	//测试方法无用
	public List<Swb> listimage();
}
