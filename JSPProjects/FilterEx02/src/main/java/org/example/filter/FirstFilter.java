package org.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(urlPatterns = "*.jsp")
public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FirstFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FirstFilter 전처리");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("FirstFilter 후처리");
    }

    @Override
    public void destroy() {
        System.out.println("FirstFilter destroy");
    }
}
