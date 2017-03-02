package com.spring.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.service.I_UserService;
import com.spring.vo.UserModel;

@Controller
@RequestMapping("user.do")
//@RequestAttributes({"resultList"})//û������˵��
@SessionAttributes({"resultList"})

public class UserController {
	//I_UserService userService;����һ��������С���������name�Ա�spring���ӳ�����ʵ����
	@Resource(name="userService")
	I_UserService us;
	
	
	@RequestMapping(params="method=add")
	public String add(String user_name, String user_psw){
		UserModel userModel = new UserModel();
		userModel.setUserName(user_name);
		userModel.setUserPsw(user_psw);
		us.insert(userModel);
//		userService.add(user_name,user_psw);
		return "login";
	}
	
	@RequestMapping(params="method=login")
	public String login(String user_name, String user_psw, ModelMap map){
		List list = us.login(user_name,user_psw);
		if (list != null && list.size() > 0) {
			List resultList = us.getAllUsers();
			map.put("resultList", resultList);
			return "jsps/main";
		}
		return "login";
	}
	@RequestMapping(params="method=delete")
	public String login(String id){
		us.delete(id);
		return "login";
	}
	@RequestMapping(params="method=update")
	public String update(String id,String user_name,String user_psw){
		UserModel userModel = new UserModel();
		userModel.setCid(Integer.parseInt(id));
//		userModel.setUserName(user_name);
		userModel.setUserPsw(user_psw);
		us.update(userModel);
//		userService.update(id,user_psw);
		return "login";
	}
}
