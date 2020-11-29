package Servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.book;

/**
 * Servlet implementation class Initservlet
 */
public class Initservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Initservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  book book1=new book();
		  book1.setBookname("数据结构");
		  book1.setBookno("1");
		  book book2=new book();
		  book2.setBookname("操作系统");
		  book2.setBookno("2");
		  book book3=new book();
		  book3.setBookname("Java Web");
		  book3.setBookno("3");
		  HashMap<String,book> allbook=new HashMap<String,book>();
		  allbook.put("1", book1);
		  allbook.put("2", book2);
		  allbook.put("3", book3);
		  request.getSession().setAttribute("allbook", allbook);
		  response.sendRedirect("showAllBook.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
