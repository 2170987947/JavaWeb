package org.example.servlet;

import org.example.dao.ArticleDAO;
import org.example.model.Article;
import org.example.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/4/1 11:10
 */
@WebServlet("/articleList")
public class ArticleListServlet extends AbstractBaseServlet {
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//        return null;
        // 获取 session , 如果没有就返回 null
        HttpSession session = req.getSession(false);
//        if (session == null) {
//            throw new AppException("ART002", "用户没有登录, 不允许访问");
//        }
//        // 获取登录时创建的 session 保存的用户信息
        User user = (User) session.getAttribute("user");
//        if (user == null) {
//            throw new AppException("APT003", "会话异常, 请重新登录");
//        }
        // 用户已登录, 并且保存了用户信息
        List<Article> articles = ArticleDAO.queryByUserId(user.getId());
        return articles;
    }

}
