package login2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Request2
 */
@WebServlet( name ="Request1",urlPatterns={"/Request1"})//使用注解方式部署servlet
public class Request2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Request2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
        //获取传过来的表单数据,根据表单中的name获取所填写的值
//		 String u=new String(request.getParameter("name").getBytes("ISO_8859_1"),"utf-8");
        String userName = request.getParameter("name");
        String pwd = request.getParameter("pw1");
        String pwd1 = request.getParameter("pw2");
        if(!pwd.equals(pwd1))
        {
        	 response.sendRedirect("/Login3/regist.jsp");
        }
        String sex = request.getParameter("sex");
        String many = request.getParameter("introduce");
        String[] hobbys = request.getParameterValues("hobby");
        String shengfen=request.getParameter("province");
        response.getWriter().write("<p>用户名："+userName+"</p>");
        response.getWriter().write("<p>密码："+pwd+"</p>");
        response.getWriter().write("<p>性别："+ sex+"</p>");
        response.getWriter().write("<p>来自："+ shengfen+"</p>");
        response.getWriter().write("<p>爱好：");
        for (int i = 0; hobbys!=null&&i < hobbys.length; i++) {
        	response.getWriter().write(hobbys[i]+"</p>");
        }
        response.getWriter().write("<p>自我介绍："+ many+"</p>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
