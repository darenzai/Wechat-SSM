package com.dbteam.service;

import java.util.List;

import com.dbteam.beans.imageBar;

//添加轮播图片接口层
public interface noticeBannerService {
	
	
	//添加图片
	Boolean addUrl(imageBar imagebar);
	
	//列出显示的所有图片链接
	List<imageBar> getUrl();
	
	//删除
	Boolean deleteUrl(String url);
	

}
