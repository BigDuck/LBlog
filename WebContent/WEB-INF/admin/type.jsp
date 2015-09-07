<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>详情</title>
<link rel="stylesheet" href="<%=basePath%>/static/css/bootstrap.min.css">
<script src="<%=basePath%>/static/js/jquery-2.1.1.min.js"></script>
<script src="<%=basePath%>/static/js/bootstrap.min.js"></script>
<link href="<%=basePath%>/static/layer/skin/layer.css" rel="stylesheet">
<script src="<%=basePath%>/static/layer/layer.js"></script>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading">文章类别</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-lg-12">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<h5>可编辑表格</h5>
							<div class="ibox-tools">
								<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
								</a>

								<ul class="dropdown-menu dropdown-user">
									<li><a href="table_data_tables.html#">选项1</a></li>
									<li><a href="table_data_tables.html#">选项2</a></li>
								</ul>
								<a class="close-link"> <i class="fa fa-times"></i>
								</a>
							</div>
						</div>
						<div class="ibox-content">
							<div class="">
								<input onclick="addRow();" type="button" class="btn btn-primary"
									value="添加新类别"> <input type="text" required="required"
									class="alert alert-info" id="typeName" placeholder="输入类别名字" />
								<input type="text" id="typeOther" class="alert alert-info"
									placeholder="输入类别说明，可不写" />

							</div>
							<table class="table table-striped table-bordered table-hover "
								id="editable">
								<thead>
									<tr>
										<th>类别名称</th>
										<th>其他</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="aType" items="${allType}">
										<tr class="gradeX" id="row${aType.tId}">
											<td>${aType.tName}</td>
											<td>${aType.other}</td>
											<th><input type="button" class="btn btn-primary"
												onclick="save()" value="保存"> <input type="button"
												class="btn btn-danger" onclick="deleteType(${aType.tId})"
												value="删除"></th>
										</tr>
									</c:forEach>

								</tbody>
								<tfoot>
									<tr>
										<th>类别名称</th>
										<th>其他</th>
										<th>操作</th>
									</tr>
								</tfoot>
							</table>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
        $(document).ready(function () {
            $('.dataTables-example').dataTable();

            /* Init DataTables */
            var oTable = $('#editable').dataTable();

            /* Apply the jEditable handlers to the table */
            oTable.$('td').editable(this, {
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
function addRow() {
	if($("#typeName").val()==null||$("#typeName").val()==""){
		layer.msg('类別不能未空啊', function(){
			$("#typeName").focus();
		});
		return;
	}
	   $.ajax({
       	type: "POST",
			url: '<%=basePath%>admin/articletype?what=add',
	    	data:{"typeName":$("#typeName").val(),"typeOther":$("#typeOther").val()},
			dataType:'json',
			cache: false,
			success:function(data){
				if("1"==data){
					layer.msg("成功了",{icon:1});
				       $('#editable').dataTable().fnAddData([
$("#typeName").val(),
$("#typeOther").val(),
"<input type='button' class='btn btn-primary'onclick='save()' value='保存'> <input type='button'class='btn btn-danger' onclick='deleteType()'value='删除'>"
]);

				}else{
					layer.msg("失败咯",{icon:2});	
				}
			}
       });
}
     function deleteType(id){
    		layer.confirm('你确定要删除', {icon: 3}, function(index){
    	 if(id==null){
    			layer.msg("新增加的请刷新下再删除",{icon:3});
    	 }else{
    		 layer.load();
    		  $.ajax({
    				type: "POST",
    				url: '<%=basePath%>admin/articletype?what=del',
    		    	data:{"typeId":id},
    				dataType:'json',
    				cache: false,  
    				success:function(data){
    					if("1"==data){
    						layer.msg('成了',{icon:1});
    						$("#row"+id).remove();
    						  layer.closeAll('loading');
    					}else{
    						layer.msg("失败咯",{icon:2});	
    						  layer.closeAll('loading');
    					}
    				}
    			  
    		  });
    		 
    	 }
     }
     )}

    </script>
	<script
		src="<%=basePath%>static/js/plugins/dataTables/jquery.dataTables.js"></script>
	<script
		src="<%=basePath%>static/js/plugins/jeditable/jquery.jeditable.js"></script>
	<script
		src="<%=basePath%>static/js/plugins/dataTables/dataTables.bootstrap.js"></script>
</body>
</html>