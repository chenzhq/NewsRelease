package com.newsRelease.web;

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
	
	@RequestMapping(value="/index")
	public ModelAndView showIndex(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		mav.addObject("new01",newsServ.getNewsByStyle("international"));
		return mav;
	}
	
	@RequestMapping(value="/admin")
	public String adminIndex() {
		return "admin/admin_reg";
	}
}
