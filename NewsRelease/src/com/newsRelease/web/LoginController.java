package com.newsRelease.web;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.servlet.ModelAndView;

import com.newsRelease.model.Manager;
import com.newsRelease.model.User;
import com.newsRelease.service.imp.AdminService;
import com.newsRelease.service.imp.NewsService;
import com.newsRelease.service.imp.UserService;

@Controller
public class LoginController {

	@Autowired
	@Qualifier("userService")
	private UserService userServ;
	
	@Autowired
	@Qualifier("adminService")
	private AdminService adminServ;
	
	@Autowired
	@Qualifier("newsService")
	private NewsService newsServ;
	/**
	 * 用户登录
	 * @param login_Info
	 * @param session
	 * @return
	 * @throws JSONException
	 */
	@RequestMapping(value="user/userLogin",method=RequestMethod.POST)
	public @ResponseBody ModelMap userLogin(@RequestBody String login_Info , ModelMap mm, HttpSession session) throws JSONException {
		System.out.println(login_Info);
		JSONObject json = new JSONObject(login_Info);
//		ModelMap mm = new ModelMap();
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
			mm.addAttribute("userId", user.getUserId());
			mm.addAttribute("userName", user.getName());
			System.out.println("登录成功");
		}
		System.out.println(mm);	
		return mm;
	}
	/**
	 * 管理员登录 非ajax登录
	 * @param login_info
	 * @param session
	 * @return
	 */
	@RequestMapping(value="admin/adminLogin")
	public ModelAndView adminLogin( HttpServletRequest login_info, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Manager m = adminServ.findByUserName(login_info.getParameter("username"));
		if(m == null) {
			System.out.println("用户名不存在");
			mav.setViewName("redirect:/admin");
		}else if(!m.getPwd().equals(login_info.getParameter("pwd"))) {
			System.out.println("密码不正确");
			mav.setViewName("redirect:/admin");
		}else {
			mav.setViewName("admin/admin_manager");
			session.setAttribute("loginManager", m);
			mav.addAllObjects(newsServ.getAllNewsByType());
			mav.addObject("userNum", adminServ.userCount());
			mav.addObject("newsAllNum", newsServ.getNewsNum());
			
		}
		return mav;
	}
	
	@RequestMapping(value="/userLogout",method=RequestMethod.GET)
	public @ResponseBody String userLogout(HttpSession session) {
		System.out.println("退出之前：" + session.getAttribute("loginUser"));
		session.removeAttribute("loginUser");
		System.out.println("退出之后：" + session.getAttribute("loginUser"));
		return "success";
	}
}
