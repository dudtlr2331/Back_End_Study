package org.example.fillter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpFilter;

import java.io.IOException;

//public class FirstFilter extends HttpFilter implements Filter {
public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {
        //필터의 초기화
        System.out.println("First Filter init");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        //전처리 구간
        System.out.println("First Filter 전처리");
        chain.doFilter(req, res);
        //후처리 구간
        System.out.println("First Filter 후처리");
    }

    @Override
    public void destroy() {
        // 필터의 마무리 - 자원반납
        System.out.println("FirstFillter destroy");
    }
}
