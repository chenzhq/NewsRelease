<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>管理员登录</title>
<meta name="description" content="">
<meta name="keywords" content="">
<script type="text/javascript" charset="UTF-8" src="resources/js/prefixfree.min.js"></script>
<link href="resources/css/admin_reg.css" rel="stylesheet">
</head>
<body>

	   <div class="content">
           <form action="admin/adminLogin" method="post" class="login-form">
               <div class="username">
                   <input type="text" name="username" placeholder="请输入用户名" autocomplete="on" />
                   <span class="user-icon icon">u</span>
               </div>
               <div class="password">
                   <input type="password" name="pwd" placeholder="*******" />
                   <span class="password-icon icon">p</span>
               </div>
               <div class="account-control">
                   <button type="submit">登录</button>
               </div>
           </form>
	   </div>

</body>
</html>