<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
</head>
<body>
       <%! 
            Vector v=new Vector();//��̬����
            int i=0;
            ServletContext application;
            synchronized void leaveWord(String s){//������������������������
                application=getServletContext();
                i++;
                v.add("No"+i+","+s);
                application.setAttribute("Mess",v);
            }
        %>
        <%
            request.setCharacterEncoding("gb2312");//���봦��
            String name=request.getParameter("name");//��������
            String title=request.getParameter("title");//���ձ���
            String message=request.getParameter("message");//��������
            if(name==null){
                name="guest"+(int)(Math.random()*10000);
            }
            if(title==null){
                title="�ޱ���";
            }
            if(message==null){
                message="����Ϣ";
            }
            String s=name+"#"+title+"#"+message;
            leaveWord(s);
            out.print("����������ύ��");
        %>
        <a href="input.jsp">��������ҳ��</a>
</body>
</html>