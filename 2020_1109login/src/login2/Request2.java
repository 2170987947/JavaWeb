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
@WebServlet( name ="Request1",urlPatterns={"/Request1"})//ʹ��ע�ⷽʽ����servlet
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
        //��ȡ�������ı�����,���ݱ��е�name��ȡ����д��ֵ
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
        response.getWriter().write("<p>�û�����"+userName+"</p>");
        response.getWriter().write("<p>���룺"+pwd+"</p>");
        response.getWriter().write("<p>�Ա�"+ sex+"</p>");
        response.getWriter().write("<p>���ԣ�"+ shengfen+"</p>");
        response.getWriter().write("<p>���ã�");
        for (int i = 0; hobbys!=null&&i < hobbys.length; i++) {
        	response.getWriter().write(hobbys[i]+"</p>");
        }
        response.getWriter().write("<p>���ҽ��ܣ�"+ many+"</p>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
