<%@ page import="java.io.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="utf-8" %>
<html>
<head>
    <title>成语接龙信息查看 </title>
</head>
<body>
<%!
String msg="";
%>
    
<%
request.setCharacterEncoding("utf-8");
String idiom = request.getParameter("idioms");
 //判断长度是否合格
    if(idiom.length()!=4){
        out.println("成语的长度应该为4个字，请重新输入<br>");
        out.println("<a href=idiom.jsp>重新输入</a>");
        return;
    }
    //如果不是第一个则需要判断成语是否接龙，是第一个则不需要重新判断
    if(!msg.equals("")){
        if(msg.charAt(msg.length()-2)!=idiom.charAt(0)){
            out.println("请注意成语接龙规则：后一个成语的第一个字必须是前一个成语的最后一个字，请重新输入<br>");
            out.println("<a href=idiom.jsp>重新输入</a>");
            return;
        }
    }
    //判断是否是成语 在提供的成语库中进行查询  成语不全 可能有遗漏 误伤情况
    boolean isIdiom=false;
    BufferedReader br=null;
    try {
        br = new BufferedReader(
                new InputStreamReader(new FileInputStream("C:\\Users\\Lenovo\\IdeaProjects\\webDemo\\ServletDemo\\src\\information\\idiom.txt"),"utf-8"));
        String connection = br.readLine();
        while (connection != null) {
            if(connection.contains(idiom)) {
                out.println(idiom);
                isIdiom = true;
                break;
            }
            connection = br.readLine();
        }
    }
    catch (IOException e){
        e.printStackTrace();
    }
    if(isIdiom==false){
        out.println("你输入的不是成语，请重新输入");
        out.println("<a href=idiom.jsp>重新输入</a>");
        return;
    }

    msg+=idiom+" ";
    session.setAttribute("msg",msg);
    out.println("成语已经提交成功，三秒后自动跳转查看成语");
   response.setHeader("refresh","3;idiom.jsp");
%>
</body>
</html>
