package org.example.model2;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model1.BoardDAO;
import org.example.model1.BoardTO;

import java.util.ArrayList;

public class ListAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("ListAction");

        BoardDAO dao = new BoardDAO();
        ArrayList<BoardTO> lists = dao.boardList();

        req.setAttribute("lists", lists);
    }
}
