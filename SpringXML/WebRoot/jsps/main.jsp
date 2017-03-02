<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	${requestScope.resultList}<br><br>
	${sessionScope.resultList}<br>
	
	<table>
		<tr>
			<td>用户id</td>
			<td>用户名</td>
			<td>用户密码</td>
			<td>删除</td>
			<td>修改</td>
		</tr>
		<!-- EL表达式中间不能有任何的空格否则会导致解析model数据异常导致jsp界面崩溃  "${resultList}"-->
		<c:forEach items="${requestScope.resultList}" var="model">
			<tr>
				<td>${model.id}</td>
				<td>${model.user_name}</td>
				<td>${model.user_psw}</td>
				<td><a href="user.do?method=delete&id=${model.id}">删除</a>
				</td>
				<td><a href="update.jsp?user_name=${model.user_name}
					&user_psw=${model.user_psw}&id=${model.id}">修改</a></td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>