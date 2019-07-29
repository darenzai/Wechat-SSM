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
 * �ֲ���Ƭ����
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
	 * ���Banner�ֲ���Ƭ
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
				logger.info("BannerͼƬ :" + image + "���汾�سɹ�");

			} else {
				logger.warn("BannerͼƬ�ϴ�ʧ�� ͼƬΪ��");
			}

		
		return map;

	}
	
	
	
	
	
	/*
	 * 		deleteBannerImages
	 * 		ɾ�����ݿ�����Urlͼ������
	 * 		(��ɾ����ֵ�������鿴���ݿ������Ƿ����)
	 * 		(������ھ�ɾ��)
	 */
	@ResponseBody
	@RequestMapping("deleteBannerImages")
	public Map<String, Object> deleteBannerImages(@RequestBody imageBar[] imagebar) {
		//System.out.println(imagebar);
		if (imagebar != null) {

			for (imageBar ss : imagebar) {

			
				if (noticebannerMapper.deleteUrl(ss.url)) {
					logger.info("Banner ��Ƭɾ���ɹ�");
				}else {
					logger.warn("Banner ��Ƭɾ��ʧ��");
				}

			}

		} else {
			logger.warn("Banner ��Ƭɾ��ʧ��  �����ļ�Ϊnull");
		}
		return null;
	}
	
	
	
	
	/* 
	 * 	getBanner
	 * 	�����ݿ������ȡ�ֲ�ͼ���Url
	 * 
	 */
	@ResponseBody
	@RequestMapping("getBanner")
	public List<imageBar> getBanner() {

		List<imageBar> list = noticebannerMapper.getUrl();

		return list;
	}




}
