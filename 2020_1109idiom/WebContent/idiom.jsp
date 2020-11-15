<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Insert title here</title>
</head>
<body>
	<h2>四字成语接龙</h2>
	<%
	String s=(String)application.getAttribute("message");
	if(s!=null){
		out.print(s);
	}
	else{
		out.print("还没有词语,请您以龙头开始!<br>");
	}
	
	%>
	<form action="Information.jsp" method="post">
	请输入成语:<input type="text" name="mes"/><br>
	<input type="submit" value="提交"/>
	</form>

</body>
</html>