<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">

<title>LBlog 后台</title>
<meta name="keywords" content="LBlog">
<meta name="description"
	content="Blog">
<link href="static/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
<link href="static/font-awesome/css/font-awesome.css?v=4.3.0" rel="stylesheet">
<!-- Morris -->
<link href="static/css/morris/morris-0.4.3.min.css" rel="stylesheet">
<!-- Gritter -->
<link href="static/js/plugins/gritter/jquery.gritter.css" rel="stylesheet">
<link href="static/css/animate.css" rel="stylesheet">
<link href="static/css/style.css?v=2.2.0" rel="stylesheet">
<link href="static/layer/skin/layer.css" rel="stylesheet" >
</head>

<body>
	<div id="wrapper">
		<nav class="navbar-default navbar-static-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="side-menu">
					<li class="nav-header">

						<div class="dropdown profile-element">
							<span> <img alt="image" class="img-circle"
								src="static/images/profile_small.jpg" />
							</span> <a data-toggle="dropdown" class="dropdown-toggle"
								href="#"> <span class="clear"> <span
									class="block m-t-xs"> <strong class="font-bold">${user}</strong>
								</span> <span class="text-muted text-xs block">超级管理员 <b
										class="caret"></b></span>
							</span>
							</a>
							<ul class="dropdown-menu animated fadeInRight m-t-xs">
								<li><a href="#">修改头像</a></li>
								<li><a href="#">个人资料</a></li>
								<li><a href="#">联系我们</a></li>
								<li><a href="#">信箱</a></li>
								<li class="divider"></li>
								<li><a href="loginAdmin?what=exit">安全退出</a></li>
							</ul>
						</div>
						<div class="logo-element">JL</div>

					</li>
					<li class="active"><a href="javascript:changeIf('admin?what=article')"><i
							class="fa fa-th-large"></i> <span class="nav-label">文章列表</span> <span
							class="fa arrow"></span></a>
						</li>
					<li><a href="javascript:changeIf('admin?what=add')" ><i class="fa fa-columns"></i> <span
							class="nav-label">写文章</span></a></li>
					<li><a href="javascript:changeIf('admin?what=person')"><i class="fa fa fa-globe"></i> <span
							class="nav-label">资料管理</span><span class="fa arrow"></span></a>
						</li>
					<li><a href="javascript:changeIf('admin/articletype?what=type')"><i class="fa fa-bar-chart-o"></i>
							<span class="nav-label">分类管理</span><span class="fa arrow"></span></a>
						</li>
					<li><a href="#"><i class="fa fa-envelope"></i>
							<span class="nav-label onfound">信箱 </span></a>
						</li>
					<li><a href="#"><i class="fa fa-flask"></i> <span
							class="nav-label onfound">小工具</span></a></li>
					<li><a href="#"><i class="fa fa-edit"></i> <span
							class="nav-label onfound">表单</span><span class="fa arrow"></span></a>
						</li>
					<li><a href="#"><i class="fa fa-desktop"></i> <span
							class="nav-label onfound">页面</span></a>
						</li>
					<li><a href="#"><i class="fa fa-files-o"></i> <span
							class="nav-label onfound">其他页面</span><span class="fa arrow"></span></a>
						</li>

					<li><a href="#"><i class="fa fa-flask"></i> <span
							class="nav-label onfound">UI元素</span><span class="fa arrow"></span></a>
						</li>
					<li><a href="#"><i class="fa fa-laptop"></i>
							<span class="nav-label onfound">栅格</span></a></li>
					<li><a href="#"><i class="fa fa-table"></i> <span
							class="nav-label onfound">表格</span><span class="fa arrow"></span></a>
						</li>
					<li><a href="#"><i class="fa fa-picture-o"></i>
							<span class="nav-label onfound">图库</span><span class="fa arrow"></span></a>
						</li>
					<li><a href="#"><i class="fa fa-sitemap"></i> <span
							class="nav-label onfound">菜单 </span><span class="fa arrow"></span></a>
						</li>
					<li><a href="#"><i class="fa fa-comments"></i> <span
							class="nav-label onfound">即时通讯</span><span
							class="label label-danger pull-right">New</span></a></li>
					<li><a href="#"><i class="fa fa-magic"></i>
							<span class="nav-label onfound">CSS动画</span></a></li>
				
				</ul>

			</div>
		</nav>

		<div id="page-wrapper" class="gray-bg dashbard-1">
			<div class="row border-bottom">
				<nav class="navbar navbar-static-top" role="navigation"
					style="margin-bottom: 0">
					<div class="navbar-header">
						<a class="navbar-minimalize minimalize-styl-2 btn btn-primary "
							href="#"><i class="fa fa-bars"></i> </a>
						<form role="search" class="navbar-form-custom" method="post"
							action="#">
							<div class="form-group">
								<input type="text" placeholder="请输入您需要查找的内容 …"
									class="form-control" name="top-search" id="top-search">
							</div>
						</form>
					</div>
					<ul class="nav navbar-top-links navbar-right">
						<li><span class="m-r-sm text-muted welcome-message"><a
								href="#" title="返回首页"><i class="fa fa-home"></i></a>欢迎使用您吴培基</span>
						</li>
						<li class="dropdown"><a class="dropdown-toggle count-info"
							data-toggle="dropdown" href="#"> <i
								class="fa fa-envelope"></i> <span class="label label-warning">16</span>
						</a>
							<ul class="dropdown-menu dropdown-messages">
								<li>
									
								</li>
								<li class="divider"></li>
								<li>
									
								</li>
								<li class="divider"></li>
								<li>
									
								</li>
							</ul></li>
						<li class="dropdown">
						<a class="dropdown-toggle count-info"
							data-toggle="dropdown" href="#"> <i
								class="fa fa-bell"></i> <span class="label label-primary">8</span>
						</a>
							<ul class="dropdown-menu dropdown-alerts">
								<li><a href="#">
										
								</a></li>
								<li class="divider"></li>
								<li></li>
								<li class="divider"></li>
								<li>
									<div class="text-center link-block">
										
									</div>
								</li>
							</ul></li>
						<li><a href="#"> <i class="fa fa-sign-out"></i>
								退出
						</a></li>
					</ul>

				</nav>
			</div>
			<div class="row  border-bottom white-bg dashboard-header">
				我的博客
			</div>

			<iframe id="myIframe" class="col-lg-12" src="admin?what=article"
			style="height:1000px">
			</iframe>	
                

                </div>
		

		</div>



	<!-- Mainly scripts -->
	<script src="static/js/jquery-1.9.1.min.js"></script>
	<script src="static/js/bootstrap.min.js?v=3.4.0"></script>
	<script src="static/js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script src="static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<!-- layout -->
<script src="static/layer/layer.js"></script>
	<!-- Custom and plugin javascript -->
	<script src="static/js/hplus.js?v=2.2.0"></script>
	<script src="static/js/plugins/pace/pace.min.js"></script>

<script type="text/javascript">
$(".onfound").click(function() {
	layer.msg('程序猿正在开发中>_<!!！',  {icon: 5},function(){
		//关闭后的操作
		});
});
function changeIf(data) {
	document.getElementById("myIframe").src=data}
</script>
</body>

</html>