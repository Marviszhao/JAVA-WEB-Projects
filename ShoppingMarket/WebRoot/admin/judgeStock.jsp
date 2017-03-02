<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file = "/admin/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评价商品</title>
</head>
<body>

<form action = "/ShoppingMarket/servlet/JudgeServlet" method = "post">
	<input type = "hidden" name = "stockid" value = "${param.stockid}">
	<input type = "hidden" name = "function" value = "insertJudge">
	<table>
	<tr><td>商品名称:<input type = "text" value = "${param.stockName}"></td></tr>
	<tr><td>评价的星级:
				<input type = "radio" name = "judge_star" value = "1">
				<input type = "radio" name = "judge_star" value = "2">
				<input type = "radio" name = "judge_star" value = "3">
				<input type = "radio" name = "judge_star" value = "4">
				<input type = "radio" name = "judge_star" value = "5" checked = "checked">			
	</td></tr>
	
	<tr><td>评价内容:<input type = "text" name = "judge_content"></td></tr>
	<tr><td>匿名评价:
		<select name = "judge_secret">
			<option value = "1">匿名</option>
			<option value = "2">实名</option>
		</select>
	</td></tr>
	<tr><td><input type = "submit" value = "提交评价"></td></tr>
	</table>

</form>




</body>
</html>