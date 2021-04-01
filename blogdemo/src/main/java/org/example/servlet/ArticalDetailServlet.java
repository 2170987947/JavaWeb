package org.example.servlet;

import org.example.dao.ArticleDAO;
import org.example.model.Article;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/4/1 13:58
 */
@WebServlet("/articleDetail")
public class ArticalDetailServlet extends AbstractBaseServlet {
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String id = req.getParameter("id");
        Article article = ArticleDAO.query(Integer.parseInt(id));
        return article;
    }
}
