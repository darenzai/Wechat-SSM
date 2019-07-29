package com.dbteam.serviceIml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dbteam.beans.imageBar;
import com.dbteam.mapper.noticeBannerMapper;
import com.dbteam.service.noticeBannerService;

public class noticeBannerServiceIml  implements noticeBannerService{
	
	//�Զ�ע�� Mapper�ļ�
	@Autowired
	noticeBannerMapper noticeBannerMapper;
	
	
	//����ֲ�ͼƬ
	@Override
	public Boolean addUrl(imageBar imagebar) {
		
		return noticeBannerMapper.addUrl(imagebar);
	}
	
	
	//��ʾ���й���ͼƬ
	@Override
	public List<imageBar> getUrl() {
		
		return noticeBannerMapper.getUrl();
	}
	
	//ɾ������ͼƬ
	@Override
	public Boolean deleteUrl(String url) {
		return noticeBannerMapper.deleteUrl(url);
	}
	
	
}
