package com.dbteam.service;

import java.util.List;

import com.dbteam.beans.imageBar;
import com.dbteam.beans.noticBar;

public interface noticeBarService {
	
	//列出所有的公告
	List<noticBar> getNoticBarText();
	
	//添加公告
	Boolean addNoticBarText(noticBar noticbar);
	
	//修改公告	
	Boolean updateNoticBarText(noticBar noticbar);
	
	//删除公告
	Boolean deleteNoticBarText(int id);
	
	
	
 }
