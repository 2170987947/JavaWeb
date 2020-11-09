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
@WebServlet( name ="LoginServlet",urlPatterns={"/LoginServlet"})//ʹ��ע�ⷽʽ����servlet
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
		//��ȡ7�����Ƿ����¼
		String day7 = request.getParameter("chkCookie");
		if(null != day7){
			//����cookie
			Cookie cookie  = new Cookie("cook_name",username);
			Cookie cookie1=new Cookie("passwd",password);
			//����Cookie������
			cookie.setMaxAge(5);//��Ч��6��
			cookie1.setMaxAge(5);
			//����7�����¼
			//cookie.setMaxAge(3600 * 24 *7);
			//cookie1.setMaxAge(3600 * 24 *7);
			//д��cookie�������
			response.addCookie(cookie);
			response.addCookie(cookie1);
		}
	
		
		response.sendRedirect("cookieUser2.jsp");
		HttpSession hs=request.getSession(true);
    	//�޸�session�Ĵ���ʱ��Ϊ20s
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

