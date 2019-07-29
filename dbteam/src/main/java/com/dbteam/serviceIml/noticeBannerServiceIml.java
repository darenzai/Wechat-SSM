package com.dbteam.serviceIml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dbteam.beans.imageBar;
import com.dbteam.mapper.noticeBannerMapper;
import com.dbteam.service.noticeBannerService;

public class noticeBannerServiceIml  implements noticeBannerService{
	
	//自动注入 Mapper文件
	@Autowired
	noticeBannerMapper noticeBannerMapper;
	
	
	//添加轮播图片
	@Override
	public Boolean addUrl(imageBar imagebar) {
		
		return noticeBannerMapper.addUrl(imagebar);
	}
	
	
	//显示所有公告图片
	@Override
	public List<imageBar> getUrl() {
		
		return noticeBannerMapper.getUrl();
	}
	
	//删除公告图片
	@Override
	public Boolean deleteUrl(String url) {
		return noticeBannerMapper.deleteUrl(url);
	}
	
	
}
