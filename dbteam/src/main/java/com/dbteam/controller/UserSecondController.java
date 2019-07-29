package com.dbteam.controller;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Log4jConfigurer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dbteam.beans.UserSecond;
import com.dbteam.mapper.UserSecondMapper;

/*
 * 
 * 	管理员用户
 * 
 */


@Controller
@RequestMapping("/user")
public class UserSecondController {

	@Autowired
	UserSecondMapper userSecondMapper;

	public static String avatarUrl1 = null;
	
	private  Logger logger=Logger.getLogger(UserSecondController.class);
	
	
	/*
	 * 
	 * 	添加管理员用户
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public Map<String, Object> addUser(@RequestBody UserSecond adminInfo) {

		Map<String, Object> map = new HashMap<String, Object>();

		if (adminInfo != null) {

			String userName = adminInfo.userName;
			int id=adminInfo.id;
			
			if (userSecondMapper.selectUserName(userName)==null) {
				
				userSecondMapper.addUser(adminInfo);
				logger.info(userName+"    管理员用户添加成功");
			} else {

				logger.info("添加管理员用户名重复");
			}

		} else {
			
			logger.info("添加用户信息为空————失败");
		}

		

		return map;
	}
	
	
	/*
	 * 
	 * 	初始登录 用户等级 更新用户头像连接
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/getUserGrade")
	public Map<String, Object> getUser(@RequestBody UserSecond userSecond) throws FileNotFoundException {

		Map<String, Object> map = new HashMap<String, Object>();

		if (userSecond != null) {
			String userWeChatName = userSecond.nickName;
			int id=userSecond.id;
			String avatarUrl = userSecond.avatarUrl;
			
			System.out.println(userWeChatName);
			UserSecond usersecond2=new	UserSecond();
			usersecond2.setAvatarUrl(avatarUrl);
			usersecond2.setUserName(userWeChatName);
			usersecond2.setUserWeChatName(userWeChatName);
			
			
			userSecond.setAvatarUrl(avatarUrl);
			userSecond.setUserName(userWeChatName);
			userSecond.setId(id);
			
			if (userSecondMapper.selectAll(userWeChatName)!=null) {
				System.out.println("有这个用户");
				
				UserSecond	usersecond=userSecondMapper.selectAll(userWeChatName);
				System.out.println(usersecond.id);
				map.put("userGrade", usersecond.userGrade);
				if (userSecondMapper.updateSecondUser(usersecond2)) {
					System.out.println("替换成功");
				} else {
					System.out.println("替换失败");
				}
				
				//UserSecond userSecond1 = userSecondMapper.selectAll(userWeChatName);

				
			} else {
				
				System.out.println("查找用户 :" + userWeChatName + "  不存在");
				return map;
			}
		} else {
			map.put("adminList", "NULL  false");
		}

		return map;
	}
	
	/*
	 * 
	 *	得到全部管理员信息列表 
	 * 
	 */
	
	@ResponseBody
	@RequestMapping(value = "getAllUser")
	public Map<String,Object> getAllUser1() throws FileNotFoundException {

		Map<String, Object> map = new HashMap<String, Object>();
		
		List<UserSecond> allSecondUser = userSecondMapper.allSecondUser();
		
		
		
		map.put("list", allSecondUser);
		
		
		return map;
	}

	/*
	 * 
	 * 		删除管理员用户
	 * 
	 */
	@ResponseBody
	@RequestMapping("deleteUser")
	public Map<String, Object> deleteUser(@RequestBody UserSecond userSecond) {

		Map<String, Object> map = new HashMap<>();
		
		int id=userSecond.id;
		if (userSecondMapper.selectName(id)) {

			Boolean xx = userSecondMapper.deleteSecondUser(id);

			if (xx) {
				
				logger.info("管理员用户删除成功");

			} else {
				
				logger.info("管理员用户删除失败");
				
			}

		} else {
			
			logger.info("管理员用户删除失败2");
			
		}

		return map;

	}

	
	/*
	 * 	updateSecondUser
	 * 	修改管理员用户信息
	 * 
	 * 
	 */
		
	@ResponseBody
	@RequestMapping(value = "upDateUser", method = RequestMethod.POST)
	public Map<String, Object> updateSecondUser(@RequestBody UserSecond userSecond) {

		Map<String, Object> map = new HashMap<>();

		if (userSecond != null) {
			int id =userSecond.id;
			userSecondMapper.deleteSecondUser(id);
			System.out.println(userSecond.userName);
			System.out.println(userSecond.getUserName());
			Boolean xx = userSecondMapper.addUser(userSecond);
			if (xx) {
				
				logger.info("修改管理员用户 :"  +userSecond.userName+"  成功");
			} else {
				
				logger.warn("修改管理员用户 :"  +userSecond.userName+"  失败");
			}

		} else {
			
			logger.warn("修改管理员用户 :"  +userSecond.userName+"  失败 ————值为空");
		}

		return map;
	}
	
	
	
	/*
	 * 
	 * 		按管理员名字查找用户
	 * 
	 */
	
	@ResponseBody
	@RequestMapping(value = "/getUser")
	public Map<String, Object> getUser(@RequestParam(value = "userName", required = false) String userName) {
		Map<String, Object> map = new HashMap<>();
		
		
		if (userName != null) {
			UserSecond list = userSecondMapper.selectUserName(userName);
			map.put("list", list);
			
		} else {
			logger.warn("按名字查找用户失败 ————传入值为Null");
		}



		return map;
	}
	
	
	
	/*
	 * 
	 * 		updateSecondUser
	 * 		修改管理员用户信息
	 * 
	 */
	@ResponseBody
	@RequestMapping("updateUser1")
	public Map<String, Object> updateUser(@RequestBody UserSecond userSecond) {
		Map<String, Object> map = new HashMap<>();
		
		
		
		userSecond.setId(userSecond.id);
		int id=userSecond.id;
		if (userSecondMapper.updateUserInformation(id)) {
			
			logger.info("修改管理员用户成功");
		} else {
			
			logger.warn("修改管理员用户失败");

		}

		return map;
	}

}
