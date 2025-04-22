package org.example.servletex02;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(urlPatterns = { "/servlet01", "/servlet02" })
@WebServlet(urlPatterns = "*.do")
public class ServletEx01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("doProcess()호출");
        try {
            resp.setContentType("text/html;charset=UTF-8");

            StringBuilder sbHtml = new StringBuilder();
            sbHtml.append("<html>");
            sbHtml.append("<head>");
            sbHtml.append("<title>Servlet Example</title>");
            sbHtml.append("</head>");
            sbHtml.append("<body>");
            sbHtml.append("<h1>Servlet Example</h1>");
            sbHtml.append("</body>");
            sbHtml.append("</html>");

            PrintWriter out = resp.getWriter();
            out.println(sbHtml.toString());
            out.close();
        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        }
    }

}
