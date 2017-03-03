<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" cellpadding = "0" cellspacing = "0">
		<tr>
			<td align = "center">id&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td align = "center">姓名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td align = "center">密码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td align = "center">管理&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
	
	
	<c:forEach items = "${requestScope.list}" var = "model">
			<tr>
				<td>${model.id}</td>
				<td>${model.userName}</td>
				<td>${model.passWord}</td>
				<td><a href="/RestMyibatisSpring/jsps/update.jsp?id=${model.id}&name=${model.userName}&psw=${model.passWord}">修改</a>&nbsp;&nbsp;&nbsp;
				<a href="/RestMyibatisSpring/user/delete/${model.id}">删除</a>
				</td>
			</tr>

		</c:forEach>

	</table>

</body>
</html>