<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
</head>
<body>
        <form action="show.jsp" method="post" name="form">
            输入名字：<input type="text" name="name" value=""><br>
            留言标题：<input type="text" name="title" value=""><br>
            留言：<br>
            <textarea name="message" rows="10" cols="40" >
            </textarea>
            <br><input type="submit" name="submit" value="提交">
        </form>
        <a href="pane.jsp">查看信息</a>
</body>
</html>