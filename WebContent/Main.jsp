<%@page import="java.util.List"%>
<%@page import="com.bean.Product"%>
<%@page import="com.service.impl.ProductServiceImpl"%>
<%@page import="com.service.ProductService"%>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to Book Shop</h1>
<div id="denglu" align="center">
	<a href="login.jsp">登录</a>
	<a href="registe.jsp">注册</a>
	<a href="ShoppingCart.jsp">我的购物车</a>
	<a href="LoginOut">退出</a>
	<p></p>
</div>
<div id="templatemo">
<div id="templatemo_main">
	<%
	ProductService ps = new ProductServiceImpl();
	List<Product> products = ps.select();
	for(int i=0;i<products.size();i++){
		Product product = products.get(i);
		%>
		<div>
            <a href="productdetail.html"><img src="image/0<%=i+1%>.jpg"/></a>
            <h3><%=product.getProductname() %></h3>
          	<p>$<%=product.getPrice() %></p>
            <p>
                <a href="productdetail.html">图书详情</a>
                <a href="Cart?productId=<%=product.getId() %>">加入购物车</a>
            </p>
        </div>  
		
		<%
	}
	%>
    </div>
</div>
</body>
</html>