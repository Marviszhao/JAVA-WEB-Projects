package com.rest.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rest.dao.I_UserDao;
import com.rest.vo.UserModel;
import com.sun.org.apache.regexp.internal.recompile;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource(name="userDao")
	I_UserDao userDao;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(String user_name,String pass_word) {
		Map map = new HashMap();
		map.put("userName", user_name);
		map.put("passWord", pass_word);
		userDao.addUser(map);
		return "/login";
	}
	
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public String login(String user_name,String user_psw,ModelMap map){
		Map map1 = new HashMap();
		map1.put("userName", user_name);
		map1.put("passWord", user_psw);
		UserModel userModel = userDao.getUser(map1);
		if (userModel != null && userModel.getId() > 0) {
			List<UserModel> list = userDao.getAllUser();
			map.put("list", list);
			return "/jsps/main";
		}
		return "/login";
	}
	
	@RequestMapping(value="/delete/{userID}",method=RequestMethod.GET)
	public String delete(@PathVariable String userID,ModelMap map){
		userDao.delete(userID);
		List<UserModel> list = userDao.getAllUser();
		map.put("list", list);
		return "/jsps/main";
	}
	
	@RequestMapping(value = "/update/{userId}",method= RequestMethod.POST)
	public String update(@PathVariable String userId,String user_name,String user_psw,ModelMap map){
		Map<String, String> aMap = new HashMap<String, String>();
		aMap.put("id", userId);
		aMap.put("userName", user_name);
		aMap.put("passWord", user_psw);
		
		userDao.update(aMap);
		List<UserModel> list = userDao.getAllUser();
		map.put("list", list);
		return "/jsps/main";
	}
	
	
}
