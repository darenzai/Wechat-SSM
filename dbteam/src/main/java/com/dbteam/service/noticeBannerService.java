package com.dbteam.service;

import java.util.List;

import com.dbteam.beans.imageBar;

//����ֲ�ͼƬ�ӿڲ�
public interface noticeBannerService {
	
	
	//���ͼƬ
	Boolean addUrl(imageBar imagebar);
	
	//�г���ʾ������ͼƬ����
	List<imageBar> getUrl();
	
	//ɾ��
	Boolean deleteUrl(String url);
	

}
