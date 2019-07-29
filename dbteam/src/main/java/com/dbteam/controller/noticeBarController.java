package com.dbteam.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dbteam.beans.Swb;
import com.dbteam.beans.imageBar;
import com.dbteam.beans.imageProduct;
import com.dbteam.beans.noticBar;
import com.dbteam.mapper.noticeBarTextMapper;


/*
 * 
 * 		轮播公告管理
 * 
 */
@Controller
@RequestMapping("noticeBar")
public class noticeBarController {

	@Autowired
	noticeBarTextMapper noticbartextMapper;
	private  Logger logger=Logger.getLogger(noticeBarController.class);
	
	/*
	 * 
	 * 		添加轮播公告
	 * 
	 */
	@RequestMapping(value = "addNoticeBar", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addnoticBarText(@RequestBody noticBar noticbar) {

		Map<String, Object> map = new HashMap<String, Object>();
		String text = noticbar.text;
		noticbar.setTextTime(SwbController.time);

		if (noticbartextMapper.addNoticBarText(noticbar)) {
			logger.info("轮播公告添加成功");
		} else {
			logger.warn("轮播公告添加失败");
		}

		return map;

	}

	
	/*
	 * 
	 * 从数据库里面获取轮播公告
	 * 
	 */
	@ResponseBody
	@RequestMapping("getNoticeBar")
	public Map<String, Object> getNoticBarText() {

		Map<String, Object> map = new HashMap<String, Object>();

		List<noticBar> list = noticbartextMapper.getNoticBarText();
		
		map.put("list", list);

		return map;
	}

	
	
	/*
	 * 
	 *   	更新想要的轮播公告
	 * 
	 */
	@ResponseBody
	@RequestMapping("updateNoticeBar")
	public Map<String, Object> updateNoticBarText(@RequestBody noticBar noticbar) {

		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(noticbar.text);
		noticbar.setId(noticbar.id);
		noticbar.setTextTime(SwbController.time);
		noticbar.setText(noticbar.text);
		if (noticbartextMapper.updateNoticBarText(noticbar)) {
			logger.info("轮播公告更新成功");
		} else {
			logger.warn("轮播公告更新失败");
		}

		return map;

	}
	
	
	
	/*
	 * 
	 *  	删除轮播公告
	 *  
	 * 
	 */
	
	@ResponseBody
	@RequestMapping("deleteNoticeBar")
	public Map<String, Object> deleteNoticBarText(@RequestBody noticBar noticbar) {

		Map<String, Object> map = new HashMap<String, Object>();

		int id = noticbar.id;

		if (noticbartextMapper.deleteNoticBarText(id)) {
			logger.info("轮播公告删除成功");

		} else {
			logger.warn("轮播公告删除失败");
		}

		return map;

	}


	

}
