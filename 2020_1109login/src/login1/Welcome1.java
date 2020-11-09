package login1;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Welcome
 */
@WebServlet("/Welcome")
public class Welcome1 extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings({ "unused", "deprecation" })
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		response.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK");
		
		
		//获取Session中信息
		HttpSession hs=request.getSession(true);
		
		int counter=0;
        Object count = hs.getAttribute("COUNTER");
         if(count==null){
             counter=1;
         }
         else {
             counter = ((Integer) count).intValue();
             counter++;

         }
         hs.setAttribute("COUNTER",new Integer(counter));
         
		String name=(String)hs.getAttribute("uname");
		String pass=(String)hs.getAttribute("passwd");
		PrintWriter pw =response.getWriter();
		
		pw.println("<h1>主界面</h1>");
	/*	if(name==null){//判断直接访问欢迎界面的用户是否合法（Session没有用户名，不是从主界面进去的）
			String cname="";
			String cpasswd="";
			Cookie[] allCookies=request.getCookies();//获取Cookie
			if(allCookies!=null){
				for(int i=0;i<allCookies.length;i++){
					Cookie temp=allCookies[i];
					//获取Cookie中用户名和密码
					if(temp.getName().equals("myname"));
					{
						cname=temp.getValue();
					}
					if(temp.getName().equals("passwd"))
					{
						cpasswd=temp.getValue();
					}
				}
				if(!cname.equals("")&&!cpasswd.equals(""))//获取用户名和密码之后将其送至用户验证部分，验证其合法性
				{
					
					response.sendRedirect("/Login1/Welcome? cname="+cname+"&password="+cpasswd+"<br>");
					pw.println("Welcome name="+cname+" "+"password="+cpasswd+"<br>");
				}
			}
			else response.sendRedirect("/Login1/login");
		}
		*/
		String val=(String)hs.getAttribute("pass");
		String username =request.getParameter("uname");
		String password=request.getParameter("password");
		//pw.println("<h1>主界面</h1>");
		pw.println("Welcome name="+username+" "+"password="+password+"<br>");
		pw.println("这是你第:"+counter+"次访问本网站!");
        pw.println("<br>");
		
		pw.println("<a href='/2020_1109login/login'>返回重新界面</a><br>");
		
		Cookie[] cookies = request.getCookies();
        if(cookies!=null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("lastAccessTime")) {
                    pw.write("您上次访问的时间是：");
                    Long lastAccessTime = Long.parseLong(cookies[i].getValue());
                    Date date = new Date(lastAccessTime);
                    pw.write(date.toLocaleString());
                }
            }
        }
       //用户访问过后重新设置用户的访问时间，存储在cookie中，然后发送到客户端浏览器
        Cookie cookie=new Cookie("lastAccessTime",System.currentTimeMillis()+"");
        //设置cookie的有效期为1min
        cookie.setMaxAge(60);
        //将cookie对象添加到response对象中，这样服务器在输出response对象中的内容时
        // 就会把cookie也输入到客户端浏览器
        response.addCookie(cookie);
	}
	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		this.doGet(request, response);

	}
	
}