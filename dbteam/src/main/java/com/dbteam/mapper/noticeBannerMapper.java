package com.dbteam.mapper;

import java.util.List;

import com.dbteam.beans.imageBar;

//�ֲ�ͼƬ�ӿڲ�
public interface noticeBannerMapper {
	
	//����ֲ�ͼƬ����
	Boolean addUrl(imageBar imagebar);
	
	//��ȡ��������
	List<imageBar> getUrl();
	
	//ɾ������
	Boolean deleteUrl(String url);
}
