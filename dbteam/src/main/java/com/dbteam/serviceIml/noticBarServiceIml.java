package com.dbteam.serviceIml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dbteam.beans.imageBar;
import com.dbteam.beans.noticBar;
import com.dbteam.mapper.noticeBarTextMapper;
import com.dbteam.service.noticeBarService;

//�ֲ�ͼƬʵ�ֲ�
public class noticBarServiceIml   implements noticeBarService{
	
	
	noticeBarTextMapper noticbartextMapper;
	
	
	//��ӹ���
	@Override
	public Boolean addNoticBarText(noticBar noticbar) {
		// TODO Auto-generated method stub
		return noticbartextMapper.addNoticBarText(noticbar);
	}
	
	//�г����й���
	@Override
	public List<noticBar> getNoticBarText() {
		// TODO Auto-generated method stub
		return noticbartextMapper.getNoticBarText();
	}
	
	
	//�޸Ĺ���
	@Override
	public Boolean updateNoticBarText(noticBar noticbar) {
		// TODO Auto-generated method stub
		return noticbartextMapper.updateNoticBarText(noticbar);
	}
	
	
	//ɾ������
	@Override
	public Boolean deleteNoticBarText(int id) {
		// TODO Auto-generated method stub
		return noticbartextMapper.deleteNoticBarText(id);
	}

		
}
