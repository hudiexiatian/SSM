<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	function checkUser(){
		var form = document.forms[0];
		form.action = "<%=basePath%>login.do";
		form.method="post";
		form.submit();
	}
	</script>
  </head>
  
  <body>
  	<center>
    <form action="" name="loginForm"> 
    	name:<input type="text" name="name"/><br/>
    	pwd:<input type="password" name="pwd"/><br/>
    	<input type="button" value="验证" onclick="checkUser();">
    </form>
    </center>
  </body>
</html>
