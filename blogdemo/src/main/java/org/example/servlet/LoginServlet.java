package org.example.servlet;

import org.example.dao.LoginDAO;
import org.example.exception.AppException;
import org.example.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/30 12:24
 */
@WebServlet("/login")
public class LoginServlet  extends  AbstractBaseServlet {
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = LoginDAO.query(username);
        if (user == null) {
            throw new AppException("LOG002", "用户不存在");
        }
        if (!user.getPassword().equals(password)) {
            throw new AppException("LOG003", "用户名或密码错误");
        }
        // 登陆成功, 创建session
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        return null;

        // 模拟数据库账号密码的校验
//        if ("abc".equals(username)) {
////            resp.sendRedirect("jsp/articleList.jsp");
//            return null;
//        } else {
//            throw new AppException("LOG001", "用户名密码错误");
//        }
//    }
    }
}
