<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Insert title here</title>
</head>
<body>
<form action="LoginServlet" method="post">
	<table>
		<tr>
		    <th>�û���:</th>
		    <th><input type="text" name="username" value="${cookie.cook_name.value }"/></th>
		</tr>
		<tr>
		    <th> ����</th>
		    <th><input type="password" name="pas" value="${cookie.passwd.value }"/></th>
		</tr>
		<tr>
		    <th>��֤��</th>
		    <th><input type="text" name="yzm" id="yzm"/></th>
		    <th>	<img src="image2.jsp"/> </th>
		 </tr>
	</table>  
	<input type="checkbox"  name="chkCookie" value="7"/>7�����¼<br>
		<input type="submit" value="��¼"/>
		<a href="regist.jsp">ע�� </a>
 
</form>
</body>
</html>