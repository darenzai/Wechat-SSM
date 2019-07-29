package com.dbteam.mapper;

import java.util.List;

import com.dbteam.beans.imageBar;
import com.dbteam.beans.noticBar;

public interface noticeBarTextMapper {
	
	
	Boolean addNoticBarText(noticBar noticbar);
	
	List<noticBar> getNoticBarText();
	
	
	Boolean updateNoticBarText(noticBar noticbar);
	
	Boolean deleteNoticBarText(int id);
	
	
}
