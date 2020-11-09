package login1;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login1 extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<h1>登陆界面</h1>");
		pw.println("<form action =/2020_1109login/LoginCl method=post>");
		pw.println("用户名：<input type=text name=username><br>");
		pw.println("密码：<input type=password name=passwd><br>");
		pw.println("<input type=checkbox name=keep >两周内免登陆 <br>");
		
		pw.println("<input type=submit value=登录><br>");
		pw.println("</form>");
		pw.println("<body>");
		pw.println("<html>");
		String username = null;
        String password = null;
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            if ("username".equals(cookies[i].getName())) {
                username = cookies[i].getValue();
            } else if ("password".equals(cookies[i].getName())) {
                password = cookies[i].getValue();
            }
        }
            if (username != null && password != null) {
                response.sendRedirect("/2020_1109login/Welcome?uname=" + username + "&password=" + password);
            }
		}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		this.doGet(request, response);
	}
}

