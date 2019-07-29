package com.dbteam.mapper;

import java.util.List;

import com.dbteam.beans.Swb;

//新表Mapper层
public interface SwbSecondMapper {
		
	public Boolean addSwbSecond(Swb swbSecond);
		
		//删除数据
		public Boolean deleteSwbSecond(int hostelId);
		
		//获取数据
		public Boolean getSwbSecond(int hostelId);
		
		//获得全部数据
		public List<Swb> allSwbSecond();
		
		//更新数据
		public Boolean updateSwbSecond(int hostelId);
		
}
