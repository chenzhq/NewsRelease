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
<script src="resources/js/jquery.min.js"></script>
</head>
<body>
	<c:forEach items="${new01}" var="NewsItem">
	<span>${ NewsItem.newsContent}</span>
	</c:forEach>
	<%-- ${news[0].newsTitle} --%>
	<form id="login">
	    <label for="username">用户名:</label>
		<input type="text"  name="username"  placeholder="请输入用户名"  required/>
		<label for="pwd">密码：</label>
		<input type="password"  name="pwd" required/>
		<input type="submit" value="登录"/>
	</form>
	<script>
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
		$('#login').on('submit', function(event) {
			event.preventDefault();
			console.log(JSON.stringify($('#login').serializeObject()));
			$.ajax({
				url: 'userLogin',
				type: 'POST',
				dataType: 'json',
				contentType:'application/json;charset=UTF-8',
				data: JSON.stringify($('#login').serializeObject()),
				success: function(data) {
					console.info('success');
				},
				error: function(data) {
					console.error(data);
				}
			});
			
		});		
	</script>
</body>
</html>
