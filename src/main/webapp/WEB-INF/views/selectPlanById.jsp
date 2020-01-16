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
	<h1 align="center" style="font-family: cursive;">投资项目详情</h1>
	<table class="table table-hover">
		<tr>
			<td>项目名称</td>
			<td>${plan.name}</td>
		</tr>
		<tr>
			<td>投资资金</td>
			<td>${plan.amout}</td>
		</tr>
		<tr>
			<td>分管领导</td>
			<td>${plan.manger}</td>
		</tr>
		<tr>
			<td>所属部门</td>
			<td>${plan.dname}</td>
		</tr>
		<tr>
			<td>项目说明</td>
			<td>${plan.content}</td>
		</tr>
		<tr>
			<td align="center" colspan="100">
				<a href="${pageContext.request.contextPath }/selectPlan">返回主页面</a>
			</td>
		</tr>
	</table>
</body>
</html>