package org.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(urlPatterns = "*.jsp")
public class SecondFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("SecondFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("SecondFilter 전처리");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("SecondFilter 후처리");
    }

    @Override
    public void destroy() {
        System.out.println("SecondFilter destroy");
    }
}
