package Servlet;


import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.book;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		HttpSession session=request.getSession();
		HashMap books=(HashMap) session.getAttribute("books");
		String bookno=request.getParameter("bookno");
		String bookname=request.getParameter("bookname");
		String strBooknumber=request.getParameter("booknumber");
		book booki=new book();
		booki.setBookno(bookno);
		booki.setBookname(bookname);
		int booknumber=Integer.parseInt(strBooknumber);
		booki.setBooknumber(booknumber);
		books.put(bookno, booki);
		response.sendRedirect("showCart.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
