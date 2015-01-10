package com.newsRelease.web;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.newsRelease.service.imp.NewsService;

@Controller
public class HomeController {

	@Autowired
	@Qualifier("newsService")
	private NewsService newsServ;
	
	/**
	 * 进入主页
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/index")
	public ModelAndView showIndex(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		mav.addAllObjects(newsServ.getAllNewsByType());
		return mav;
	}
	
	/**
	 * 进入管理员登录界面
	 * @return
	 */
	@RequestMapping(value="/admin")
	public String adminIndex(HttpSession session) {
		return "admin/admin_reg";
	}
	
	/**
	 * 进入新闻单页面
	 * @return
	 */
	@RequestMapping(value="/toDetailpage")
	public ModelAndView toDetailpage(ModelAndView mav, HttpServletRequest request) {
		System.out.println(request.getParameter("newsId"));
		mav.addObject("theNews", newsServ.findNewsById((String)request.getParameter("newsId")));
		mav.setViewName("single_page");
		return mav;
	}
}
