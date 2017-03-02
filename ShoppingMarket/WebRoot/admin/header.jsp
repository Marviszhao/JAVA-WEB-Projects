<%@page import="com.bigdata.vo.UserModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title></title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<link href="/ShoppingMarket/admin/style.css" type="text/css" rel="stylesheet"> 	
</head>
<body>
<% 
	UserModel userModel = (UserModel)request.getSession().getAttribute("loginUser");
	String userName = "";
	int userType = -1;
	if (userModel != null){
		userName = userModel.getName();
		userType = userModel.getUser_type();
	}
	
	
 %>

<div id="container">	
<div id="banner">
		<h1>商城管理</h1>
		
		<a href = "/ShoppingMarket/Login.jsp?logType=loginout"><br>退出登录</a>
		
</div>
<div id="menu">

<font size = "6">
<br>欢迎, 用户<%= userName%>进入<br><br>
<!--<br>欢迎, 用户${sessionScope.loginUser.getName()}进入<br><br>  -->	
</font> 

	<font size = 3>
	 | <a href="/ShoppingMarket/admin/addStock.jsp">添加商品</a>
	 <c:if test = "<%=userType == 1%>">
	 | <a href="/ShoppingMarket/servlet/AddStockServlet?method=queryStocks">商品信息维护</a>
	 </c:if>
 	 | <a href="/ShoppingMarket/servlet/AddStockServlet?method=buyStockList">用户购买商品界</a>
	 | <a href="/ShoppingMarket/servlet/BoughtStockServlet">查看已购买商品</a>
	 | <a href="/ShoppingMarket/admin/changePsw.jsp">修改密码</a>
	</font>

	
</div>
<br/>
<div id="main">
<!-- 为什么将缺失的标签补充上去后界面的表都排在div之后了 -->
<!-- 原来是因为其他的界面都要集成该header 若此时将div给结束了那么其他的表数据都将是在该div界面的外面 -->
<!-- 同样body也不应该结束，但是结束后的界面并没有出现大的异常，可能与html的容错能力有关系吧！ -->





