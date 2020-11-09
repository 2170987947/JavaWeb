<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>I成语接龙</title>
</head>
<body>
	<h1>欢迎来到成语接龙</h1>
	<h2>当前的成语接龙进度为:</h2>
	
	
	<%
	String s=(String) session.getAttribute("msg");
	if(s!=null){
		out.println(s);
	}
	else {
		out.println("暂时没有成语,请进行输入");
	}
	
	%>
	<br>
	
	<form action="Information1.jsp" method="post">
	输入成语:<input type="text" name="idioms">
	<input type="submit" value="提交">
	
	</form>
</body>
</html>