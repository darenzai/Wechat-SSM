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
 * 	����Ա�û�
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
	 * 	��ӹ���Ա�û�
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
				logger.info(userName+"    ����Ա�û���ӳɹ�");
			} else {

				logger.info("��ӹ���Ա�û����ظ�");
			}

		} else {
			
			logger.info("����û���ϢΪ�ա�������ʧ��");
		}

		

		return map;
	}
	
	
	/*
	 * 
	 * 	��ʼ��¼ �û��ȼ� �����û�ͷ������
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
				System.out.println("������û�");
				
				UserSecond	usersecond=userSecondMapper.selectAll(userWeChatName);
				System.out.println(usersecond.id);
				map.put("userGrade", usersecond.userGrade);
				if (userSecondMapper.updateSecondUser(usersecond2)) {
					System.out.println("�滻�ɹ�");
				} else {
					System.out.println("�滻ʧ��");
				}
				
				//UserSecond userSecond1 = userSecondMapper.selectAll(userWeChatName);

				
			} else {
				
				System.out.println("�����û� :" + userWeChatName + "  ������");
				return map;
			}
		} else {
			map.put("adminList", "NULL  false");
		}

		return map;
	}
	
	/*
	 * 
	 *	�õ�ȫ������Ա��Ϣ�б� 
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
	 * 		ɾ������Ա�û�
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
				
				logger.info("����Ա�û�ɾ���ɹ�");

			} else {
				
				logger.info("����Ա�û�ɾ��ʧ��");
				
			}

		} else {
			
			logger.info("����Ա�û�ɾ��ʧ��2");
			
		}

		return map;

	}

	
	/*
	 * 	updateSecondUser
	 * 	�޸Ĺ���Ա�û���Ϣ
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
				
				logger.info("�޸Ĺ���Ա�û� :"  +userSecond.userName+"  �ɹ�");
			} else {
				
				logger.warn("�޸Ĺ���Ա�û� :"  +userSecond.userName+"  ʧ��");
			}

		} else {
			
			logger.warn("�޸Ĺ���Ա�û� :"  +userSecond.userName+"  ʧ�� ��������ֵΪ��");
		}

		return map;
	}
	
	
	
	/*
	 * 
	 * 		������Ա���ֲ����û�
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
			logger.warn("�����ֲ����û�ʧ�� ������������ֵΪNull");
		}



		return map;
	}
	
	
	
	/*
	 * 
	 * 		updateSecondUser
	 * 		�޸Ĺ���Ա�û���Ϣ
	 * 
	 */
	@ResponseBody
	@RequestMapping("updateUser1")
	public Map<String, Object> updateUser(@RequestBody UserSecond userSecond) {
		Map<String, Object> map = new HashMap<>();
		
		
		
		userSecond.setId(userSecond.id);
		int id=userSecond.id;
		if (userSecondMapper.updateUserInformation(id)) {
			
			logger.info("�޸Ĺ���Ա�û��ɹ�");
		} else {
			
			logger.warn("�޸Ĺ���Ա�û�ʧ��");

		}

		return map;
	}

}
