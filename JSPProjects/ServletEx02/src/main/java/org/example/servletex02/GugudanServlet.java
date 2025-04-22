package org.example.servletex02;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet( urlPatterns = "/gugudan_ok" )
public class GugudanServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    protected void doProcess(HttpServletRequest req, HttpServletResponse resp) {

        String startDan = req.getParameter("startdan" );
        String endDan = req.getParameter("enddan" );

        //System.out.println( startDan + " - " + endDan );

        resp.setContentType( "text/html; charset=utf-8" );

        StringBuilder sbHtml = new StringBuilder();
        sbHtml.append( "<!DOCTYPE html>" );
        sbHtml.append( "<head>" );
        sbHtml.append( "<meta charset='utf-8'>" );
        sbHtml.append( "<title>Insert title here</title>" );
        sbHtml.append( "</head>" );
        sbHtml.append( "<body>" );

        int iStartDan = Integer.parseInt( startDan );
        int iEndDan = Integer.parseInt( endDan );

        sbHtml.append( "<table border='1' cellspacing='0'>" );
        for ( int i=iStartDan ; i<=iEndDan; i++ ) {
            sbHtml.append( "<tr>" );
            for ( int j=1 ; j<=9 ; j++ ) {
                sbHtml.append( "<td>" + i + " X " + j + "=" + (i*j) + "</td>" );
            }
            sbHtml.append( "</tr>" );
        }
        sbHtml.append( "</table>" );

        sbHtml.append( "</body>" );
        sbHtml.append( "</html>" );

        try {
            PrintWriter out = resp.getWriter();
            out.print( sbHtml.toString() );
            out.close();
        } catch (IOException e) {
            System.out.println( "[에러] " + e.getMessage() );
        }
    }
}
