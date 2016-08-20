<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查找所有</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <center>
  	<a href="<%=basePath%>toAddUser.do">添加用户</a><br/>
  	<a href="<%=basePath%>toLogin.do">登录</a><br/>
  	<table border="1">
  		<tr>
  			<th>编号</th>
  			<th>用户名</th>
  			<th>操作</th>
  		</tr>
  		<c:forEach items="${userList}" var="us">
  		<tr>
  			<td>${us.id}</td>
  			<td>${us.name}</td>
  			<td><a href="<%=basePath%>deleteUser.do?id=${us.id}">删除</a>|<a href="<%=basePath%>findOne.do?id=${us.id}">修改</a></td>
  		</tr>
  		</c:forEach>
  	</table>
  	</center>
  </body>
</html>
