<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/11/10
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>简易计算器</title>
</head>
<body>
<jsp:useBean id="calculatorBean" class="bean.CalculatorBean">
</jsp:useBean>
<jsp:setProperty name="calculatorBean" property="*"/>
<%
    try {
        calculatorBean.calcuate();
    }
    catch (Exception e){
        out.println(e.getMessage());
    }
%>
计算结果:
 <jsp:getProperty name="calculatorBean" property="firstNum"/>
<jsp:getProperty name="calculatorBean" property="operator"/>
<jsp:getProperty name="calculatorBean" property="secondNum"/>
=
<jsp:getProperty name="calculatorBean" property="sum"/>
<hr>
<form action="Computer.jsp" method="post">
    <table border="1">
        <tr>
            <th >我的计算器</th>
        </tr>
        <tr>
            <td>第一个参数</td>
            <td><input type="text" name="firstNum"></td>
        </tr>
        <tr>
            <td>
                运算符号
            </td>
            <td>
                <select name="operator">
                    <option value="+">+</option>
                    <option value="-">-</option>
                    <option value="x">x</option>
                    <option value="/">/</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>第二个参数</td>
            <td><input type="text" name="secondNum"></td>
        </tr>
        <tr>
            <td><input type="submit" value="计算"></td>
        </tr>
    </table>
</form>
</body>
</html>

