<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/public/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath }/public/js/jquery.min.1.12.4.js"></script>
<script src="${pageContext.request.contextPath }/public/js/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath }/public/css/index.css"  rel="stylesheet">
</head>
<body>
	<form id="fid">
	
				项目名称：
				<input type="text" name="name"><br>
				所属部门：
					<select id="did" name="did">
						<option value="0">请选择</option>
					</select><br>
				
			
				投资资金：
				<input type="text" name="amout">元<br>
				分管领导：
				<input type="text" name="manger"><br>
				项目介绍：
				<textarea rows="5" cols="20" name="content"></textarea><br>
			
				<input type="button" value="发布" onclick="insertPlan()">
	</form>
</body>
<script type="text/javascript">
	$(function(){
		$.ajax({
			url:'${pageContext.request.contextPath }/selectDepartment',
			success:function(obj){
				for ( var i in obj) {
					$("#did").append("<option value='"+obj[i].id+"'>"+obj[i].name+"</option>");
				}
			}
		});
	});
	function insertPlan() {
		var data=$("#fid").serialize();
		alert(data);
		$.ajax({
			url:'${pageContext.request.contextPath }/insertPlan',
			type:'post',
			data:data,
			success:function(obj){
				if(obj>0){
					alert("添加成功");
					location.href='${pageContext.request.contextPath }/selectPlan';
				}else{
					alert("添加失败");
				}
			}
		});
	}
</script>
</html>