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
	<h1 align="center" style="font-family: cursive;">准能公司2019年投资计划</h1>
	<form action="${pageContext.request.contextPath }/selectPlan" method="post" id="fid" >
		项目名称：<input type="text" name="name" value="${plan.name}">
		<input type="submit" value="查询">
	</form>
	<table class="table table-hover">
		<tr>
			<td>
				<input type="radio" name="cks" onclick="cks(1)">全选
				<input type="radio" name="cks" onclick="cks(0)">全不选
				<input type="radio" name="cks" onclick="cks(-1)">反选
			</td>
			<td>编号</td>
			<td>项目名称</td>
			<td>投资资金</td>
			<td>分管领导</td>
			<td>部门</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${info.list}" var="li">
			<tr>
				<td>
					<input type="checkbox" class="ck" value="${li.id}">
				</td>
				<td>${li.id}</td>
				<td>${li.name}</td>
				<td>${li.amout}</td>
				<td>${li.content}</td>
				<td>${li.dname}</td>
				<td>
					<a href="${pageContext.request.contextPath }/selectPlanById?id=${li.id}">查询详情</a>|
					<a href="${pageContext.request.contextPath }/updatePlan?id=${li.id}">修改</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td align="center" colspan="100">
				<jsp:include page="/WEB-INF/views/pages2.jsp"></jsp:include>
				<input type="button" value="批删" onclick="delAll()" class="btn btn-danger">
				<a href="${pageContext.request.contextPath }/insertPlan">添加</a>
			</td>
		</tr>
	</table>
</body>
<script type="text/javascript">
	function goPage(page) {
		location.href="${pageContext.request.contextPath }/selectPlan?page="+page+"&"+$("#fid").serialize();
	}
	function cks(i) {
		if(i==1){
			$(".ck").prop("checked",true);
		}else if(i==0){
			$(".ck").prop("checked",false);
		}else if(i==-1){
			$(".ck").each(function(){
				this.checked=!this.checked;
			});
		}
	}
	function delAll() {
		var ids = "";
		$(".ck:checked").each(function(){
			ids+=","+$(this).val();
		});
		ids=ids.substring(1);
		if(confirm("你确定要删除id为"+ids+"的数据吗？")){
			$.ajax({
				url:'${pageContext.request.contextPath }/delAll',
				type:'post',
				data:{ids:ids},
				success:function(obj){
					if(obj>0){
						alert("批删成功");
						location.href='${pageContext.request.contextPath }/selectPlan';
					}else{
						alert("批删失败");
					}
				}
			});
		}
	}
</script>
</html>