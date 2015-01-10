<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>新闻发布系统</title>
<meta name="description" content="">
<meta name="keywords" content="">
<link href="resources/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="resources/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/unslider.js"></script>
<script src="resources/js/stickUp.js"></script>
<script src="resources/js/jquery.remodal.js"></script>
<script src="resources/js/Validform_v5.3.2.js"></script>
</head>
<body>
	<div class="banner remodal-bg">
	    <ul>
	        <li></li>
	        <li></li>
	        <li></li>
	        <li></li>
	    </ul>
	</div>
	<nav class="navbar_wrapper">
		<section class="container">
			<div class="navbar">
				<section class="nav_header"><a class="navbar-brand" href="#">主页</a></section>
				<div class="nav_collapse">
					<ul class="nav navbar-nav">
						<li class="menuItem"><a href="#international">国际</a></li>
						<li class="menuItem"><a href="#sports">体育</a></li>
						<li class="menuItem"><a href="#entertainment">娱乐</a></li>
						<li class="menuItem"><a href="#society">社会</a></li>
						<li class="menuItem"><a href="#politics">时政</a></li>
					</ul>
				</div>
				<section class="nav_header">
					<a class="login_register" style="display:block" href="#modal">加入我们</a>
					<span class="login_info" style="display:none">${loginUser.name}</span><i class="logout icon-remove" style="display:none"></i>
				</section>
			</div>
		</section>
		<!-- <span class="login_info" style="display:none">${loginUser.name}</span> -->
		
	</nav>
	<script type="text/javascript">
		window.onload = function() {
			if(!($('.login_info').html() == "")) {
					$('.login_register').css('display', 'none');
					$('.login_info').css('display', 'block');
					$('.logout').css('display', 'block');
				}
		};
	</script>
	<div class="content">
		<div id="international">
			<div class="row">
				<c:forEach items="${international }" var="i" begin="0" end="1">
				<div class="col-lg-6 news_item">
					<img src="<c:choose><c:when test="${i.photoses.iterator().hasNext() == false}">resources/images/news_01.jpg</c:when>
					<c:otherwise> ${i.photoses.iterator().next().photo}</c:otherwise></c:choose>" alt="">
					<div class="news_info">
						<h3><a href="toDetailpage?newsId=${i.newsId}">${i.newsTitle }</a></h3>
						<div>${i.newsContent }</div>
					</div>
				</div>
				</c:forEach>
			</div>
			<div class="row">
				<c:forEach items="${international }" var="i" begin="2" end="3">
				<div class="col-lg-6 news_item">
					<img src="<c:choose><c:when test="${i.photoses.iterator().hasNext() == false}">resources/images/news_01.jpg</c:when>
					<c:otherwise> ${i.photoses.iterator().next().photo}</c:otherwise></c:choose>" alt="">
					<div class="news_info">
						<h3><a href="toDetailpage?newsId=${i.newsId}">${i.newsTitle }</a></h3>
						<div>${i.newsContent }</div>
					</div>
				</div>
				</c:forEach>
			</div>
			<%-- c:forEach items="${international }" step="2" varStatus="s">
				<div class="row">
				<c:if test="${s.first == false}">
				<c:forEach items="${international }" var="i" step="2">
					<div class="col-lg-6 news_item">
						<img src="images/news_01.jpg" alt="">
						<div class="news_info">
							<h3><a href="">${i.newsTitle }</a></h3>
							<div>${i.newsContent }</div>
						</div>
					</div>
				</c:forEach>
				</c:if>
				</div>
				</c:forEach> --%>
			<span class="more_news">更多</span>
		</div>
		<div id="sports">
			<div class="row">
				<c:forEach items="${sports }" var="i" begin="0" end="1">
				<div class="col-lg-6 news_item">
					<img src="<c:choose><c:when test="${i.photoses.iterator().hasNext() == false}">resources/images/news_01.jpg</c:when>
					<c:otherwise> ${i.photoses.iterator().next().photo}</c:otherwise></c:choose>" alt="">
					<div class="news_info">
						<h3><a href="toDetailpage?newsId=${i.newsId}">${i.newsTitle }</a></h3>
						<div>${i.newsContent }</div>
					</div>
				</div>
				</c:forEach>
			</div>
			<div class="row">
				<c:forEach items="${sports }" var="i" begin="2" end="3">
				<div class="col-lg-6 news_item">
					<img src="<c:choose><c:when test="${i.photoses.iterator().hasNext() == false}">resources/images/news_01.jpg</c:when>
					<c:otherwise> ${i.photoses.iterator().next().photo}</c:otherwise></c:choose>" alt="">
					<div class="news_info">
						<h3><a href="toDetailpage?newsId=${i.newsId}">${i.newsTitle }</a></h3>
						<div>${i.newsContent }</div>
					</div>
				</div>
				</c:forEach>
			</div>
			<span class="more_news">更多</span>
		</div>
		<div id="entertainment">
			<div class="row">
				<c:forEach items="${entertainment }" var="i" begin="0" end="1">
				<div class="col-lg-6 news_item">
					<img src="<c:choose><c:when test="${i.photoses.iterator().hasNext() == false}">resources/images/news_01.jpg</c:when>
					<c:otherwise> ${i.photoses.iterator().next().photo}</c:otherwise></c:choose>" alt="">
					<div class="news_info">
						<h3><a href="toDetailpage?newsId=${i.newsId}">${i.newsTitle }</a></h3>
						<div>${i.newsContent }</div>
					</div>
				</div>
				</c:forEach>
			</div>
			<div class="row">
				<c:forEach items="${entertainment }" var="i" begin="2" end="3">
				<div class="col-lg-6 news_item">
					<img src="<c:choose><c:when test="${i.photoses.iterator().hasNext() == false}">resources/images/news_01.jpg</c:when>
					<c:otherwise> ${i.photoses.iterator().next().photo}</c:otherwise></c:choose>" alt="">
					<div class="news_info">
						<h3><a href="toDetailpage?newsId=${i.newsId}">${i.newsTitle }</a></h3>
						<div>${i.newsContent }</div>
					</div>
				</div>
				</c:forEach>
			</div>
			<span class="more_news">更多</span>
		</div>
		<div id="society">
			<div class="row">
				<c:forEach items="${society }" var="i" begin="0" end="1">
				<div class="col-lg-6 news_item">
					<img src="<c:choose><c:when test="${i.photoses.iterator().hasNext() == false}">resources/images/news_01.jpg</c:when>
					<c:otherwise> ${i.photoses.iterator().next().photo}</c:otherwise></c:choose>" alt="">
					<div class="news_info">
						<h3><a href="toDetailpage?newsId=${i.newsId}">${i.newsTitle }</a></h3>
						<div>${i.newsContent }</div>
					</div>
				</div>
				</c:forEach>
			</div>
			<div class="row">
				<c:forEach items="${society }" var="i" begin="2" end="3">
				<div class="col-lg-6 news_item">
					<img src="<c:choose><c:when test="${i.photoses.iterator().hasNext() == false}">resources/images/news_01.jpg</c:when>
					<c:otherwise> ${i.photoses.iterator().next().photo}</c:otherwise></c:choose>" alt="">
					<div class="news_info">
						<h3><a href="toDetailpage?newsId=${i.newsId}">${i.newsTitle }</a></h3>
						<div>${i.newsContent }</div>
					</div>
				</div>
				</c:forEach>
			</div>
			<span class="more_news">更多</span>
		</div>
		<div id="politics">
			<div class="row">
				<c:forEach items="${politics }" var="i" begin="0" end="1">
				<div class="col-lg-6 news_item">
					<img src="<c:choose><c:when test="${i.photoses.iterator().hasNext() == false}">resources/images/news_01.jpg</c:when>
					<c:otherwise> ${i.photoses.iterator().next().photo}</c:otherwise></c:choose>" alt="">
					<div class="news_info">
						<h3><a href="toDetailpage?newsId=${i.newsId}">${i.newsTitle }</a></h3>
						<div>${i.newsContent }</div>
					</div>
				</div>
				</c:forEach>
			</div>
			<div class="row">
				<c:forEach items="${politics }" var="i" begin="2" end="3">
				<div class="col-lg-6 news_item">
					<img src="<c:choose><c:when test="${i.photoses.iterator().hasNext() == false}">resources/images/news_01.jpg</c:when>
					<c:otherwise> ${i.photoses.iterator().next().photo}</c:otherwise></c:choose>" alt="">
					<div class="news_info">
						<h3><a href="toDetailpage?newsId=${i.newsId}">${i.newsTitle }</a></h3>
						<div>${i.newsContent }</div>
					</div>
				</div>
				</c:forEach>
			</div>
			<span class="more_news">更多</span>
		</div>
	</div>
	<script>
	$(function() {
		
	 	$(document).ready( function() {
		 	$('.navbar_wrapper').stickUp({
		 		topMargin: 'auto',
		 		parts: {
		 			0:'international',
			 		1:'sports',
			 		2: 'entertainment',
			 		3: 'society',
			 		4: 'politics'
			 	},
		 		itemClass: 'menuItem',
		 		itemHover: 'active'
		 	});
		 });
		$('.banner').unslider({
			dots: true,
			fluid: true
		});
		
	})
	</script>
	<footer></footer>
	<!-- 登录弹出框 -->
	<div class="remodal" data-remodal-id="modal">
		   <div id="form_wrapper" class="form_wrapper">
		   		<form id="login" class="login active">
						<h3>登录</h3>
						<div>
							<label>用户名:</label>
							<input type="text" name="username" id="login_name"/>
							<span id="username_error" class="error">输入有误哦</span>
						</div>
						<div>
							<label>密码: <!-- <a href="forgot_password.html" rel="forgot_password" class="forgot linkform">Forgot your password?</a> --></label>
							<input type="password" name="pwd" id="login_pwd"/>
							<span id="pwd_error" class="error">输入有误哦</span>
						</div>
						<div class="bottom">
							<!-- <div class="remember"><input type="checkbox" /><span>记住我</span></div> -->
							<input type="submit" class="remodal-login" value="登录"></input>
							<a href="register.html" rel="register" class="linkform">还没有账号吗？加入我们吧!</a>
							<div class="clear"></div>
						</div>
				</form>
				<form class="register" id="register">
						<h3>注册</h3>
						<div class="column">
							<div>
								<label>用户名:</label>
								<input type="text" id="username" name="username" datatype="s3-10" errormsg="用户名至少3个字符,最多10个字符！"  placeholder="请输入用户名" ajaxurl="checkname" required/>
								<img id="loading" src="./resources/images/onLoad.gif" alt="" style="display:none">
							</div>
							<div>
								<label>密码:</label>
								<input type="password" id="pwd" name="pwd" datatype="*6-16" errormsg="请输入6-16位密码长度！" required/>
								<!-- <span class=""></span> -->
							</div>
							<div>
								<label>确认密码:</label>
								<input type="password" value="" datatype="*6-16"  recheck="pwd" errormsg="您两次输入的密码不一致！"/>
								<!-- <span class=""></span> -->
							</div>
						</div>
						<!-- <div class="column">
							<div>
								<label>手机号:</label>
								<input type="text" id="telphone" datatype="m" name="telphone" errormsg="请输入正确的手机号！" required/>
							</div>
							<div>
								<label>电子邮箱:</label>
								<input type="email" id="email" datatype="e" name="email" errormsg="请输入正确的邮箱格式！" required/>
							</div>
						</div> -->
						<div class="bottom">
							<input type="submit" class="remodal-register" value="加入我们" />
							<a href="index.html" rel="login" class="linkform">您已经有账号了吗？点击这里</a>
							<div class="clear"></div>
						</div>
				</form>
			</div>
			<div class="clear"></div>
		</div>
	<!-- 注册登录弹出框jquery代码 -->
		<script type="text/javascript">
		$(function() {
				//the form wrapper (includes all forms)
			var $form_wrapper	= $('#form_wrapper'),
				//the current form is the one with class active
				$currentForm	= $form_wrapper.children('form.active'),
				//the change form links
				$linkform		= $form_wrapper.find('.linkform');
			//get width and height of each form and store them for later
			$form_wrapper.children('form').each(function(i){
				var $theForm	= $(this);
				//solve the inline display none problem when using fadeIn fadeOut
				if(!$theForm.hasClass('active'))
					$theForm.hide();
				$theForm.data({
					width	: $theForm.width(),
					height	: $theForm.height()
				});
			});
			//set width and height of wrapper (same of current form)
			setWrapperWidth();
			/*
			clicking a link (change form event) in the form
			makes the current form hide.
			The wrapper animates its width and height to the
			width and height of the new current form.
			After the animation, the new form is shown
			*/
			$linkform.bind('click',function(e){
				var $link	= $(this);
				var target	= $link.attr('rel');
				$currentForm.fadeOut(400,function(){
					//remove class active from current form
					$currentForm.removeClass('active');
					//new current form
					$currentForm= $form_wrapper.children('form.'+target);
					//animate the wrapper
					$form_wrapper.stop()
								 .animate({
									width	: $currentForm.data('width') + 'px',
									height	: $currentForm.data('height') + 'px'
								 },500,function(){
									//new form gets class active
									$currentForm.addClass('active');
									//show the new form
									$currentForm.fadeIn(400);
								 });
				});
				e.preventDefault();
			});
			
			function setWrapperWidth(){
				$form_wrapper.css({
					width	: $currentForm.data('width') + 'px',
					height	: $currentForm.data('height') + 'px'
				});
			}
			// 表单验证
			$('#register').Validform({
				tiptype:3,
				btnSubmit:".remodal-register",
				showAllError:true,
				beforeSubmit:function(curform) {
					if(curform.find(':input').hasClass('Validform_error')) {
						return false;
					}
				}
			});

			$.fn.serializeObject = function()
				{
				   var o = {};
				   var a = this.serializeArray();
				   $.each(a, function() {
				       if (o[this.name]) {
				           if (!o[this.name].push) {
				               o[this.name] = [o[this.name]];
				           }
				           o[this.name].push(this.value || '');
				       } else {
				           o[this.name] = this.value || '';
				       }
				   });
				   return o;
				};
			$('.logout').on('click', function(event) {
				event.preventDefault();
				$.ajax({
					url: 'userLogout',
					type: 'GET',
					dataType: 'text',
					contentType:'text/plain;charset=UTF-8',
					// data: {param1: 'value1'},
					success: function(data) {
						if(data == 'success') {
							$('.login_register').css('display', 'block');
							$('.login_info').css('display', 'none');
							$('.logout').css('display', 'none');
						}
					}
				});
			});
		});
        </script>
	
</body>
</html>
