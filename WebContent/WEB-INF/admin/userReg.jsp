<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="zH_CN">

<head>

<meta charset="utf-8">
<title>注册</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- CSS -->
<link rel="stylesheet"
	href="static/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="static/assets/css/style.css">
<script src="static/js/jquery-2.1.1.min.js"></script>

<link href="static/layer/skin/layer.css" rel="stylesheet">
<script src="static/layer/layer.js"></script>
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

<script type="text/javascript">
	$(function() {
		$.extend({
			getUrlVars : function() {
				var vars = [], hash;
				var hashes = window.location.href.slice(
						window.location.href.indexOf('?') + 1).split('&');
				for (var i = 0; i < hashes.length; i++) {
					hash = hashes[i].split('=');
					vars.push(hash[0]);
					vars[hash[0]] = hash[1];
				}
				return vars;
			},
			getUrlVar : function(name) {
				return $.getUrlVars()[name];
			}
		});

		var allVars = $.getUrlVar("result");
		if (allVars == "1") {
			var time = 3;
			layer.msg('哇，成功了,稍后自动跳转', function() {
				setTimeout(function() {
					location.href = "index.jsp";
				}, 1500);
			});
		}
		if (allVars == "0") {
			layer.msg('不开心，失败了', {
				icon : 5
			});
		}
	});

	function back() {
		location.href = "index.jsp";
	}
</script>

</head>

<body>

	<div class="header">
		<div class="container">
			<div class="row">
				<div class="logo span4">
					<h1>
						<a href="">LBolg Register <span class="red">.</span></a>
					</h1>
				</div>
				<div class="links span8">
					<a class="home" href="" rel="tooltip" data-placement="bottom"
						data-original-title="Home"></a> <a class="blog" href=""
						rel="tooltip" data-placement="bottom" data-original-title="Blog"></a>
				</div>
			</div>
		</div>
	</div>

	<div class="register-container container">
		<div class="row">
			<div class="register span6"
				style="filter: alpha(Opacity = 40); -moz-opacity: 0.5; opacity: 0.5;">
				<form action="user?what=register" method="post">
					<h2>
						注册 <span class="red"><strong>LBlog</strong></span>
					</h2>
					<div class="form-group">
						<label for="username">用户名</label> <input type="text" id="username"  class="form-control"
							name="username" placeholder="输入你的名字">
					</div>
					<div class="form-group">
						<label for="email">Email</label> <input type="text" id="email"
							name="email"  class="form-control" placeholder="输入你的邮箱地址">
					</div>
					<div class="form-group">

						<label for="password">密码</label> <input type="password"
							id="password"  class="form-control" name="password" placeholder="输入密码">
					</div>
					<div class="form-group">

						<label for="surePassword">确认密码</label> <input type="password"
							id="surePassword"   class="form-control" name="surePassword" placeholder="再次输入密码">
					</div>
					<button type="submit">注册</button>
					<button onclick="back();">返回</button>
				</form>
			</div>
		</div>
	</div>
	<!-- Javascript -->
	<script src="static/assets/js/jquery-1.8.2.min.js"></script>
	<script src="static/assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="static/assets/js/jquery.backstretch.min.js"></script>
	<script src="static/assets/js/scripts.js"></script>

	<div style="display: none"></div>
</body>
</html>