package org.example.servletex01;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;

public class ServletEx01 extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service() 호출");

//        res.setContentType("text/html;charset=utf-8");
//        PrintWriter out = res.getWriter();
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>ServletEx01</title>");
//        out.println("</head>");
//        out.println("<body>");
//        out.println("<b>Hello World</b>");
//        out.println("</body>");
//        out.println("</html>");

        StringBuilder sbHtml = new StringBuilder();
        sbHtml.append("<html>");
        sbHtml.append("<head>");
        sbHtml.append("<title>ServletEx01</title>");
        sbHtml.append("</head>");
        sbHtml.append("<body>");
        sbHtml.append("<b>Hello World</b>");
        sbHtml.append("</body>");
        sbHtml.append("</html>");

        PrintWriter out = res.getWriter();
        out.println(sbHtml.toString());
        out.close();
    }
}
