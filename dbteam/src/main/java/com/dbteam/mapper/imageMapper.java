package com.dbteam.mapper;

import java.util.List;

import com.dbteam.beans.Swb;
import com.dbteam.beans.imageProduct;

//ͼ��Mapper��

public interface imageMapper {
	
	//�г�������������ͼƬ
	public List<imageProduct> getImage(int only);
	
	
	//���ͼƬ
	public  Boolean addImage(imageProduct imageproduct);
	
	
	//��ʾ������Ƭ
	public List<imageProduct> getAllImage();
}
