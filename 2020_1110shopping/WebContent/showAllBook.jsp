<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="vo.book"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>

<b style=" font-size:30px;color:blue">欢迎选购图书</b><br>
<%
  HashMap allbook=(HashMap)session.getAttribute("allbook");
%>
<table border="0">
<tr bgcolor="pink">
<td><b style=" font-size:20px;color:black">书本名称</b></td>
<td><b style=" font-size:20px;color:black">购买</td>
</tr>
<% Set set=allbook.keySet();
Iterator ite=set.iterator();
while(ite.hasNext())
{
	 String bookno=(String)ite.next();
	 book bookx=(book)allbook.get(bookno);
	 %>
<tr bgcolor="white">
<td><%=bookx.getBookname() %></td>
<td><a href = "buyForm.jsp?bookno=<%=bookno%>">购买</a></td>
</tr>
<%}%>
</table>
<a href = "showCart.jsp">查看购物车</a>
</body>
</html>