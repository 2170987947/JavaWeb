package login1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginCl
 */
@WebServlet("/LoginCl")
public class LoginCl1 extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		
		String u=null;
        u=request.getParameter("username");
        String p=null;
        p=request.getParameter("passwd");
        //�õ��ύ����֤��
       // String code = request.getParameter("code");
        //��ȡsession��֤��
       // HttpSession session = request.getSession();
       // String randStr = (String) session.getAttribute("randStr");
        response.setCharacterEncoding("gb2312");
		//if(u.equals("china")&&p.equals("123")&&code.equals(randStr)){

        if(u.equals("china")&&p.equals("123")){
			String keep = request.getParameter("keep");
			
			 if (keep!=null) {
	               //����cookie
	                Cookie cookie1 = new Cookie("username", u);
	                Cookie cookie2 = new Cookie("password", p);
	                //���ù���·��
	                cookie1.setPath(request.getContextPath());
	                cookie2.setPath(request.getContextPath());
	                //����cookie������ʱ��  ����
	                //cookie1.setMaxAge(2*7*24*60*60);
	                //cookie1.setMaxAge(2*7*24*60*60);
	                cookie1.setMaxAge(5);
	                cookie1.setMaxAge(5);
	                //��cookie��Ϣд�������
	                response.addCookie(cookie1);
	                response.addCookie(cookie2);
	            }
			
			HttpSession hs=request.getSession(true);
			hs.setMaxInactiveInterval(15);//15s���µ�¼
			hs.setAttribute("name", u);
			hs.setAttribute("pass", p);
			response.sendRedirect("/2020_1109login/Welcome?uname="+u+"&password="+p);
		}
		else{
			response.sendRedirect("/2020_1109login/login");
			}
	}
		public void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
			this.doGet(request, response);
		}
}
