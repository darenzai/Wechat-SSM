package com.dbteam.service;

import java.util.List;

import com.dbteam.beans.imageBar;
import com.dbteam.beans.noticBar;

public interface noticeBarService {
	
	//�г����еĹ���
	List<noticBar> getNoticBarText();
	
	//��ӹ���
	Boolean addNoticBarText(noticBar noticbar);
	
	//�޸Ĺ���	
	Boolean updateNoticBarText(noticBar noticbar);
	
	//ɾ������
	Boolean deleteNoticBarText(int id);
	
	
	
 }
