package ser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet
 */
@WebServlet("/servlet")
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public servlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		//获取登录名
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String conpassword=request.getParameter("conpassword");
		String sex=request.getParameter("sex");
		String hobbys[]=request.getParameterValues("hobby");
		PrintWriter printWriter=response.getWriter();
		//输出
		System.out.print(username+password);
		if("china".equals(username)&&"123".equals(password)&&"123".equals(conpassword)){
			printWriter.write("username:"+username+"\t\n password:"+password);
			System.out.println("\n");
			printWriter.write("性别:"+sex);
			System.out.println("\n");
			printWriter.write("兴趣爱好:");
			for(String s:hobbys){
				response.getWriter().print(s);
				response.getWriter().print("\n");
			}
			printWriter.close();
			
		}
		else {
			printWriter.write("输入有误!");
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
}