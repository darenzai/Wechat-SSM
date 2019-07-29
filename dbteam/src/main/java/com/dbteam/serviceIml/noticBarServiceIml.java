package com.dbteam.serviceIml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dbteam.beans.imageBar;
import com.dbteam.beans.noticBar;
import com.dbteam.mapper.noticeBarTextMapper;
import com.dbteam.service.noticeBarService;

//轮播图片实现层
public class noticBarServiceIml   implements noticeBarService{
	
	
	noticeBarTextMapper noticbartextMapper;
	
	
	//添加公告
	@Override
	public Boolean addNoticBarText(noticBar noticbar) {
		// TODO Auto-generated method stub
		return noticbartextMapper.addNoticBarText(noticbar);
	}
	
	//列出所有公告
	@Override
	public List<noticBar> getNoticBarText() {
		// TODO Auto-generated method stub
		return noticbartextMapper.getNoticBarText();
	}
	
	
	//修改公告
	@Override
	public Boolean updateNoticBarText(noticBar noticbar) {
		// TODO Auto-generated method stub
		return noticbartextMapper.updateNoticBarText(noticbar);
	}
	
	
	//删除公告
	@Override
	public Boolean deleteNoticBarText(int id) {
		// TODO Auto-generated method stub
		return noticbartextMapper.deleteNoticBarText(id);
	}

		
}
