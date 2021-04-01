package org.example.servlet;

import org.example.dao.ArticleDAO;
import org.example.exception.AppException;
import org.example.model.Article;
import org.example.model.User;
import org.example.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.InputStream;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/4/1 11:42
 */
@WebServlet("/articleAdd")
public class ArticleAddServlet extends AbstractBaseServlet {
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        // 获取 session
        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");
        // 请求数据类型是 application/json, 需要使用输入流获取
        InputStream is = req.getInputStream();
        Article article = JSONUtil.deserialize(is, Article.class);
        article.setUserId(user.getId());
        int num = ArticleDAO.insert(article);
        return null;
    }
}
