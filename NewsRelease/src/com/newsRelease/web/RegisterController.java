package com.newsRelease.web;

import java.sql.Timestamp;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newsRelease.model.User;
import com.newsRelease.service.imp.UserService;


@Controller
public class RegisterController {
	
	@Autowired
	@Qualifier("userService")
	private UserService userServ;

	/**
	 * 用户ajax注册
	 * @param reg_info
	 * @param session
	 * @return
	 * @throws JSONException
	 */
	@RequestMapping(value="user/userRegister",method = RequestMethod.POST)
	public @ResponseBody Object doUserRegister(@RequestBody String reg_info, HttpSession session) throws  JSONException  {		
		User user = new User();
		JSONObject json = new JSONObject(reg_info);
		user.setName(json.getString("username"));
		user.setPwd(json.getString("pwd"));
		user.setRegTime(new Timestamp(System.currentTimeMillis()));
		user.setAuthority(false);
		userServ.saveUser(user);
		session.setAttribute("loginUser", user);
		return user;
	}
	
	/**
	 * 验证用户名是否存在
	 * @param username
	 * @return
	 * @throws JSONException
	 */
	@RequestMapping(value="/checkname",method = RequestMethod.POST)
	public @ResponseBody String checkName(HttpServletRequest username) throws JSONException {
		System.out.println(username.getParameter("param"));
		JSONObject json = new JSONObject();
		return userServ.findByUserName(username.getParameter("param")) == null ?  json.put("info", "恭喜你，可以注册！").put("status", "y").toString() : json.put("info", "对不起，该用户名已被注册！").put("status", "n").toString();
	}
}
