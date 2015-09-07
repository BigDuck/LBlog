<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
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
 <div class="ibox-title">
                                <h5>基本 <small>分类，查找</small></h5>
                                <div class="ibox-tools">
                                    <a class="collapse-link">
                                        <i class="fa fa-chevron-up"></i>
                                    </a>
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="table_data_tables.html#">
                                        <i class="fa fa-wrench"></i>
                                    </a>
                                    <ul class="dropdown-menu dropdown-user">
                                        <li><a href="table_data_tables.html#">选项1</a>
                                        </li>
                                        <li><a href="table_data_tables.html#">选项2</a>
                                        </li>
                                    </ul>
                                    <a class="close-link">
                                        <i class="fa fa-times"></i>
                                    </a>
                                </div>
                            </div>
	<div class="ibox-content">

		<table
			class="table table-striped table-bordered table-hover dataTables-example">
			<thead>
				<tr>
					<th>文章id</th>
					<th>文章标题</th>
					<th>所属分类</th>
					<th>发布时间</th>
					<th>作者</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="article" items="${users}">
				<tr id="${article.aId}">
					<td>${article.aId}</td>
					<td>${article.aTitle}</td>
					<td>${article.aType.tName}</td>
					<td><fmt:formatDate value="${article.aDate}" type="date"
							dateStyle="default" /></td>
					<td>${article.user.uName}</td>
					<td><input type="button" class="btn btn-default" value="编辑" onclick="update(${article.aId})" />
						<input type="button" class="btn btn-default" value="删除" onclick="deleteArt(${article.aId},'${article.aTitle}')" /></td>
				</c:forEach>

				</tr>
			</tbody>
			<tfoot>
				<tr>
					<th>文章id</th>
					<th>文章标题</th>
					<th>所属分类</th>
					<th>发布时间</th>
					<th>作者</th>
					<th>操作</th>
				</tr>
			</tfoot>
		</table>
		
	</div>

	<!-- Data Tables -->
	<script src="static/js/jquery-1.9.1.min.js"></script>
	<script src="static/js/bootstrap.min.js?v=3.4.0"></script>
<script type="text/javascript">
function update(aId) {
	 location.href="admin?what=getart&aId="+aId;
}

function deleteArt(aId,title) {
	layer.confirm('你确定要删除《'+title+'》', {icon: 3}, function(index){
	    layer.close(index);
	    $.ajax({
	    	type: "POST",
			url: 'admin?what=remove',
	    	data:{"aId":aId},
			dataType:'json',
			cache: false,
			success:function(data){
			if(data=="1"){
				$("#"+aId).remove();
				layer.msg('果断成功', function(){
					
					});
			}else{
				layer.msg('失败了', {
				    offset: 100,
				    shift: 1
				});
			}
			}
	    	
	    	
	    });
	});
	
}
</script>
	<script>
        $(document).ready(function () {
            $('.dataTables-example').dataTable();

            /* Init DataTables */
            var oTable = $('#editable').dataTable();

            /* Apply the jEditable handlers to the table */
            oTable.$('td').editable('../example_ajax.php', {
                "callback": function (sValue, y) {
                    var aPos = oTable.fnGetPosition(this);
                    oTable.fnUpdate(sValue, aPos[0], aPos[1]);
                },
                "submitdata": function (value, settings) {
                    return {
                        "row_id": this.parentNode.getAttribute('id'),
                        "column": oTable.fnGetPosition(this)[2]
                    };
                },

                "width": "90%",
                "height": "100%"
            });


        });

    </script>
	<script src="<%=basePath%>/static/js/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="<%=basePath%>/static/js/plugins/jeditable/jquery.jeditable.js"></script>
	<script src="<%=basePath%>/static/js/plugins/dataTables/dataTables.bootstrap.js"></script>
</body>
</html>