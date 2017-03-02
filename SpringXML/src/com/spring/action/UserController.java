package com.spring.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.service.I_UserService;
import com.spring.vo.UserModel;

//@Controller
//@RequestMapping("user.do")
//@RequestAttributes({"resultList"})//没有这种说话
@SessionAttributes({"resultList"})

public class UserController {
	//I_UserService userService;名称一致则不用再小括号中添加name以便spring框架映射查找实现类
//	@Resource(name="userService")
	I_UserService userService;
	
	


	public I_UserService getUserService() {
		return userService;
	}

	public void setUserService(I_UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(params="method=add")
	public String add(String user_name, String user_psw){
		UserModel userModel = new UserModel();
		userModel.setUserName(user_name);
		userModel.setUserPsw(user_psw);
		userService.insert(userModel);
//		userService.add(user_name,user_psw);
		return "login";
	}
	
	@RequestMapping(params="method=login")
	public String login(String user_name, String user_psw, ModelMap map){
		List list = userService.login(user_name,user_psw);
		if (list != null && list.size() > 0) {
			List resultList = userService.getAllUsers();
			map.put("resultList", resultList);
			return "jsps/main";
		}
		return "login";
	}
	@RequestMapping(params="method=delete")
	public String login(String id,ModelMap map){
		userService.delete(id);
		List resultList = userService.getAllUsers();
		map.put("resultList", resultList);
		return "jsps/main";
	}
	@RequestMapping(params="method=update")
	public String update(String id,String user_name,String user_psw){
		UserModel userModel = new UserModel();
		userModel.setCid(Integer.parseInt(id));
//		userModel.setUserName(user_name);
		userModel.setUserPsw(user_psw);
		userService.update(userModel);
//		userService.update(id,user_psw);
		return "login";
	}
}
