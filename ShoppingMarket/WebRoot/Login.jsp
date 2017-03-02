<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<%
	String loginType = request.getParameter("logType");
	if ("loginout".equals(loginType)){
		request.getSession().removeAttribute("loginUser");
	
	}

 %>
<body>
	<form action="/ShoppingMarket/servlet/LoginServlet" method="post">
	<input type = "hidden" name = "cmdStr" value = "login_action">
		<table>
			<tr>
				<td>用户名：<input name="user_name" type="text">
				</td>
			</tr>
			<tr>
				<td>密码：<input name="user_psw" type="password"></td>
			</tr>


			<tr>
				<td><input type="submit" value="登录"></td>
				<td><a href="/ShoppingMarket/Register.jsp">去注册</a></td>
			</tr>

		</table>


	</form>
</body>
</html>