<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Request2" method="post">
用户名： <input type="text" name="name"/>
<P>输入密码： <input type="password" name="pw1" id="pw1"/></P>
<p>确认密码： <input type="password" name="pw2" id="pw2" /></p>
性别：                   <input type="radio" name="sex" value="男" checked="checked">男
            <input type="radio" name="sex" value="女">女<br/>
兴趣爱好：           <input type="checkbox" name="hobby" value="足球">足球
            <input type="checkbox" name="hobby" value="篮球">篮球
            <input type="checkbox" name="hobby" value="排球">排球
            <input type="checkbox" name="hobby" value="羽毛球">羽毛球<br/>
            <td colspan="2">
            <span name="province_Span">请选择省份</span></td>
            <select name="province">
							<option value="0">请选择</option>
							<option value="北京">北京</option>
							<option value="天津">天津</option>
							<option value="天津">天津</option>
							<option value="上海">上海</option>
							<option value="重庆">重庆</option>
					        </select> 
            <textarea name="introduce"  >介绍一下自己</textarea>
            <p><input type="submit" value="注册" id="submit"/>
            	
            
</form>
</body>
</html>