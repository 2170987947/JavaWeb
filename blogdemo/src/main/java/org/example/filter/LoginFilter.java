package org.example.filter;

import org.example.model.JSONResponse;
import org.example.util.JSONUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/4/1 14:49
 */

/**
 * 配置用户统一会话管理的过滤器, 匹配所有请求路径
 * 服务端资源: /login 不用校验 session, 其他资源都要校验. 如果不通过, 返回 401, 响应内容随便.
 * 前端资源: /jsp/ 校验 session, 不通过重定向到登录页面
 *         /js/, /static/, /view/ 全部不校验
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 每次 http 请求匹配到过滤器路径时, 会执行该过滤器的 doFilter
     * 如果往下执行, 是调用 filterChain.doFilter(request, response)
     * 否则自行处理响应
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        // 获取当前请求的服务路径
        String servletPath = req.getServletPath();
        //不需要登录允许访问
        if (servletPath.startsWith("/js/") || servletPath.startsWith("/static/")
                || servletPath.startsWith("/view/") || servletPath.startsWith("/login")) {
            chain.doFilter(request, response);
        } else {
            // 获取 session 对象, 没有返回 null
            HttpSession session = req.getSession(false);
            // 验证用户, 如果没有登陆, 还需要根据前端或后端做不同的处理
            if (session == null || session.getAttribute("user") == null) {
                if (servletPath.startsWith("/jsp/")) {
                    resp.sendRedirect(basePath(req) + "/view/login.html");
                } else {
                    resp.setStatus(401);
                    resp.setCharacterEncoding("UTF-8");
                    resp.setContentType("application/json");
                    // 返回统一的 json 数据格式
                    JSONResponse json = new JSONResponse();
                    json.setCode("LOG000");
                    json.setMessage("用户没有登录, 不允许访问");
                    PrintWriter printWriter = resp.getWriter();
                    printWriter.println(JSONUtil.serialize(json));
                    printWriter.flush();;
                    printWriter.close();
                }
            } else {
                chain.doFilter(request, response);
            }
        }
    }

    /**
     * 根据 http 请求, 动态的获取访问路径 (服务路径之前的部分)
     */
    private static String basePath(HttpServletRequest req) {
        String schema = req.getScheme(); // http
        String host = req.getServerName(); // 主机域名或 ip
        int port = req.getServerPort(); // 服务器端口号
        String contextPath = req.getContextPath(); // 应用上下文路径
        return schema + "://" + host + ":" + port + contextPath;
    }

    @Override
    public void destroy() {

    }
}
