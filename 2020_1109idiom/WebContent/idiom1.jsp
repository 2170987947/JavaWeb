<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>I�������</title>
</head>
<body>
	<h1>��ӭ�����������</h1>
	<h2>��ǰ�ĳ����������Ϊ:</h2>
	
	
	<%
	String s=(String) session.getAttribute("msg");
	if(s!=null){
		out.println(s);
	}
	else {
		out.println("��ʱû�г���,���������");
	}
	
	%>
	<br>
	
	<form action="Information1.jsp" method="post">
	�������:<input type="text" name="idioms">
	<input type="submit" value="�ύ">
	
	</form>
</body>
</html>