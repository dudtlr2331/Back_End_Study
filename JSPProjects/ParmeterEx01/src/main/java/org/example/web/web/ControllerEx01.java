package org.example.web.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/controller")
public class ControllerEx01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    protected void doProcess(HttpServletRequest req, HttpServletResponse resp) {
        //http://localhost:8080/경로/controller           - view1.jsp
        //http://localhost:8080/경로/controller?path=view1           - view1.jsp
        //http://localhost:8080/경로/controller?path=view2           - view2.jsp

        try {
            String path = req.getParameter("path");

            String url = "";
            if( path == null || path.equals("") || path.equals("view1") ) {
                url = "view1.jsp";
            } else if( path.equals("view2") ) {
                url = "view2.jsp";
            }

            // forward 액션태그와 같은 기능
            RequestDispatcher dispatcher = req.getRequestDispatcher(url);
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            System.out.println("[에러] " + e.getMessage());
        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        }
    }
}
