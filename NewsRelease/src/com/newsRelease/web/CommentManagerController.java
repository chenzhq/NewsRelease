package com.newsRelease.web;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.newsRelease.model.Comment;
import com.newsRelease.model.User;
import com.newsRelease.service.imp.NewsService;
import com.newsRelease.service.imp.UserService;

@Controller
public class CommentManagerController {
	
	@Autowired
	@Qualifier("userService")
	private UserService userServ;
	
	@Autowired
	@Qualifier("newsService")
	private NewsService newsServ;
	
	@RequestMapping("/sub_comment")
	public @ResponseBody ModelMap subComment( HttpServletRequest content, HttpSession session) throws JSONException {
		ModelMap mm = new ModelMap();
		if(session.getAttribute("loginUser") == null) {
			mm.addAttribute("msg", "noLoginUser");
			return mm;
		}
		if(content.getParameter("cont") == null) {
			mm.addAttribute("msg","noContent");
			return mm;
		}
		User u = (User)session.getAttribute("loginUser");
		Comment c = new Comment();
//		c.setId(new CommentId(u.getUserId(), (String)content.getParameter("newsId")));
		c.setCommentContent((String)content.getParameter("cont"));
		c.setNews(newsServ.findNewsById((String)content.getParameter("newsId")));
		c.setUser(u);
		c.setCommentPubTime(new Timestamp(System.currentTimeMillis()));
		userServ.saveComment(c);
		mm.addAttribute("msg", "success");
		return mm;
	}
}
