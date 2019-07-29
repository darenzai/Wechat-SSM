package com.dbteam.mapper;

import java.util.List;

import com.dbteam.beans.imageBar;

//轮播图片接口层
public interface noticeBannerMapper {
	
	//添加轮播图片链接
	Boolean addUrl(imageBar imagebar);
	
	//获取所有连接
	List<imageBar> getUrl();
	
	//删除链接
	Boolean deleteUrl(String url);
}
