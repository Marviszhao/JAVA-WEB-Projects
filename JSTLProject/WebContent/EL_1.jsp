<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ＥＬ复杂使用</title>
</head>
<%
String color = "cyan";
String size = "12";
String textCol = "blue";
String foreGr = "red";
pageContext.setAttribute("num1", 5);
pageContext.setAttribute("num2", 6);
pageContext.setAttribute("color", color);
pageContext.setAttribute("size", size);
pageContext.setAttribute("textCol", textCol);
pageContext.setAttribute("foreGr", foreGr);

request.setAttribute("req", "reqAtt");
session.setAttribute("sess", "sessAtt");
application.setAttribute("appl", "applAtt");
%>
<body bgcolor = '${pageScope.color}'>
text = ${pageScope.textCol}
<br/> 
text2 = ${requestScope.req}
<br/>
text3 = ${sessionScope.sess}
<br/>
text4 = ${applicationScope.appl}
<br/>
<h1>
use of implicit in EL
</h1>

<Font color = "${pageScope.foreGr}" size = "${pageScope.size}">
修改背景色和文本色
</Font>
<br/>
value of num1 = ${pageScope.num1} <br/>
value of num2 = ${pageScope.num2} <br/>

value of num3 = <b>${pageScope.num1}</b> * <b>${pageScope.num2}</b>=<b>${pageScope.num1*pageScope.num2}</b>

</body>
</html>










