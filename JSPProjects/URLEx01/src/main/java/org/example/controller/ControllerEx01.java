package org.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model2.Action;
import org.example.model2.View1Action;
import org.example.model2.View2Action;

import java.io.IOException;

@WebServlet( urlPatterns = "*.do")
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
        //http://localhost:8080/프로젝트/view1.do
        //http://localhost:8080/프로젝트/view2.do

        System.out.println("doProcess()");

        //URL 정보
        System.out.println(req.getRequestURI());
        System.out.println(req.getContextPath());

        try {
            String path = req.getRequestURI().replaceAll(req.getContextPath(), "");
            System.out.println("요청 경로 : " + path);

            String url = "";
            Action action = null;

//            if (path.equals("/") || path.equals("/*.do") || path.equals("/view1.do")){
//                action = new View1Action();
//                action.execute(req, resp);
//
//                url = "/WEB-INF/views/view1.jsp";
//            } else if (path.equals("/view2.do")) {
//                action = new View2Action();
//                action.execute(req, resp);
//
//                url = "/WEB-INF/views/view2.jsp";
//            }

            RequestDispatcher dispatcher = req.getRequestDispatcher(url);
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            System.out.println("[에러] " + e.getMessage());
        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        }
    }
}
