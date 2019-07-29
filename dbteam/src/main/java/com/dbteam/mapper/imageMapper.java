package com.dbteam.mapper;

import java.util.List;

import com.dbteam.beans.Swb;
import com.dbteam.beans.imageProduct;

//图像Mapper层

public interface imageMapper {
	
	//列出这个宿舍的所有图片
	public List<imageProduct> getImage(int only);
	
	
	//添加图片
	public  Boolean addImage(imageProduct imageproduct);
	
	
	//显示所有照片
	public List<imageProduct> getAllImage();
}
