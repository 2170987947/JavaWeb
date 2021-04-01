package org.example.dao;

import org.example.exception.AppException;
import org.example.model.Article;
import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/4/1 11:20
 */
public class ArticleDAO {
    public static List<Article> queryByUserId(Integer userId) {
        List<Article> articles = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = DBUtil.getConnection();
            String sql = "select id, title from article where user_id = ?";
            ps = c.prepareStatement(sql);
            // 设置占位符
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Article article = new Article();
                // 结果集取值设置在文章对象中
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                // 添加到文章列表中
                articles.add(article);
            }
            return articles;
        } catch (Exception e) {
            throw new AppException("ART001", "查询文章列表出错", e);
        } finally {
            DBUtil.close(c, ps, rs);
        }
    }

    public static int insert(Article article) {
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = DBUtil.getConnection();
            String sql = "insert into article(title, content, user_id) value (? , ?, ?);";
            ps = c.prepareStatement(sql);
            // 设置占位符
            ps.setString(1, article.getTitle());
            ps.setString(2, article.getContent());
            ps.setInt(3, article.getUserId());
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new AppException("APT005", "新增文章操作出错", e);
        } finally {
            DBUtil.close(c, ps);
        }
    }

    public static int delete(String[] split) {
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = DBUtil.getConnection();
            StringBuilder sql = new StringBuilder("delete from article where id in (");
            for (int i = 0; i < split.length; i++) {
                if (i != 0) {
                    sql.append(",");
                }
                sql.append("?");
            }
            sql.append(")");

            ps = c.prepareStatement(sql.toString());
            // 设置占位符
            for (int i = 0; i < split.length; i++) {
                ps.setInt(i + 1, Integer.parseInt(split[i]));
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new AppException("ART004", "文章删除操作失败", e);
        } finally {
            DBUtil.close(c, ps);
        }
    }

    public static Article query(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = DBUtil.getConnection();
            String sql = "select id, title, content from article where id = ?";
            ps = c.prepareStatement(sql);
            // 设置占位符
            ps.setInt(1, id);
            rs = ps.executeQuery();
            Article article = null;
            while (rs.next()) {
                article = new Article();
//                article.setId(id);
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setContent(rs.getString("content"));
            }
            return article;
        } catch (Exception e) {
            throw new AppException("ART006", "查询文章出错", e);
        } finally {
            DBUtil.close(c, ps, rs);
        }
    }

    public static int update(Article article) {
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = DBUtil.getConnection();
            String sql = "update article set title = ?, content = ? where id = ?";
            ps = c.prepareStatement(sql);
            // 设置占位符
            ps.setString(1, article.getTitle());
            ps.setString(2, article.getContent());
            ps.setInt(3, article.getId());
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new AppException("ART007", "修改文庄操作出错", e);
        } finally {
            DBUtil.close(c, ps);
        }
    }
}
