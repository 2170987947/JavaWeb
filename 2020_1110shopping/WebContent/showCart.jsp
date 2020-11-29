<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="vo.*"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<table border="0">
<tr bgcolor="white">
<td>编号</td>
<td>书本名称</td>
<td>数量</td>
<td>确认</td>
</tr>
<%
  HashMap books=(HashMap)session.getAttribute("books");
  Set set=books.keySet();
  Iterator ite=set.iterator();
  while(ite.hasNext())
  {
	String bookno=(String)ite.next();
	book bookj=(book)books.get(bookno);
%>
<tr bgcolor="white">
<td><%=bookj.getBookno() %></td>
<td><%=bookj.getBookname() %></td>
<form action="AddServlet" mothod="post">
<input name ="bookno" type="hidden" value="<%=bookj.getBookno()%>">
<input name ="bookname" type="hidden" value="<%=bookj.getBookname()%>">
<td><input name ="booknumber" type="text" value="<%=bookj.getBooknumber()%>"></td>
<td><input type="submit" value="确认"></td>
</tr>
<% } %>
</table>
<a href="showAllBook.jsp">继续买书</a>
<a href="ClearServlet">清空购物车</a>
</center>
</body>
</html>