<%@page import="com.zhiyou.dao.UserModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改个人密码</title>
</head>
<body>
<font color='cyan'>
<!-- java 代码嵌套写法 -->
<%
UserModel userModel = (UserModel)session.getAttribute("user");
out.print(userModel);
%>
<br>

<!-- 外层输出 -->
<%= userModel%>
</font>

<br><br>
登录成功
欢迎用户：<font color='blue'>
${sessionScope.user.u_user}
</font>
进入系统，祝您生活愉快！

<br><br>
<form action="LSChangePswServlet" method="post">
原始密码：<input type="text" name="old_psw"><br><br>
新密码：<input type="text" name="new_psw"><br><br>
确认密码：<input type="text" name="confirm_psw"><br><br>

<input type="submit" value="修改密码" name="changePswBtn">
</form>
<br><br>

<font color = "red" size = 20>
<c:choose>

<c:when test="${requestScope['code'] ==1 }">原始密码错误</c:when>
<c:when test="${requestScope['code'] ==2 }">新密码与旧密码一致</c:when>
<c:when test="${requestScope['code'] ==3 }">两次输入新密码不一样</c:when>
<c:otherwise>${requestScope['code']}</c:otherwise>

</c:choose>

</font>

<br>




</body>
</html>