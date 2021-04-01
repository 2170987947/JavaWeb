package org.example.servlet;

import org.example.exception.AppException;
import org.example.model.JSONResponse;
import org.example.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/30 12:07
 */
public abstract class AbstractBaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        // 设置响应体的数据类型
        resp.setContentType("application/json");
//            resp.setContentType("text/html");
        // session 会话管理: 除登录和注册接口, 其他都需要登陆后访问
        // 获取请求服务路径
        // req.getServletPath();
        // TODO

        JSONResponse json = new JSONResponse();
        try {
            // 调用子类重写的方法
            Object data = process(req, resp);
            // 子类 process 方法执行完没有抛异常
            json.setSuccess(true);
            json.setData(data);
        } catch (Exception e) {
            // 异常如何处理 ?
            // JDBC 的异常 SQLException, JSON 处理的异常.
            // 自定义异常返回错误
            e.printStackTrace();
            // json.setSuccess(false) 不用设置了, 因为new 的时候就是 false.
            String code = "UNKOWN";
            String s = "未知的错误";
            if (e instanceof AppException) {
                code = ((AppException) e).getCode();
                s = e.getMessage();
            }
            json.setCode(code);
            json.setMessage(s);
        }
        PrintWriter pw = resp.getWriter();
        pw.println(JSONUtil.serialize(json));
        pw.flush();
        pw.close();
    }

    protected abstract Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
