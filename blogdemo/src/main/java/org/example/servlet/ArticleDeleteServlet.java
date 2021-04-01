package org.example.servlet;

import org.example.dao.ArticleDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/4/1 13:20
 */
@WebServlet("/articleDelete")
public class ArticleDeleteServlet extends AbstractBaseServlet {
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String ids = req.getParameter("ids");
        int num = ArticleDAO.delete(ids.split(","));
        return null;
    }
}
