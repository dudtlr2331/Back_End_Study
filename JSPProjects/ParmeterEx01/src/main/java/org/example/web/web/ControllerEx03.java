package org.example.web.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.web.model2.View1Action;
import org.example.web.model2.Action;
import org.example.web.model2.View2Action;

import java.io.IOException;

@WebServlet(urlPatterns = "/controller3")
public class ControllerEx03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    protected void doProcess(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String path = req.getParameter( "path" );

            String url = "";
            Action action = null;

            if ( path == null || path.equals( "" ) || path.equals( "view1") ) {
                // Model 호출
                //Action action = new View1Action();
                action = new View1Action();
                action.execute(req, resp);

                // View 연결
                url = "/WEB-INF/views/view1.jsp";
            } else if ( path.equals( "view2") ) {
                //Action action = new View2Action();
                action = new View2Action();
                action.execute(req, resp);

                url = "/WEB-INF/views/view2.jsp";
            }

            RequestDispatcher dispatcher = req.getRequestDispatcher( url );
            dispatcher.forward( req, resp );

        } catch (ServletException e) {
            System.out.println( "[에러] " + e.getMessage() );
        } catch (IOException e) {
            System.out.println( "[에러] " + e.getMessage() );
        }
    }
}
