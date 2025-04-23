package org.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model2.*;

import java.io.IOException;

@WebServlet(urlPatterns = "*.emot")
public class BoardController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    protected void doProcess(HttpServletRequest req, HttpServletResponse resp) {
        String path = req.getRequestURI().replaceAll(req.getContextPath(), "");

        try {
            String url = "";
            Action action = null;

            if(path.equals("/") || path.equals("/*.emot") || path.equals("/list.emot")) {
                action = new ListAction();
                action.execute(req, resp);

                url = "/WEB-INF/views/board_list1.jsp";

            } else if (path.equals("/write.emot")) {
                action = new WriteAction();
                action.execute(req, resp);

                url = "/WEB-INF/views/board_write1.jsp";

            } else if (path.equals("/write_ok.emot")) {
                action = new WriteOkAction();
                action.execute(req, resp);

                url = "/WEB-INF/views/board_write1_ok.jsp";

            } else if (path.equals("/view.emot")) {
                action = new ViewAction();
                action.execute(req, resp);

                url = "/WEB-INF/views/board_view1.jsp";

            } else if (path.equals("/delete.emot")) {
                action = new DeleteAction();
                action.execute(req, resp);

                url = "/WEB-INF/views/board_delete1.jsp";

            } else if (path.equals("/delete_ok.emot")) {
                action = new DeleteOkAction();
                action.execute(req, resp);

                url = "/WEB-INF/views/board_delete1_ok.jsp";

            } else if (path.equals("/modify.emot")) {
                action = new ModifyAction();
                action.execute(req, resp);

                url = "/WEB-INF/views/board_modify1.jsp";

            } else if (path.equals("/modify_ok.emot")) {
                action = new ModifyOkAction();
                action.execute(req, resp);

                url = "/WEB-INF/views/board_modify1_ok.jsp";

            }

            RequestDispatcher dispatcher = req.getRequestDispatcher(url);
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            System.out.println("[에러] " + e.getMessage());
        }

    }

}
