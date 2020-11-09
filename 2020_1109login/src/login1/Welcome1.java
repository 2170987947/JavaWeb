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
		
		
		//��ȡSession����Ϣ
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
		
		pw.println("<h1>������</h1>");
	/*	if(name==null){//�ж�ֱ�ӷ��ʻ�ӭ������û��Ƿ�Ϸ���Sessionû���û��������Ǵ��������ȥ�ģ�
			String cname="";
			String cpasswd="";
			Cookie[] allCookies=request.getCookies();//��ȡCookie
			if(allCookies!=null){
				for(int i=0;i<allCookies.length;i++){
					Cookie temp=allCookies[i];
					//��ȡCookie���û���������
					if(temp.getName().equals("myname"));
					{
						cname=temp.getValue();
					}
					if(temp.getName().equals("passwd"))
					{
						cpasswd=temp.getValue();
					}
				}
				if(!cname.equals("")&&!cpasswd.equals(""))//��ȡ�û���������֮���������û���֤���֣���֤��Ϸ���
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
		//pw.println("<h1>������</h1>");
		pw.println("Welcome name="+username+" "+"password="+password+"<br>");
		pw.println("�������:"+counter+"�η��ʱ���վ!");
        pw.println("<br>");
		
		pw.println("<a href='/2020_1109login/login'>�������½���</a><br>");
		
		Cookie[] cookies = request.getCookies();
        if(cookies!=null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("lastAccessTime")) {
                    pw.write("���ϴη��ʵ�ʱ���ǣ�");
                    Long lastAccessTime = Long.parseLong(cookies[i].getValue());
                    Date date = new Date(lastAccessTime);
                    pw.write(date.toLocaleString());
                }
            }
        }
       //�û����ʹ������������û��ķ���ʱ�䣬�洢��cookie�У�Ȼ���͵��ͻ��������
        Cookie cookie=new Cookie("lastAccessTime",System.currentTimeMillis()+"");
        //����cookie����Ч��Ϊ1min
        cookie.setMaxAge(60);
        //��cookie������ӵ�response�����У����������������response�����е�����ʱ
        // �ͻ��cookieҲ���뵽�ͻ��������
        response.addCookie(cookie);
	}
	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		this.doGet(request, response);

	}
	
}