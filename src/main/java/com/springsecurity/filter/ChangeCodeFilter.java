package com.springsecurity.filter;

import com.springsecurity.Wrapper.ParameterRequestWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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
