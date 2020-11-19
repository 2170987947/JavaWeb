<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/10/19
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>practice</title>
</head>
<body>
<table border="1">
<c:forEach var="i" begin="1" end="9">
    <tr>
        <c:forEach var="j" begin="1" end="${i}">
            <td>
                <c:out value="${i}*${j}=${i*j}"></c:out>
            </td>
        </c:forEach>
    </tr>
</c:forEach>
</table>
</body>
</html>
