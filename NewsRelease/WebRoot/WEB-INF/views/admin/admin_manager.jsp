<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>管理界面</title>
<meta name="description" content="">
<meta name="keywords" content="">
<link href="../resources/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../resources/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="../resources/css/style-admin.css">
<!-- <script src="../resources/js/prefixfree.min.js"></script> -->
<script src="../resources/js/jquery.min.js"></script>
<script src="../resources/js/sco.tab.js"></script>
<!-- 编辑框js文件 -->
<script charset="utf-8" src="../resources/editor/kindeditor.js"></script>
<script charset="utf-8" src="../resources/editor/lang/zh_CN.js"></script>

</head>
<body style="height:700px">
    <section class="container">
    	<div class="row">
    		<div class="col-lg-3">
    			<div class="admin_container">
    				
    			</div>
    			<hr>
    			<ul id="main_nav" class="nav">
    				<li>
    					<a href=""><i class="icon-home"></i>主页</a>
    				</li>
    				<li>
    					<a href=""><i class="icon-th-list"></i>管理新闻</a>
    				</li>
    				<li>
    					<a href=""><i class="icon-file"></i>发表新闻</a>
    				</li>
    			</ul>
    		</div>
    		<div id="manager_container" class="col-lg-9">
                <h1 class="page-title">
                    <i class="icon-home"></i>主页
                </h1>
                <div class="stat_container" style="display:block">
                    <div class="stat_hoder">
                        <div class="stat"><span>${userNum }</span>注册用户数</div>
                    </div>
                    <div class="stat_hoder">
                        <div class="stat"><span>${newsAllNum[0]}</span>国际新闻</div>
                    </div>
                    <div class="stat_hoder">
                        <div class="stat"><span>${newsAllNum[1]}</span>体育新闻</div>
                    </div>
                    <div class="stat_hoder">
                        <div class="stat"><span>${newsAllNum[2]}</span>娱乐新闻</div>
                    </div>
                    <div class="stat_hoder">
                        <div class="stat"><span>${newsAllNum[3]}</span>社会新闻</div>
                    </div>
                    <div class="stat_hoder">
                        <div class="stat"><span>${newsAllNum[4]}</span>时政新闻</div>
                    </div>
                </div>
                <div class="news_container" style="display:none">
                    <ul class="nav nav-tabs" data-trigger="tab" id="news_tabs">
                        <li><a href="#">国际</a></li>
                        <li><a href="#">体育</a></li>
                        <li><a href="#">娱乐</a></li>
                        <li><a href="#">社会</a></li>
                        <li><a href="#">时政</a></li>
                    </ul>
                    <div class="pane-wrapper">
                        <div>
                            <h2>国际新闻</h2>
                            <div class="manager_tab">
                                <table class="table table-striped table-hover">
                                    <thead>
                                        <tr>
                                            <td>新闻ID</td>
                                            <td>标题</td>
                                            <td>作者</td>
                                            <td>发表时间</td>
                                            <td>操作</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${international}" var="n">
                                        <tr>
                                            <td>${n.newsId }</td>
                                            <td>${n.newsTitle }</td>
                                            <td>${n.manager.name }</td>
                                            <td>${n.newsPubTime }</td>
                                            <td>删除</td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div>
                            <h2>体育新闻</h2>
                                <div class="manager_tab">
                                    <table class="table table-striped table-hover">
                                        <thead>
                                            <tr>
                                                <td>新闻ID</td>
                                                <td>标题</td>
                                                <td>作者</td>
                                                <td>发表时间</td>
                                                <td>操作</td>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${sports}" var="n">
		                                        <tr>
		                                            <td>${n.newsId }</td>
		                                            <td>${n.newsTitle }</td>
		                                            <td>${n.manager.name }</td>
		                                            <td>${n.newsPubTime }</td>
		                                            <td>删除</td>
		                                        </tr>
		                                       </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                        </div>
                        <div>
                            <h2>娱乐新闻</h2>
                            <div class="manager_tab">
                                <table class="table table-striped table-hover">
                                    <thead>
                                        <tr>
                                            <td>新闻ID</td>
                                            <td>标题</td>
                                            <td>作者</td>
                                            <td>发表时间</td>
                                            <td>操作</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${entertainment}" var="n">
	                                        <tr>
	                                            <td>${n.newsId }</td>
	                                            <td>${n.newsTitle }</td>
	                                            <td>${n.manager.name }</td>
	                                            <td>${n.newsPubTime }</td>
	                                            <td>删除</td>
	                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div>
                            <h2>社会新闻</h2>
                            <div class="manager_tab">
                                <table class="table table-striped table-hover">
                                    <thead>
                                        <tr>
                                            <td>新闻ID</td>
                                            <td>标题</td>
                                            <td>作者</td>
                                            <td>发表时间</td>
                                            <td>操作</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${society}" var="n">
	                                        <tr>
	                                            <td>${n.newsId }</td>
	                                            <td>${n.newsTitle }</td>
	                                            <td>${n.manager.name }</td>
	                                            <td>${n.newsPubTime }</td>
	                                            <td>删除</td>
	                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div>
                            <h2>时政新闻</h2>
                            <div class="manager_tab">
                                <table class="table table-striped table-hover">
                                    <thead>
                                        <tr>
                                            <td>新闻ID</td>
                                            <td>标题</td>
                                            <td>作者</td>
                                            <td>发表时间</td>
                                            <td>操作</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${politics}" var="n">
	                                        <tr>
	                                            <td>${n.newsId }</td>
	                                            <td>${n.newsTitle }</td>
	                                            <td>${n.manager.name }</td>
	                                            <td>${n.newsPubTime }</td>
	                                            <td>删除</td>
	                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <script>var tab = $.scojs_tab('#news_tabs');</script>
                <div class="publish_container" style="display:none">
                    <form class="form-horizontal" method="post" action="pubNews" enctype="multipart/form-data">
                        <div class="form-group">
                            <label for="news_title">新闻标题</label>
                            <input type="text" class="form-control" name="newsTitle" id="news_title" />
                        </div>
                        <div class="form-group">
                            <label for="news_style">类型</label>
                            <select id="news_style" name="newsStyle" class="form-control">
                              <option value="international">国际</option>
                              <option value="sports">体育</option>
                              <option value="entertainment">娱乐</option>
                              <option value="society">社会</option>
                              <option value="politics">时政</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>内容</label>
                            <textarea id="editor_id" name="newsContent" style="width:700px;height:300px;"></textarea>
                        </div>
                        <div class="form-group">
                            <label for="InputFile">上传照片</label>
                            <input type="file" name="photo" id="InputFile" multiple="multiple">
                        </div>
                        <div class="form-group">
                        	<button type="submit" class="btn btn-default">发表</button>
                        </div>
                        
                    </form>
                </div>
            </div>
    	</div>
    </section>
    <script>
			var editor;
			KindEditor.ready(function(K) {
				editor = K.create('textarea[name="newsContent"]', {
					resizeType : 1,
					allowPreviewEmoticons : false,
					allowImageUpload : false,
					items : [
						'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
						'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
						'insertunorderedlist', '|', 'emoticons', 'image', 'link']
				});
			});
</script>
    <script>
    $(function() {
        $('#main_nav a').on('click', function(event) {
            event.preventDefault();
            // console.log($(this).parent('li').index());
            // console.log($('#manager_container').children('div').eq($(this).parent('li').index()));
            if($(this).parent('li').index() == 0){
                $('.page-title').html('<i class="icon-home"></i>主页');
            }else if($(this).parent('li').index() == 1){
                $('.page-title').html('<i class="icon-th-list"></i>管理新闻');
            }else {
                $('.page-title').html('<i class="icon-file"></i>发表新闻');
            }
            $('#manager_container').children('div').css('display', 'none');
            $('#manager_container').children('div').eq($(this).parent('li').index()).css('display', 'block');
        });
    });
    </script>
</body>
</html>