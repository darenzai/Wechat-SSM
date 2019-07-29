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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dbteam.beans.imageBar;
import com.dbteam.mapper.noticeBannerMapper;
import com.dbteam.mapper.noticeBarTextMapper;

/*
 * 
 * 
 * 轮播照片管理
 * 
 */

@Controller
@RequestMapping("banner")
public class BannerController {

	@Autowired
	noticeBannerMapper noticebannerMapper;
	
	private  Logger logger=Logger.getLogger(BannerController.class);
	
	
	
	
	/*
	 * 
	 * 添加Banner轮播照片
	 * 
	 */
	
	@ResponseBody
	@RequestMapping(value = "/addBannerImages")
	public Map<String, Object> addBannerImages(HttpServletRequest request,
			@RequestParam(value = "file", required = false) MultipartFile file

	) throws IllegalStateException, IOException {

		Map<String, Object> map = new HashMap<String, Object>();

		request.setCharacterEncoding("UTF-8");

			if (file!=null) {
		
				String urltime = SwbController.tupiantime;
				String nname = UUID.randomUUID().toString();
				String oldName = file.getOriginalFilename();
				
				String houchuo = oldName.substring(oldName.lastIndexOf("."));
				File local = new File("D:\\" +urltime+ nname + houchuo);
				String image =	urltime+ nname + houchuo;
				imageBar imagebar = new imageBar();
				imagebar.setUrl(image);
				file.transferTo(local);
				noticebannerMapper.addUrl(imagebar);
				logger.info("Banner图片 :" + image + "保存本地成功");

			} else {
				logger.warn("Banner图片上传失败 图片为空");
			}

		
		return map;

	}
	
	
	
	
	
	/*
	 * 		deleteBannerImages
	 * 		删除数据库里面Url图像链接
	 * 		(把删除的值传过来查看数据库里面是否存在)
	 * 		(如果存在就删除)
	 */
	@ResponseBody
	@RequestMapping("deleteBannerImages")
	public Map<String, Object> deleteBannerImages(@RequestBody imageBar[] imagebar) {
		//System.out.println(imagebar);
		if (imagebar != null) {

			for (imageBar ss : imagebar) {

			
				if (noticebannerMapper.deleteUrl(ss.url)) {
					logger.info("Banner 照片删除成功");
				}else {
					logger.warn("Banner 照片删除失败");
				}

			}

		} else {
			logger.warn("Banner 照片删除失败  传入文件为null");
		}
		return null;
	}
	
	
	
	
	/* 
	 * 	getBanner
	 * 	从数据库里面获取轮播图像的Url
	 * 
	 */
	@ResponseBody
	@RequestMapping("getBanner")
	public List<imageBar> getBanner() {

		List<imageBar> list = noticebannerMapper.getUrl();

		return list;
	}




}
