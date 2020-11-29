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
<%
	String bookno=request.getParameter("bookno");
	HashMap allbook=(HashMap)session.getAttribute("allbook");
	book bookl=(book)allbook.get(bookno);
%>
<center>
欢迎购买：<%=bookl.getBookname()%>
	<form action="AddServlet" method="post">
		<input name ="bookno" type="hidden" value="<%=bookl.getBookno()%>">
		<input name ="bookname" type="hidden" value="<%=bookl.getBookname()%>">
		<input name ="booknumber" type="text">
		<input type="submit" value="购买">
	</form>
</center>

</body>
</html>