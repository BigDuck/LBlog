<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章管理</title>
<link href="static/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
<link href="static/font-awesome/css/font-awesome.css?v=4.3.0"
	rel="stylesheet">
<!-- Morris -->
<link href="static/css/morris/morris-0.4.3.min.css" rel="stylesheet">
<!-- Gritter -->
<link href="static/js/plugins/gritter/jquery.gritter.css"
	rel="stylesheet">
<link href="static/css/animate.css" rel="stylesheet">
<link href="static/css/style.css?v=2.2.0" rel="stylesheet">
<script src="static/js/jquery-2.1.1.min.js"></script>
<link href="static/layer/skin/layer.css" rel="stylesheet" >
<script src="static/layer/layer.js"></script>
</head>
<body>
 <div class="col-md-5 col-md-offset-4">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>个人资料</h5>
                            </div>
                            <div>
                                <div class="ibox-content no-padding border-left-right">
                                    <img alt="image" class="img-responsive" src="static/login/images/banner_slide_01.jpg">
                                </div>
                                <div class="ibox-content profile-content">
                                    <h4><strong>${my.uName}</strong></h4>
                                    <p><i class="fa fa-map-marker"></i>邮箱： ${my.uEmail}</p>
                                    <h5>
                                    关于我
                                </h5>
                                    <p>
                                        可怜的我姓程名序猿，你叫我序猿就可以
                                    </p>
                                    <div class="row m-t-lg">
                                        <div class="col-md-4">
                                            <span class="bar">5,3,9,6,5,9,7,3,5,2</span>
                                            <h5><strong>169</strong> 文章</h5>
                                        </div>
                                        <div class="col-md-4">
                                            <span class="line">5,3,9,6,5,9,7,3,5,2</span>
                                            <h5><strong>28</strong> 关注</h5>
                                        </div>
                                        <div class="col-md-4">
                                            <span class="bar">5,3,2,-1,-3,-2,2,3,5,2</span>
                                            <h5><strong>240</strong> 关注者</h5>
                                        </div>
                                    </div>
                                    <div class="user-button">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <button type="button" class="btn btn-primary btn-sm btn-block"><i class="fa fa-envelope"></i> 发送消息</button>
                                            </div>
                                            <div class="col-md-6">
                                                <button type="button" class="btn btn-default btn-sm btn-block"><i class="fa fa-coffee"></i> 赞助</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
               
	<!-- Data Tables -->
	<script src="static/js/jquery-1.9.1.min.js"></script>
	<script src="static/js/bootstrap.min.js?v=3.4.0"></script>

	<script src="static/js/plugins/dataTables/jquery.dataTables.js"></script>
	<script src="static/js/plugins/dataTables/dataTables.bootstrap.js"></script>
</body>
</html>