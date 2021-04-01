package org.example.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.example.exception.AppException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/30 12:26
 */
public class DBUtil {

    // final 引用不能改变
    private static final String URL = "jdbc:mysql://localhost:3306/blogdemo?user=root&password=123456&useUnicode=true&characterEncoding=UTF-8&useSSL=false";

    private static final DataSource DS = new MysqlDataSource();

    /**
     * 工具类提供数据库 JDBC 操作
     * 不足: 1. static 代码块出现错误,. NoClassFoundError 表示类可以找到, 但是类加载失败
     *         ClassNotFoundException: 找不到类
     *      2. 学了多线程之后, 可能会采取双重校验锁的单例模式来创建 DataSource
     *      3. 工具类设计上不是最优的, 数据库框架 ORM 框架, 都是模板模式设计的
     */
    static {
        ((MysqlDataSource) DS).setURL(URL);
    }

    public static Connection getConnection() {
        try {
            return DS.getConnection();
        } catch (SQLException e) {
            // 抛自定义异常
            throw new AppException("DB001","获取数据库连接异常", e);
        }
    }

    public static void close(Connection c, Statement s) {
        close(c, s, null);
    }

    public static void close(Connection c, Statement s, ResultSet r) {
        try {
            if (c != null) {
                c.close();
            }
            if (s != null) {
                s.close();
            }
            if (r != null) {
                r.close();
            }
        } catch (SQLException e) {
            throw new AppException("DB002", "数据库释放资源出错", e);
        }
    }
}
