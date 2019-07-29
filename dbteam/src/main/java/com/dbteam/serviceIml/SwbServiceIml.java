package com.dbteam.serviceIml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbteam.beans.Swb;
import com.dbteam.beans.imageProduct;
import com.dbteam.mapper.SwbMapper;
import com.dbteam.service.SwbService;

@Service
public class SwbServiceIml implements SwbService {
	@Autowired
	SwbMapper swbMapper;
	
	//老表
	
	//列出所有宿舍全部信息
	public List<Swb> list() {
		return swbMapper.list();

	}
	
	
	//添加宿舍检查信息
	public Boolean add(Swb c) {
		return swbMapper.add(c);
	}

	//修改以Id为准
	public Boolean update(Swb c) {
		return swbMapper.update(c);
	}
	
	//删除宿舍以Id形式去数据库查找
	public Boolean delete(int id) {

		return swbMapper.delete(id);
	}

	//查找宿舍号 (列出所查宿舍所有的信息) 
	public List<Swb> get(int hostelId) {

		return swbMapper.get(hostelId);
	}
	
	
	//无用的测试方法
	@Override
	public List<Swb> listimage() {
		
		return swbMapper.listimage();
	}
}
