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
 *  	生卫部数据检查
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
	 * 	更新卫生检查数据
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
						logger.info("卫生检查数据修改成功");
						System.out.println("修改数据");
						only++;
					} else {
						
						logger.info("卫生检查数据修改失败1");
					}
				} else {
					
				}
			} else {
				if (swbMapper.delete(id)) {

					if (swbMapper.add(swb)) {
						logger.info("卫生检查数据修改成功");
						System.out.println("修改数据");
						only++;
					} else {
						logger.info("卫生检查数据修改失败2");
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
	 * 		获取全部卫生检查数据
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
	 * 	按宿舍号获取数据(在老表里面查询)
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
			System.out.println("返回成功");
			map.put("getHostelList",list);
		} else {
			logger.warn("按宿舍号检查卫生数据失败---传入hosteId为空");
		}

		return map;

	}
	
	
	/*
	 * 	deleteSwb
	 * 	删除宿舍检查数据
	 * 
	 */
	
	@ResponseBody
	@RequestMapping(value = "/deleteSwb", method = RequestMethod.POST)
	public Map<String, Object> deleteSwb(@RequestBody Swb swb) {

		Map<String, Object> map = new HashMap<String, Object>();

		if (swb != null) {
			int id = swb.id;
			int dorm = swb.hostelId;
			System.out.println("删除新表宿舍号ID为   :" + dorm);
			if (swbSecondMapper.getSwbSecond(dorm)) {
				System.out.println("新表存在宿舍号Id为 数据" + dorm);
				if ((swbMapper.delete(id)) && (swbSecondMapper.updateSwbSecond(dorm))) {
					logger.info("卫生检查数据删除成功");
				} else {

					logger.warn("卫生检查数据删除失败");
				}
			} else {
				if (swbMapper.delete(id)) {
					logger.info("卫生检查数据------新表数据不存在 旧表删除成功");
					
				} else {
					logger.warn("卫生检查数据------新表数据不存在 旧表删除失败");
				}
			}

		} else {
			
			logger.warn("卫生检查数据------传入值为空");
		}

		return map;
	}

	
	
	/*
	 * 
	 * 	获取新表里面的卫生检查数据
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
	 * 	添加卫生检查时候的图片
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
				System.out.println("1——原始 ："+oldName);
				System.out.println("2——随机数 ："+newName);
				String houchuo = oldName.substring(oldName.lastIndexOf("."));
				File local = new File("D:\\" + tupiantime + newName + houchuo);
				tupian = tupiantime + newName + houchuo;
				System.out.println("3——加后错文件名"+tupian);
				file.transferTo(local);			
				imageProduct imageproduct = new imageProduct();
				System.out.println("4——再然后 "+tupian);
				imageproduct.setImages(tupian);			
				imageproduct.setShijian(tupiantime);
				imagemapper.addImage(imageproduct);				
				logger.info("图片 :" + tupiantime + "保存数据库成功");
					
			} else {
				logger.info("图片 :" + tupiantime + "保存数据库失败 图片为空");
			}

		} else {
			logger.info("图片 :" + tupiantime + "保存数据库失败 图片为空2");
		}
		return map;

	}

	
	
	/*
	 * 
	 * 	添加生卫部检查数据
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
						
						
						logger.info(only+"   : only值");
						System.out.println("数据");
						logger.info("生卫部检查文本数据添加成功");
				
					}
				} else {

					logger.warn("生卫部检查文本数据设置失败");
				}

			} else {
				if (swbSecondMapper.addSwbSecond(swb)) {
					logger.info(only+"   : only值");
					System.out.println("添加数据");
					only++;
					
	
					logger.info("生卫部检查文本数据添加成功");
				
				} else {
					
					logger.warn("生卫部检查文本数据添加失败");
				}
			}

		} else {

			logger.info("生卫部检查文本数据添加失败————值为空");
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
