<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>登录</title>
</head>
<body  style="background:url(image/12.jpg) no-repeat">
<form action="Login" method="POST"> 

<table width="350" height="150"  border="0" align="center" >
</table>

<table  width="350"  style="border-color" border="1" align="center" >     
	<tr align=center>		
		<td>用户名:</td>
		<td><input type="text" name="username"  id="username"></td>	
	</tr>     
	<tr align=center>
		<td>密 码:</td><td><input type="password" name="password" id="password"></td>
	</tr>    
	<tr align=center><td colspan="2">
		<input type="submit" value="登陆">
		<a href="registe.jsp">注册</a>             
</table>
</form>
</body>

</html>






