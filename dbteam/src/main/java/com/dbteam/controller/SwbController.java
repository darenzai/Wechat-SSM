package com.dbteam.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import java.util.logging.SimpleFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.ibatis.annotations.Mapper;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dbteam.beans.Swb;
import com.dbteam.beans.imageProduct;
import com.dbteam.mapper.SwbMapper;
import com.dbteam.mapper.SwbSecondMapper;
import com.dbteam.mapper.imageMapper;

/*
 * 
 *  	���������ݼ��
 * 
 */


@Controller
@RequestMapping("swb")
public   class   SwbController {
	
	private  Logger logger=Logger.getLogger(SwbController.class);
	
	@Autowired
	SwbMapper swbMapper;

	@Autowired
	SwbSecondMapper swbSecondMapper;

	@Autowired
	imageMapper imagemapper;

	public static int only = 3;

	public static String newName;

	public static String xy;

	public static String tupian = "1212";

	
	static Date now = new Date();

	static SimpleDateFormat ft = new SimpleDateFormat("YYYY-MM-dd hh:mm");

	static SimpleDateFormat ft1 = new SimpleDateFormat("YYYY-MM-dd");

	public static String time = ft.format(now);
	public static String tupiantime = ft1.format(now);
	
	
	
	/*
	 * 	���������������
	 * 
	 */
	
	
	@ResponseBody
	@RequestMapping("updateSwbContexts")
	public Map<String, Object> updateSwbContexts(@RequestBody(required = false) Swb swb,
			@RequestParam(value = "file", required = false) MultipartFile[] file)
			throws IllegalStateException, IOException {
		Map<String, Object> map = new HashMap<>();

		if (swb != null) {
			int id = swb.id;
			int hostelId = swb.hostelId;
			System.out.println(id);
			
			if (swbSecondMapper.getSwbSecond(hostelId)) {
				
				if ((swbMapper.delete(id)) && (swbSecondMapper.deleteSwbSecond(hostelId))) {

					if ((swbMapper.add(swb)) && (swbSecondMapper.addSwbSecond(swb))) {
						logger.info("������������޸ĳɹ�");
						System.out.println("�޸�����");
						only++;
					} else {
						
						logger.info("������������޸�ʧ��1");
					}
				} else {
					
				}
			} else {
				if (swbMapper.delete(id)) {

					if (swbMapper.add(swb)) {
						logger.info("������������޸ĳɹ�");
						System.out.println("�޸�����");
						only++;
					} else {
						logger.info("������������޸�ʧ��2");
					}
				} else {
					
				}
			}

		} else {
			
		}

		return map;
	}
	
	/*
	 * 		listSwb
	 * 		��ȡȫ�������������
	 * 
	 */
	
	
	@ResponseBody
	@RequestMapping(value = "/listSwb", method = RequestMethod.GET)
	public Map<String, Object> listSwb() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<Swb> list = swbMapper.list();

		if (list != null) {
			map.put("swblist", list);
		} 


	
		return map;

	}
	
	
	
	/*
	 * 
	 * 	checkDataOldTable/getItem
	 * 	������Ż�ȡ����(���ϱ������ѯ)
	 * 
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/checkDataOldTable/getItem", method = RequestMethod.GET)
	public Map<String, Object> checkDataOldTable(Integer hostelId) {

		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(hostelId);
		if (hostelId != null) {
			List<Swb> list = new ArrayList<>();
			list = swbMapper.get(hostelId);
			System.out.println("���سɹ�");
			map.put("getHostelList",list);
		} else {
			logger.warn("������ż����������ʧ��---����hosteIdΪ��");
		}

		return map;

	}
	
	
	/*
	 * 	deleteSwb
	 * 	ɾ������������
	 * 
	 */
	
	@ResponseBody
	@RequestMapping(value = "/deleteSwb", method = RequestMethod.POST)
	public Map<String, Object> deleteSwb(@RequestBody Swb swb) {

		Map<String, Object> map = new HashMap<String, Object>();

		if (swb != null) {
			int id = swb.id;
			int dorm = swb.hostelId;
			System.out.println("ɾ���±������IDΪ   :" + dorm);
			if (swbSecondMapper.getSwbSecond(dorm)) {
				System.out.println("�±���������IdΪ ����" + dorm);
				if ((swbMapper.delete(id)) && (swbSecondMapper.updateSwbSecond(dorm))) {
					logger.info("�����������ɾ���ɹ�");
				} else {

					logger.warn("�����������ɾ��ʧ��");
				}
			} else {
				if (swbMapper.delete(id)) {
					logger.info("�����������------�±����ݲ����� �ɱ�ɾ���ɹ�");
					
				} else {
					logger.warn("�����������------�±����ݲ����� �ɱ�ɾ��ʧ��");
				}
			}

		} else {
			
			logger.warn("�����������------����ֵΪ��");
		}

		return map;
	}

	
	
	/*
	 * 
	 * 	��ȡ�±�����������������
	 * 
	 */
	
	@ResponseBody
	@RequestMapping(value = "/checkDataNewTable")
	public Map<String, Object> checkDataNewTable() {

		Map<String, Object> map = new HashMap<>();

		List<Swb> list = swbSecondMapper.allSwbSecond();
		map.put("allList", list);
		
		return map;
	}

	
	/*
	 * 
	 * 	����������ʱ���ͼƬ
	 * 
	 */
	
	
	@ResponseBody
	@RequestMapping(value = "/addSwbImages")
	public synchronized Map<String, Object> addSwbImages(HttpServletRequest request,
			
			@RequestParam(value = "file", required = false) MultipartFile file,
			@RequestParam(value = "swb", required = false) Swb swb
	
	) throws IllegalStateException, IOException {

		Map<String, Object> map = new HashMap<String, Object>();
		
		request.setCharacterEncoding("UTF-8");
		
		
		if (file != null) {

			if (!file.isEmpty()) {
				newName = UUID.randomUUID().toString();
				String oldName = file.getOriginalFilename();
				System.out.println("1����ԭʼ ��"+oldName);
				System.out.println("2��������� ��"+newName);
				String houchuo = oldName.substring(oldName.lastIndexOf("."));
				File local = new File("D:\\" + tupiantime + newName + houchuo);
				tupian = tupiantime + newName + houchuo;
				System.out.println("3�����Ӻ���ļ���"+tupian);
				file.transferTo(local);			
				imageProduct imageproduct = new imageProduct();
				System.out.println("4������Ȼ�� "+tupian);
				imageproduct.setImages(tupian);			
				imageproduct.setShijian(tupiantime);
				imagemapper.addImage(imageproduct);				
				logger.info("ͼƬ :" + tupiantime + "�������ݿ�ɹ�");
					
			} else {
				logger.info("ͼƬ :" + tupiantime + "�������ݿ�ʧ�� ͼƬΪ��");
			}

		} else {
			logger.info("ͼƬ :" + tupiantime + "�������ݿ�ʧ�� ͼƬΪ��2");
		}
		return map;

	}

	
	
	/*
	 * 
	 * 	����������������
	 * 
	 */
	
	@ResponseBody
	@RequestMapping(value = "/addSwbContexts")
	public  Map<String, Object> addSwbContexts(@RequestBody Swb swb) throws IllegalStateException, IOException {

		Map<String, Object> map = new HashMap<String, Object>();

		if (swb != null) {
			

			Swb swb1 = new Swb();
			

			Boolean xx = swbMapper.add(swb);

			int hostelId = swb.hostelId;
			

			if (swbSecondMapper.getSwbSecond(hostelId)) {
				if (swbSecondMapper.deleteSwbSecond(hostelId)) {

					only++;
					if (swbSecondMapper.addSwbSecond(swb)) {
						
						
						logger.info(only+"   : onlyֵ");
						System.out.println("����");
						logger.info("����������ı�������ӳɹ�");
				
					}
				} else {

					logger.warn("����������ı���������ʧ��");
				}

			} else {
				if (swbSecondMapper.addSwbSecond(swb)) {
					logger.info(only+"   : onlyֵ");
					System.out.println("�������");
					only++;
					
	
					logger.info("����������ı�������ӳɹ�");
				
				} else {
					
					logger.warn("����������ı��������ʧ��");
				}
			}

		} else {

			logger.info("����������ı��������ʧ�ܡ�������ֵΪ��");
		}

		return map;

	}

	



	@ResponseBody
	@RequestMapping(value = "listimage")
	public Map<String, Object> listimage(HttpServletRequest request) {

		
		Map<String, Object> map = new HashMap<String, Object>();

		List<Swb> list = swbMapper.listimage();
		
		String realPath = request.getSession().getServletContext().getRealPath("/");

		System.out.println(realPath);

		System.out.println(list.toString());
		map.put("Information", list);
		
		return map;

	}

}
