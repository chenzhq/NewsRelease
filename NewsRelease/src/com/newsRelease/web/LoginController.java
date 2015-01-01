package com.newsRelease.web;

import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newsRelease.model.User;
import com.newsRelease.service.imp.UserService;

@Controller
public class LoginController {

	@Autowired
	@Qualifier("userService")
	private UserService userServ;
	
	@RequestMapping(value="/userLogin",method=RequestMethod.POST)
	public @ResponseBody ModelMap userLogin(@RequestBody String login_Info,HttpSession session) throws JSONException {
		System.out.println(login_Info);
		JSONObject json = new JSONObject(login_Info);
		ModelMap mm = new ModelMap();
		User user = userServ.findByUserName(json.getString("username"));
		if(user == null) {
			mm.addAttribute("msg", "userNotExist");
			System.out.println("不存在用户名");					
		}else if(!user.getPwd().equals(json.getString("pwd"))) {
			mm.addAttribute("msg", "NotMatch");
			System.out.println("密码不正确");
		}else {
			session.setAttribute("loginUser", user);
			mm.addAttribute("msg", "success");
			mm.addAttribute("loginUser", user);
			System.out.println("登录成功");
		}
		System.out.println(mm);	
		return mm;
	}
}
