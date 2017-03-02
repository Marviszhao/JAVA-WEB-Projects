package com.spring.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.vo.UserModel;

@Controller
@RequestMapping("jsps/ajax.do")

public class AjaxController {
	@RequestMapping(params="method=test1",method=RequestMethod.GET)
	public @ResponseBody List<UserModel> test1(){
		List<UserModel> list = new ArrayList<UserModel>();
		UserModel user1 = new UserModel();
		UserModel user2 = new UserModel();
		user1.setUserName("Tom");
		user2.setUserName("Cat");
		list.add(user1);
		list.add(user2);
		return list;
	}
	
	@RequestMapping(params="method=test2",method=RequestMethod.GET)
	public @ResponseBody List<UserModel> test2() {
		List<UserModel> list = new ArrayList<UserModel>();
		UserModel userModel1 = new UserModel();
		userModel1.setUserName("hello");
		list.add(userModel1);
		
		UserModel uesrModel2 = new UserModel();
		uesrModel2.setUserName("world!");
		list.add(uesrModel2);
		
		return list;
	}
}
