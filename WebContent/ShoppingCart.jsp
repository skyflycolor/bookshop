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
<h2>已购得图书</h2>
<%
	if(session.getAttribute("user")==null){
		System.out.println("请先登录");
		 response.sendRedirect("error.jsp");
		 }
%>
<%
	ProductService ps = new ProductServiceImpl();
	List<Product> products = ps.select();
	for(int i=0;i<products.size();i++){
		Product product = products.get(i);
		%>
           <img src="image/0<%=i+1%>.jpg"/></a>
            <h3><%=product.getProductname() %></h3>
          	<p>$<%=product.getPrice() %></p>
		<%
	}
	%>

</body>
</html>