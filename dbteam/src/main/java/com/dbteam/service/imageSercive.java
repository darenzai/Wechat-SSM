package com.dbteam.service;

import java.util.List;

import com.dbteam.beans.Swb;
import com.dbteam.beans.imageBar;
import com.dbteam.beans.imageProduct;

//卫生图片接口层
public interface imageSercive {
	
	//列出所有照片对映Only值
	public List<imageProduct> getImage(int  only);
	
	
	//添加照片对映Only值
	public Boolean addImage(imageProduct imageproduct);
	

	
}
