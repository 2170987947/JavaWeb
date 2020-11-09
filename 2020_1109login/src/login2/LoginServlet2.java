package login2;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet( name ="LoginServlet",urlPatterns={"/LoginServlet"})//使用注解方式部署servlet
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String username = request.getParameter("username");
		String password=request.getParameter("pas");
		//获取7天内是否免登录
		String day7 = request.getParameter("chkCookie");
		if(null != day7){
			//创建cookie
			Cookie cookie  = new Cookie("cook_name",username);
			Cookie cookie1=new Cookie("passwd",password);
			//设置Cookie有限期
			cookie.setMaxAge(5);//有效期6秒
			cookie1.setMaxAge(5);
			//设置7天免登录
			//cookie.setMaxAge(3600 * 24 *7);
			//cookie1.setMaxAge(3600 * 24 *7);
			//写入cookie到浏览器
			response.addCookie(cookie);
			response.addCookie(cookie1);
		}
	
		
		response.sendRedirect("cookieUser2.jsp");
		HttpSession hs=request.getSession(true);
    	//修改session的存在时间为20s
    	hs.setMaxInactiveInterval(5);
//    	hs.setAttribute("pass", "ok");
        hs.setAttribute("uname",username);
        hs.setAttribute("pass",password);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}

