package com.dbteam.service;

import java.util.List;

import com.dbteam.beans.Swb;
import com.dbteam.beans.imageBar;
import com.dbteam.beans.imageProduct;

//����ͼƬ�ӿڲ�
public interface imageSercive {
	
	//�г�������Ƭ��ӳOnlyֵ
	public List<imageProduct> getImage(int  only);
	
	
	//�����Ƭ��ӳOnlyֵ
	public Boolean addImage(imageProduct imageproduct);
	

	
}
