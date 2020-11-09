<%@ page import="java.util.Date,java.text.SimpleDateFormat" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<% 
      HttpSession hs=request.getSession(true);
      String name=(String)hs.getAttribute("uname");
	  String pass=(String)hs.getAttribute("pass");
      //判断cookie有没有失效
     if(null != name){
	    	out.print("<p>欢迎登录："+name +"</p>");
	    	 Cookie currentTime = new Cookie("lastTime", String.valueOf(System.currentTimeMillis()));
	         currentTime.setMaxAge(2*7*60 * 60 * 24);  
	       	//从记忆中获取上次访问时间
	         response.addCookie(currentTime);
	         Cookie lastTimeCookie = null;
	         Cookie cook=null;
	         boolean b=false;
	         Cookie[] cookies = request.getCookies();
	         Cookie[] cookies2=request.getCookies();
	         //判断是否存在lastTime
	         if(cookies != null){
	             for (Cookie cookie : cookies)
	                 if (cookie.getName().equals("lastTime")) {
	                     lastTimeCookie = cookie;
	                     break;
	                 }
	         }
	         //判断lastTimeCookie是否存在
	         if(lastTimeCookie != null){
	             //是，上次访问
	             Date lastTimeDate = new Date();
	             lastTimeDate.setTime(Long.parseLong(lastTimeCookie.getValue()));
	             SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
	             String lastTimeStr = sdf.format(lastTimeDate);
	             response.getWriter().write("欢迎回来，您上次访问时间为：" + lastTimeStr);
	         }else{
	             //否，首次访问
	             response.getWriter().write("您好，欢迎您首次访问。");
	         }
	         if(cookies2 != null){
	             //判断是否存在lastTime
	             for (Cookie cookie : cookies2)
	                 if (cookie.getName().equals("Visit")) { 
	                    cook=cookie;
	                    cook.setValue(""+(Integer.parseInt(cook.getValue())+1));
	                    cook.setPath(request.getContextPath());
	                    cook.setMaxAge(2*7*60 * 60 * 24);
	                    response.addCookie(cook);
	                 }
	         }
	         if(cook==null)
	         {
	        	 b=true;
	        	 cook=new Cookie("Visit","1");
	        	 cook.setMaxAge(2*7*60 * 60 * 24);
	        	 cook.setPath(request.getContextPath());
	        	 response.addCookie(cook);
	         }
	       out.println("这是您第"+cook.getValue()+" 次登录该网站 (在Cookie里计的数)");       
	     }
     else{
    	 response.sendRedirect("login2.jsp");
     }
%>
</body>
</body>
</html>