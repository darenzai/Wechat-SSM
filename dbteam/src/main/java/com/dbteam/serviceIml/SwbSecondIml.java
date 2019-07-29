package com.dbteam.serviceIml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dbteam.beans.Swb;
import com.dbteam.mapper.SwbSecondMapper;
import com.dbteam.service.SwbSecondService;

public class SwbSecondIml implements SwbSecondService {
	
	@Autowired
	SwbSecondMapper  swbSecondMapper;
	
	//按新表 按宿舍号查找
	public Boolean getSecond(int hostelId) {
		
		
		
		
		return swbSecondMapper.getSwbSecond(hostelId);
	}

	//新表删除宿舍 以宿舍号形式
	public Boolean deleteSecond(int hostelId) {
		
		return swbSecondMapper.deleteSwbSecond(hostelId);
	}
	
	
	//添加宿舍信息 和老表一起添加
	public Boolean addSecond(Swb swbSecond) {
		
		return swbSecondMapper.addSwbSecond(swbSecond);
	}

	//新表(一开始显示) 列出所有宿舍
	@Override
	public List<Swb> allSwbSecond() {
		
		return swbSecondMapper.allSwbSecond();
	}

	//修改操做
	@Override
	public Boolean updateSwbSecond(int hostelId) {
		
		return swbSecondMapper.updateSwbSecond(hostelId);
	}
	
}
