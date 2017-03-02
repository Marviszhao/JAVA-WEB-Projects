<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form action="/ShoppingMarket/servlet/RegisterServlet" method="post">
    	<table>
    		<tr><td>用户名：<input name = "user_name" type ="text"></td></tr>
    	<tr><td>密码：<input name = "user_psw" type = "password"></td></tr>
    	
    	<tr><td>
    	用户类型：
    	<select name = "user_type">
    		<option value="0">用戶</option>
    		<option value = "1">商家</option>
    	</select>
    	</td></tr>
    	
    	<tr>
    	<td> <input type="submit" value="注册"> </td>
    	</tr>
    	
    	</table>
    
    
    </form>
</body>
</html>