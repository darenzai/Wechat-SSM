package com.dbteam.controller;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dbteam.beans.User;
import com.dbteam.mapper.UserMapper;

@Controller
@RequestMapping("/user1")
public class UserController {
	@Autowired
	UserMapper userMapper;

	@ResponseBody
	@RequestMapping(value = "getUser")
	public Map<String, Object> getUser(@RequestBody User user) {

		
		Map<String, Object> map = new HashMap<String, Object>();

		


		return map;
	}


	@ResponseBody
	@RequestMapping("saveUser")
	public Map<String, Object> saveUser(String userName) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (userName != null) {

			userMapper.saveUser(userName);

			System.out.println("保存用户 : " + userName);
		} else {
			System.out.println("保存用户失败");
		}

		return map;

	}

}
