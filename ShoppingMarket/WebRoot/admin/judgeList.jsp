<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file ="/admin/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评论列表</title>
</head>
<body>

	<table border="1"  cellspacing = "0" cellpadding = "0" bgcolor = "cyan">
		<tr>
			<td>评论编号</td>
			<td>评定星级</td>
			<td>评论内容</td>
			<td>评论用户ID</td>
			<td>是否匿名</td>
			<td>删除</td>
		</tr>
	<c:forEach items = "${requestScope.judge_list}" var = "judgeModel">
	    <tr>
			<td>${judgeModel.id}</td>
			<td>${judgeModel.judge_star}</td>
			<td>${judgeModel.judge_content}</td>
			<td>${judgeModel.user_id}</td>
			<td>
		<!-- EL 表达式的加减乘除判断必须都要在${} 内部，否则 会有c:if永远进不去的bug-->
			<c:if test="${judgeModel.judge_secret==1}">匿名</c:if>
			<c:if test="${judgeModel.judge_secret==2}">实名</c:if>		
			</td>
			<td><a href = "/ShoppingMarket/servlet/JudgeServlet?judgeID=${judgeModel.id}&function=delete_judge&stockID=${judgeModel.stock_id}">删除</a></td>
	    </tr>	
	
	</c:forEach>
		


	</table>
<%@ include file = "/admin/footer.jsp" %>
</body>
</html>