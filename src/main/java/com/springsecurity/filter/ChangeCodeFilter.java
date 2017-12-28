package com.springsecurity.filter;

import com.springsecurity.Wrapper.ParameterRequestWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 改变Request里面对象的值，ParamterRequestWrapper 通过继承 HttpServletRequestWrapper
 *  根据不同情况重写 getParameter getParameterValues getParameterMap等方法
 *
 */

@WebFilter(urlPatterns = "/print/*", filterName = "ChangeCodeFilter")
public class ChangeCodeFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String[] s = servletRequest.getParameterMap().get("name");
        System.out.println(s);
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        ParameterRequestWrapper requestWrapper = new ParameterRequestWrapper(request);
        filterChain.doFilter(requestWrapper ,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
