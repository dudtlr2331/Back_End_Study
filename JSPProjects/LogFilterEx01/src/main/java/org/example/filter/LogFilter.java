package org.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebFilter(urlPatterns = "*.jsp")
public class LogFilter implements Filter {
    private PrintWriter writer;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            writer = new PrintWriter(new FileWriter("c:/java/log.txt", true),true);
        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        }
    }

    @Override
    public void destroy() {
        if(writer != null) writer.close();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 전처리 구간에 로그 기록
        writer.printf("현재시간 : %s %n", new Date().toLocaleString());
        writer.printf("접속한 클라이언트 주소 : %s %n", servletRequest.getRemoteAddr());

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
