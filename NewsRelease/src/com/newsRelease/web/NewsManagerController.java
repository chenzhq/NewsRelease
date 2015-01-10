package com.newsRelease.web;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.newsRelease.model.Manager;
import com.newsRelease.model.News;
import com.newsRelease.model.Photo;
import com.newsRelease.service.imp.NewsService;


@Controller
public class NewsManagerController {
	
	@Autowired
	@Qualifier("newsService")
	private NewsService newsServ;
	
	
	@RequestMapping(value="admin/pubNews")
	public String pubNews(@RequestParam(value="photo" ,required=false) MultipartFile photo,
						HttpServletRequest request,
						HttpSession session,
						News news) throws IOException {
		news.setManager((Manager)session.getAttribute("loginManager"));
		news.setNewsPubTime(new Timestamp(System.currentTimeMillis()));
		newsServ.insertNews(news);
		if(!photo.isEmpty()) {
			Photo p = new Photo();
			photo.transferTo(new File("C:/Users/chenzhq/Documents/GitHub/NewsRelease/NewsRelease/WebRoot/images/news/" + photo.getOriginalFilename()));
			p.setPhoto("resources/images/news/" + photo.getOriginalFilename());
			p.setNews(news);
			newsServ.insertPho(p);
		}
		return "admin/admin_suc";
	}

	

}
