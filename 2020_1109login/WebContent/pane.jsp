<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"  %>
<%@ page import="java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>pane.jsp</title>
</head>
<body>
        <%
            request.setCharacterEncoding("gb2312");
            Vector v=(Vector)application.getAttribute("Mess");
            for(int i=0;i<v.size();i++){
                String message=(String)v.elementAt(i);
                String []a=message.split("#");
                out.print("留言人："+a[0]+"<br>");
                out.print("标题："+a[1]+"<br>");
                out.print("留言内容："+a[2]+"<br>");
            }
        %>
</body>
</html>