<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>详情</title>
<link rel="stylesheet" href="static/css/bootstrap.min.css">
<script src="static/js/jquery-2.1.1.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
<link href="static/layer/skin/layer.css" rel="stylesheet" >
<script src="static/layer/layer.js"></script>
<script type="text/javascript">
$(function(){
	$.extend({
		  getUrlVars: function(){
		    var vars = [], hash;
		    var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
		    for(var i = 0; i < hashes.length; i++)
		    {
		      hash = hashes[i].split('=');
		      vars.push(hash[0]);
		      vars[hash[0]] = hash[1];
		    }
		    return vars;
		  },
		  getUrlVar: function(name){
		    return $.getUrlVars()[name];
		  }
		});

	var allVars = $.getUrlVar("result");
	if(allVars=="1"){
		layer.msg('哇，写成功了', function(){
			//关闭后的操作
			});
	}if(allVars=="0"){
		layer.msg('不开心，写失败了', {icon: 5});	}
});



</script>
</head>
<body>
<ol class="breadcrumb">
  <li><a href="<%=basePath%>admin?what=article">主页</a></li>
  <li><a href="#">文章编辑</a></li>
</ol>
<form action="admin?what=add" method="post" name="upd" accept-charset="utf-8">
<div class="form-group">
    <label for="articleTitle">文章标题</label>
    <input type="text" class="form-control" id="articleTitle" name="articleTitle"/>
</div>
<div class="form-group">
    <label for="articleUser">文章作者</label>
    <input type="text" class="form-control" id="articleUser" readonly="readonly" value="${writeUser}"/>
    <input type="hidden" id="userId" name="userId" value="${writeUserId}"/>
</div>
<div class="form-group">
    <label for="articleCon">文章内容</label>
    <textarea  rows="5" class="form-control" id="articleCon" name="articleCon" ></textarea>
</div>
<div class="form-group">
    <label for="articleType">所属分类</label>
 <select name="articleType">
 <c:forEach items="${articleType}" var="types" >
  <option  id="articleType" value='${types.tId}'>${types.tName}</option>
 </c:forEach>
 </select>
</div>
<div class="form-group">
    <label for="articlePhoto">图片</label> 
   		 <input type="file" name="photo"/>
</div>
<div>
 <label for="articleOther">其他说明</label>
 <textarea rows="5" name="articleOther" id="articleOther"></textarea>
</div>
<input type="submit" value="发表" class="btn btn-primary" />
<input type="button" value="取消"class="btn btn-info"/> 
</form>
</body>
</html>